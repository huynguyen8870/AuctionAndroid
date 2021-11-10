package com.example.mjolnirauctiononline.model;

public class ChatLine {
    private String Serial;
    private String CustomerID;
    private String MessageLine;
    private String Status;
    private String CreateAt;
    private String ChatID;

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getMessageLine() {
        return MessageLine;
    }

    public void setMessageLine(String messageLine) {
        MessageLine = messageLine;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(String createAt) {
        CreateAt = createAt;
    }

    public String getChatID() {
        return ChatID;
    }

    public void setChatID(String chatID) {
        ChatID = chatID;
    }
}
