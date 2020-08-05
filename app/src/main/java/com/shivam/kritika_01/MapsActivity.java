package com.shivam.kritika_01;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final int DEFAULT_ZOOM = 15;
    public static final int PERMISSION_REQUEST_CODE = 9001;
    private static final int PLAY_SERVICES_ERROR_CODE = 9002;
    public static final String TAG = "MapDebug";
    private boolean mLocationPermissionGranted;

    private double Delhi_LAT = 28.630597;
    private double Delhi_LONG= 77.218978;


    private GoogleMap mGoogleMap;


    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        SupportMapFragment supportMapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);
        supportMapFragment.getMapAsync(this);


        //isServicesOk();
        //initGoogleMap();
        //geoLocate();

       // SupportMapFragment supportMapFragment=SupportMapFragment.newInstance();
       // supportMapFragment.getMapAsync(this::onMapReady);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Showing map", Toast.LENGTH_SHORT).show();

        mGoogleMap=googleMap;
       // gotoLocation(Delhi_LAT,Delhi_LONG);
        showMarker(Delhi_LAT,Delhi_LONG);

        geoLocate();

         // mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        // mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
       // mGoogleMap.getUiSettings().setMapToolbarEnabled(true);



    }


    private void geoLocate() {
        //hideSoftKeyboard(view);

        //String locationName = mSearchAddress.getText().toString();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {

            //28.628170, 77.208960
            //28.630597, 77.218978
            List<Address> addressList = geocoder.getFromLocation(Delhi_LAT, Delhi_LONG, 3);

            if (addressList.size() > 0) {
                Address address = addressList.get(0);

                gotoLocation(address.getLatitude(), address.getLongitude());

                showMarker(address.getLatitude(), address.getLongitude());

                Toast.makeText(this, address.getLocality(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "geoLocate: Locality: " + address.getLocality()+" "+address.getSubLocality());
            }

            for (Address address : addressList) {
                Log.d(TAG, "geoLocate: Address: " + address.getAddressLine(address.getMaxAddressLineIndex()));
            }


        } catch (IOException e) {


        }


    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initGoogleMap() {

        if(isServicesOk()){
            if(checkLocationPermission()){
                Toast.makeText(this, "Ready to Map", Toast.LENGTH_SHORT).show();
                SupportMapFragment supportMapFragment= SupportMapFragment.newInstance();

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.map_fragment,supportMapFragment)
                        .commit();

                supportMapFragment.getMapAsync(this);
            }else{
                requestLocationPermission();
            }
        }


    }

    private boolean checkLocationPermission() {

        return ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;

    }

    private boolean isServicesOk() {

        GoogleApiAvailability googleApi = GoogleApiAvailability.getInstance();

        int result= googleApi.isGooglePlayServicesAvailable(this);

        if(result == ConnectionResult.SUCCESS){
            return true;
        }else if(googleApi.isUserResolvableError(result)){
            Dialog dialog=googleApi.getErrorDialog(this,result,PLAY_SERVICES_ERROR_CODE, task->
                    Toast.makeText(this, "Dialog is cancelled by User", Toast.LENGTH_SHORT).show());
            dialog.show();
        }else{
            Toast.makeText(this, "Play services are required by this application", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
            }
        }
    }


    private void gotoLocation(double lat,double lng){

        LatLng latLng=new LatLng(lat,lng);

        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latLng,DEFAULT_ZOOM);

        mGoogleMap.moveCamera(cameraUpdate);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    private void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void showMarker(double lat, double lng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(lat, lng));
        mGoogleMap.addMarker(markerOptions);
    }





}

