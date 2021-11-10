package com.example.mjolnirauctiononline.model;

import java.math.BigDecimal;

public class Vendor {
    private String VendorID;
    private String AccountID;
    private String Name;
    private String Address;
    private String Phonenumber;
    private String Email;
    private BigDecimal Balance;
    private String Status;

    public Vendor() {
    }

    public Vendor(String vendorID, String accountID, String name, String address, String phonenumber, String email, BigDecimal balance, String status) {
        VendorID = vendorID;
        AccountID = accountID;
        Name = name;
        Address = address;
        Phonenumber = phonenumber;
        Email = email;
        Balance = balance;
        Status = status;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal balance) {
        Balance = balance;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
