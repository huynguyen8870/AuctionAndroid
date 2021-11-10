package com.example.mjolnirauctiononline.view.user;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mjolnirauctiononline.ProductDetail;
import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Product;
import com.example.mjolnirauctiononline.ulti.ProductAdapter;
import com.example.mjolnirauctiononline.ulti.ProductDataService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Product> products;
    private ProductAdapter productAdapter;
    private Context context = getContext();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar balanceTb = (Toolbar) inflatedView.findViewById(R.id.home_toolbar);
        balanceTb.setTitle("Home");
        return inflatedView;
    }

/*    @RequiresApi(api = Build.VERSION_CODES.O)*/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_product_list);

        final ProductDataService productDataService = new ProductDataService(getActivity().getApplicationContext());

        productDataService.getProduct(new ProductDataService.ProductResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(ArrayList<Product> productList) {
                productAdapter = new ProductAdapter(getContext() ,productList);
                recyclerView.setAdapter(productAdapter);
            }
        });
    }
}