package com.example.mjolnirauctiononline.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Product {
    private String ProductID;
    private String ProductName;
    private BigDecimal MinPrice;
    private BigDecimal MaxPrice;
    private BigDecimal CurrentPrice;
    private String Description;
    private Date FromDate;
    private Date ToDate;
    private String Image;
    private String Status;
    private String VendorID;
    private String CategoryId;

    public Product() {
    }

    public Product(String productID, String productName, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal currentPrice, String description, Timestamp fromDate, Timestamp toDate, String image, String status, String vendorID, String categoryId) {
        ProductID = productID;
        ProductName = productName;
        MinPrice = minPrice;
        MaxPrice = maxPrice;
        CurrentPrice = currentPrice;
        Description = description;
        FromDate = fromDate;
        ToDate = toDate;
        Image = image;
        Status = status;
        VendorID = vendorID;
        CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID='" + ProductID + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", MinPrice=" + MinPrice +
                ", MaxPrice=" + MaxPrice +
                ", CurrentPrice=" + CurrentPrice +
                ", Description='" + Description + '\'' +
                ", FromDate=" + FromDate +
                ", ToDate=" + ToDate +
                ", Image='" + Image + '\'' +
                ", Status='" + Status + '\'' +
                ", VendorID='" + VendorID + '\'' +
                ", CategoryId='" + CategoryId + '\'' +
                '}';
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public BigDecimal getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        MinPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return MaxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        MaxPrice = maxPrice;
    }

    public BigDecimal getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        CurrentPrice = currentPrice;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }

    public void setToDate(Timestamp toDate) {
        ToDate = toDate;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }
}
