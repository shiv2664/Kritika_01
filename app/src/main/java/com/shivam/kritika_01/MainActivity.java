package com.shivam.kritika_01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.shivam.kritika_01.Adapters.Adapter;
import com.shivam.kritika_01.UtilsClasses.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference sellerRef;
    private CollectionReference ProductIdRef;

    FirebaseAuth firebaseAuth;

    RecyclerView mRecyclerView;
    List<Products> mProducts;
    Adapter adapter;

    Toolbar toolbar;
    String TAG="MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.myToolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shop");

        firebaseAuth=FirebaseAuth.getInstance();
        String Uid=firebaseAuth.getUid();


        mRecyclerView = findViewById(R.id.mRecyclerView);
        mProducts=new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(this,mProducts);
        mRecyclerView.setAdapter(adapter);

        sellerRef=db.collection("Sellers");

        ProductIdRef=db.collection("Sellers").document("New Delhi").collection("New Delhi");
        Query query=ProductIdRef.whereEqualTo("City_Name","New Delhi");
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Log.d(TAG,"Task Complete");
                if (task.isSuccessful()){
                    Log.d(TAG,"Task Successful");
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Products products =document.toObject(Products.class);
                        mProducts.add(products);
                        adapter.notifyDataSetChanged();
                        Log.d(TAG,""+products.getCityName()+"  "+mProducts.size());
                    }
                    Log.d(TAG,String.valueOf(mProducts.size()));
                }else {
                    Toast.makeText(MainActivity.this, "Failed to load Data", Toast.LENGTH_SHORT).show();
                }

            }
        });

       /*
        sellerRef=db.collection("Sellers");
        Query query =sellerRef.whereEqualTo("City_Name","New Delhi");
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Products products =document.toObject(Products.class);
                        mProducts.add(products);
                        adapter.notifyDataSetChanged();
                        Log.d(TAG,""+products.getCityName()+"  "+mProducts.size());
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Failed to load Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        */


    }
}