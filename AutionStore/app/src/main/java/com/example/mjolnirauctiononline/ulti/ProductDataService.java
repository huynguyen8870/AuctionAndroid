package com.example.mjolnirauctiononline.ulti;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mjolnirauctiononline.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProductDataService {
    private final Context context;

    public ProductDataService(Context context) {
        this.context = context;
    }

    public interface ProductResponseListener{
        void onError(String message);

        void onResponse(ArrayList<Product> productList);
    }

    public void getProduct(ProductResponseListener productResponseListener){
        String url = "http://192.168.1.48:8080/api/product/getproduct";

        final ArrayList<Product> productList = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try{

                    for(int i = 0; i < response.length(); i++){
                        JSONObject productInfo =  response.getJSONObject(i);
                        Product product = new Product();
                        product.setProductID(productInfo.getString("productID"));
                        product.setProductName(productInfo.getString("productName"));
                        BigDecimal currentPrice = new BigDecimal(productInfo.getString("bidStep"));
                        product.setCurrentPrice(currentPrice);
                        BigDecimal minPrice = new BigDecimal(productInfo.getString("minPrice"));
                        product.setMinPrice(minPrice);
                        BigDecimal maxPrice = new BigDecimal(productInfo.getString("maxPrice"));
                        product.setMaxPrice(maxPrice);
                        Date expire = new SimpleDateFormat("yyyy-MM-dd").parse(productInfo.getString("toDate"));
                        product.setToDate(expire);
                        productList.add(product);
                    }
                } catch (JSONException | ParseException e){
                    e.printStackTrace();
                }
                productResponseListener.onResponse(productList);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
//                Toast.makeText(context,"Something Wrong!",Toast.LENGTH_SHORT).show();
                productResponseListener.onError(error.toString());
            }
        });

        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}
