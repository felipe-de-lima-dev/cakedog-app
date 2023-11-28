package com.example.cakedog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<Product> productToCart = new ArrayList<>();
    private LayoutInflater inflater;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return productToCart.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*
        Product currentItem = productToCart.get(position);
        holder.itemProductName.setText(currentItem.getProductName());
        holder.itemQuantity.setText(String.valueOf(currentItem.getProductQuantity()));
        holder.itemPrice.setText(String.format("$%.2f", currentItem.getProductPrice()));

        holder.removeButton.setOnClickListener(v -> {
            shoppingCart.remove(position);
            notifyItemRemoved(position);
        });

        holder.updateButton.setOnClickListener(v -> {
            int newQuantity = Integer.parseInt(holder.itemQuantity.getText().toString());
            currentItem.setQuantity(newQuantity);
            notifyItemChanged(position);
        });*/
    }

    // Implemente os métodos necessários, como onCreateViewHolder e onBindViewHolder

    static class ViewHolder extends RecyclerView.ViewHolder {
        // Adicione as referências aos elementos do layout do item aqui

        ViewHolder(View itemView) {
            super(itemView);
            // Inicialize as referências aos elementos do layout do item aqui
        }
    }
}
