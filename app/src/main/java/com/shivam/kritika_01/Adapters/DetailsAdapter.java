package com.shivam.kritika_01.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shivam.kritika_01.R;
import com.shivam.kritika_01.UtilsClasses.ProductImages;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private Context mContext;
    private List<ProductImages> productImagesList;

    public DetailsAdapter(Context mContext, List<ProductImages> productImagesList) {
        this.mContext = mContext;
        this.productImagesList = productImagesList;
    }

    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.details_view,parent,false);
        return new DetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView PImages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            PImages=itemView.findViewById(R.id.pdImage);
        }
    }
}
