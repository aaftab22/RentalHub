package com.example.rentalhub.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rentalhub.DataClass.Product_Model;
import com.example.rentalhub.R;
import com.example.rentalhub.productPage_Activity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import io.grpc.Context;

public class product_adapter extends FirebaseRecyclerAdapter<Product_Model, product_adapter.productViewHolder> {
    private Context context;

    public product_adapter(@NonNull FirebaseRecyclerOptions<Product_Model> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull productViewHolder holder, int position, @NonNull Product_Model model) {
        holder.product_name.setText("Name :" + model.getProduct_Name());
        holder.product_rent.setText("Rent :" + model.getProduct_Rent());
        holder.product_city.setText(" " + model.getProduct_City());
        Glide.with(holder.product_imageView.getContext()).load(model.getP_image()).into(holder.product_imageView);

        holder.product_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), productPage_Activity.class);
                intent.putExtra("name",model.getProduct_Name());
                intent.putExtra("rent",model.getProduct_Rent());
                intent.putExtra("deposite",model.getDeposit());


                v.getContext().startActivity(intent);

            }
        });
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);

        return new productViewHolder(view);
    }

    class productViewHolder extends RecyclerView.ViewHolder {
        ImageView product_imageView;
        TextView product_name, product_rent , product_city;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            product_imageView = itemView.findViewById(R.id.product_main_image);
            product_name = itemView.findViewById(R.id.product_name);
            product_rent = itemView.findViewById(R.id.product_rent);
            product_city = itemView.findViewById(R.id.product_city);
        }
    }
}
