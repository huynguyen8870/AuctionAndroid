package com.example.mjolnirauctiononline.ulti;

import android.content.Context;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mjolnirauctiononline.model.Account;
import com.example.mjolnirauctiononline.model.Customer;
import com.example.mjolnirauctiononline.model.Product;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CustomerDataService {
    public static final String QUERY_EDIT_PROFILE = "http://192.168.1.48:8080/api/customer/editprofile/";
    public static final String QUERY_GET_PROFILE = "http://192.168.1.48:8080/api/customer/getcustomer/C-01";
    public static final String QUERY_CUSTOMER_REGISTER = "http://192.168.1.48:8080/api/customer/register/";
    private final Context context;

    public CustomerDataService(Context context) {
        this.context = context;
    }

    public interface ProfileResponseListener{
        void onError(String message);

        void onResponse(Customer customer);
    }

    public void getProfile (ProfileResponseListener profileResponseListener){
        String url = QUERY_GET_PROFILE;

        final Customer customer = new Customer();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try{
                    customer.setCustomerID(response.getString("customerID"));
                    customer.setFirstname(response.getString("firstName"));
                    customer.setLastname(response.getString("lastName"));
                    customer.setEmail(response.getString("emailAddress"));
                    customer.setAddress(response.getString("address"));
                    customer.setPhonenumber(response.getString("phoneNumber"));

                } catch (JSONException e){
                    e.printStackTrace();
                }
                profileResponseListener.onResponse(customer);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                profileResponseListener.onError(error.toString());
            }
        });

        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);

    }

    public interface SaveProfileResponseListener{
        void onError(String message);

        void onResponse(String message);
    }

    public void saveProfile(Customer customer, SaveProfileResponseListener saveProfileResponseListener){
        String url = QUERY_EDIT_PROFILE + customer.getCustomerID();

        try{
            JSONObject profile = new JSONObject();
            profile.put("firstName", customer.getFirstname());
            profile.put("lastName", customer.getLastname());
            profile.put("address", customer.getAddress());
            profile.put("emailAddress",customer.getEmail());
            profile.put("phoneNumber", customer.getPhonenumber());

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url,profile, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    String message = new Gson().toJson(response);
                    saveProfileResponseListener.onResponse(message);
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    saveProfileResponseListener.onError(error.toString());
                }
            });

            request.setRetryPolicy(
                    new DefaultRetryPolicy(
                            500000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    )
            );

            MySingleton.getInstance(context).addToRequestQueue(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public interface RegisterResponseListener{
        void onError(String message);

        void onResponse(String message);
    }

    public void Register(String accountID,Customer customer, RegisterResponseListener registerResponseListener) {
        String url = QUERY_CUSTOMER_REGISTER + accountID;

        try{
            JSONObject jsonAccount = new JSONObject();
            jsonAccount.put("firstName", customer.getFirstname());
            jsonAccount.put("lastName", customer.getLastname());
            jsonAccount.put("phoneNumber", customer.getPhonenumber());
            final String requestBody = jsonAccount.toString();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    registerResponseListener.onResponse(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    registerResponseListener.onError(error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
            };

            request.setRetryPolicy(
                    new DefaultRetryPolicy(
                            500000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    )
            );

            MySingleton.getInstance(context).addToRequestQueue(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
