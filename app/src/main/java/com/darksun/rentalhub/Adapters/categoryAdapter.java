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
import com.darksun.rentalhub.R;
import com.darksun.rentalhub.DataClass.categoryModel;
import com.darksun.rentalhub.not_found_error;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class categoryAdapter extends FirebaseRecyclerAdapter<categoryModel,categoryAdapter.myviewHolder> {

    public categoryAdapter(@NonNull FirebaseRecyclerOptions<categoryModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull categoryModel model) {
        holder.categoryName.setText(model.getCategory_name());
        Glide.with(holder.circleImageView.getContext()).load(model.getCategory_Image_ID()).into(holder.circleImageView);
        holder.circleImageView.setOnClickListener(v -> v.getContext().startActivity(new Intent(v.getContext(), not_found_error.class)));
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, parent, false);
        return new myviewHolder(view);
    }

    static class myviewHolder extends RecyclerView.ViewHolder {
        ImageView circleImageView; //chnage
        TextView categoryName;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.category_image_ID);
            categoryName = itemView.findViewById(R.id.category_name_ID);
        }
    }
}
