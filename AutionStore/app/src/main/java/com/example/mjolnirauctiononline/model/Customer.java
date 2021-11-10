package com.example.mjolnirauctiononline.model;

import java.math.BigDecimal;

public class Customer {
    private String CustomerID;
    private String AccountID;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Address;
    private String Phonenumber;
    private BigDecimal Balance;
    private String Status;

    public Customer() {
    }

    public Customer(String customerID, String accountID, String firstname, String lastname, String email, String address, String phonenumber, BigDecimal balance, String status) {
        CustomerID = customerID;
        AccountID = accountID;
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        Address = address;
        Phonenumber = phonenumber;
        Balance = balance;
        Status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", AccountID='" + AccountID + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Phonenumber='" + Phonenumber + '\'' +
                ", Balance=" + Balance +
                ", Status='" + Status + '\'' +
                '}';
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
