package com.example.mjolnirauctiononline.view.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Bid;
import com.example.mjolnirauctiononline.ulti.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {
    private List<Bid> orders;
    private RecyclerView rv_order_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView =  inflater.inflate(R.layout.fragment_order, container, false);

        Toolbar balanceTb = (Toolbar) inflatedView.findViewById(R.id.order_toolbar);
        balanceTb.setTitle("Order History");

        return inflatedView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orders = new ArrayList<>();
        orders.add(new Bid("B-281021-081900","P-01","C-01","28/10/2021 08:20:23",100,"Process"));
        orders.add(new Bid("B-281021-081900","P-02","C-01","28/10/2021 08:20:23",100,"Success"));
        orders.add(new Bid("B-281021-081900","P-03","C-01","28/10/2021 08:20:23",100,"Fail"));
        orders.add(new Bid("B-281021-081900","P-04","C-01","28/10/2021 08:20:23",100,"Process"));

        OrderAdapter orderAdapter = new OrderAdapter(getContext(),orders);
        rv_order_list = view.findViewById(R.id.rv_order_list);
        rv_order_list.setAdapter(orderAdapter);

    }
}