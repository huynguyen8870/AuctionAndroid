package com.example.mjolnirauctiononline.model;

public class Bid {
    private String BidID;
    private String ProductID;
    private String CustomerID;
    private String Date;
    private long Price;
    private String Status;

    public Bid(String bidID, String productID, String customerID, String date, long price, String status) {
        BidID = bidID;
        ProductID = productID;
        CustomerID = customerID;
        Date = date;
        Price = price;
        Status = status;
    }

    public Bid() {
    }

    public String getBidID() {
        return BidID;
    }

    public void setBidID(String bidID) {
        BidID = bidID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
