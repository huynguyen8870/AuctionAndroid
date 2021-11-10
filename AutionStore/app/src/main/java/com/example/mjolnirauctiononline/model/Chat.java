package com.example.mjolnirauctiononline.model;

public class Chat {
    private String ChatID;
    private String CustomerID;
    private String VendorID;
    private String Status;

    public Chat() {
    }

    public Chat(String chatID, String customerID, String vendorID, String status) {
        ChatID = chatID;
        CustomerID = customerID;
        VendorID = vendorID;
        Status = status;
    }

    public String getChatID() {
        return ChatID;
    }

    public void setChatID(String chatID) {
        ChatID = chatID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
