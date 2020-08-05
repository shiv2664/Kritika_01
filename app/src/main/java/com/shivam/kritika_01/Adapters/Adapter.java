package com.shivam.kritika_01.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shivam.kritika_01.MainActivity;
import com.shivam.kritika_01.ProductDetailsActivity;
import com.shivam.kritika_01.R;
import com.shivam.kritika_01.UtilsClasses.Products;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private List<Products> mProducts;

    String TAG = "AdTag";

    public Adapter(Context mContext, List<Products> mProducts) {
        this.mContext = mContext;
        this.mProducts= mProducts;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.grid_view_layout,parent,false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Products products=mProducts.get(position);
        holder.brandName.setText(products.getBrand());
        holder.productName.setText(products.getProduct_Name());
        holder.SubLocality.setText(products.getShopAddrs());
        holder.Colour.setText(products.getColour());
        holder.productPrize.setText(products.getPrize());

        if (products.getThumbnailUrl().equals("default")){
            holder.gridIcon.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(mContext).load(products.getThumbnailUrl()).into(holder.gridIcon);
        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mContext, ProductDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mProducts.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Ratings,brandName,productName,productPrize,SubLocality,Colour;
        public ImageView gridIcon;
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gridIcon=itemView.findViewById(R.id.imageView2);

            brandName=itemView.findViewById(R.id.brandName);
            productName=itemView.findViewById(R.id.productName);
            Ratings=itemView.findViewById(R.id.Ratings);
            productPrize=itemView.findViewById(R.id.productPrize);
            SubLocality=itemView.findViewById(R.id.SubLocality);
            Colour=itemView.findViewById(R.id.Colour);
            relativeLayout=itemView.findViewById(R.id.r1);


        }
    }


}
