package com.example.mjolnirauctiononline.ulti;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mjolnirauctiononline.model.Account;
import com.example.mjolnirauctiononline.model.Customer;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public class AccountDataService {
    public static final String QUERY_CHANGE_PASSWORD = "http://192.168.1.48:8080/api/account/changepassword/";
    public static final String QUERY_GET_OLD_PASSWORD = "http://192.168.1.48:8080/api/account/getpassword/";
    public static final String QUERY_REGISTER_ACCOUNT = "http://192.168.1.48:8080/api/account/register";
    private final Context context;

    public AccountDataService(Context context) {
        this.context = context;
    }

    public interface PasswordResponseListener{
        void onError(String message);

        void onResponse(String password);
    }

    public void getPassword (String id, PasswordResponseListener passwordResponseListener){
        String url = QUERY_GET_OLD_PASSWORD + id;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                passwordResponseListener.onResponse(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                passwordResponseListener.onError(error.toString());
            }
        });

        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);

    }

    public interface changePasswordResponseListener{
        void onError(String message);

        void onResponse(String message);
    }

    public void changePassword (String id, String pwd, changePasswordResponseListener changepasswordResponseListener){
        String url = QUERY_CHANGE_PASSWORD + id + "/" + pwd;

        StringRequest request = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                changepasswordResponseListener.onResponse(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                changepasswordResponseListener.onError(error.toString());
            }
        });

        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);

    }

    public interface RegisterResponseListener{
        void onError(String message);

        void onResponse(String accountID);
    }

    public void Register(Account account, RegisterResponseListener registerResponseListener) {
        String url = QUERY_REGISTER_ACCOUNT;

        try{
            JSONObject jsonAccount = new JSONObject();
            jsonAccount.put("username", account.getUsername());
            jsonAccount.put("password", account.getPassword());
            jsonAccount.put("role", account.getRole());
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

    public interface LoginResponseListener{
        void onError(String message);

        void onResponse(Customer customer);
    }

    public void checkLogin(Account account, LoginResponseListener loginResponseListener){
        String url = "http://192.168.1.48:8080/api/account/checklogin";

        try{
            JSONObject jsonAccount = new JSONObject();
            jsonAccount.put("username", account.getUsername());
            jsonAccount.put("password", account.getPassword());
            jsonAccount.put("role", account.getRole());



            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonAccount, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Customer customer  = new Customer();
                    try {
                        customer.setCustomerID(response.getString("customerID"));
//                        customer.setAccountID(response.getString("accountID"));
                        customer.setFirstname(response.getString("firstName"));
                        customer.setLastname(response.getString("lastName"));
                        BigDecimal balance = new BigDecimal(response.getString("balance"));
                        customer.setBalance(balance);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    loginResponseListener.onResponse(customer);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    loginResponseListener.onError(error.toString());
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
}
