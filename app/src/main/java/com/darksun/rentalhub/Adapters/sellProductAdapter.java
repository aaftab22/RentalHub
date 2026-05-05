package com.darksun.rentalhub.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.darksun.rentalhub.DataClass.sellProductModel;
import com.darksun.rentalhub.R;
import com.darksun.rentalhub.addProductActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class sellProductAdapter extends FirebaseRecyclerAdapter<sellProductModel,sellProductAdapter.myviewHolder> {

    public sellProductAdapter(@NonNull FirebaseRecyclerOptions<sellProductModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull sellProductAdapter.myviewHolder holder, int position, @NonNull sellProductModel model) {
        holder.categoryName.setText(model.getCategory_name());
        Glide.with(holder.circleImageView.getContext()).load(model.getCategory_Image_ID()).into(holder.circleImageView);
        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), addProductActivity.class));
            }
        });
    }

    @NonNull
    @Override
    public sellProductAdapter.myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, parent, false);
        return new sellProductAdapter.myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {
        ImageView circleImageView; //chnage
        TextView categoryName;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.category_image_ID);
            categoryName = itemView.findViewById(R.id.category_name_ID);
        }
    }


}
