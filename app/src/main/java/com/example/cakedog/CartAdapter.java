package com.example.cakedog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView txtCartTitle, txtCartValor;

        public ViewHolder(View itemView) {
            super(itemView);

            txtCartTitle = (AppCompatTextView) itemView.findViewById(R.id.txtCartTitle);
            txtCartValor = (AppCompatTextView) itemView.findViewById(R.id.txtCartValor);
        }
    }

    private List<Product> productToCart;

    public CartAdapter(List<Product> product) {
        productToCart = product;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {
        Product product = productToCart.get(position);

        AppCompatTextView txtCartTitle, txtCartValor;
        txtCartTitle = holder.txtCartTitle;
        txtCartValor = holder.txtCartValor;
        txtCartTitle.setText(product.getProductName());
        txtCartValor.setText(String.format(Double.toString(product.getProductPrice())));
    }

    @Override
    public int getItemCount() {
        return productToCart.size();
    }

}
