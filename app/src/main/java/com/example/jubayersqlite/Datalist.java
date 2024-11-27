package com.example.jubayersqlite;

public class Datalist {

    String purpose;
    int id;
    Double amount;

    public Datalist(Double amount, String purpose,int id) {
        this.amount = amount;
        this.purpose = purpose;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
