package br.edu.utfpr.td.tsi.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction implements Serializable {
    private long id;
    private String lender;
    private String debtor;
    private double amount;
    private Date dueData;

    public Transaction(long id, String lender, String debtor, double amount, Date dueData) {
        this.id = id;
        this.lender = lender;
        this.debtor = debtor;
        this.amount = amount;
        this.dueData = dueData;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public String getLender() {
        return lender;
    }

    public String getDebtor() {
        return debtor;
    }

    public double getAmount() {
        return amount;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDueData() {
        return dueData;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDueData(Date dueData) {
        this.dueData = dueData;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"lender\": \"" + lender + "\"," +
                "\"debtor\": \"" + debtor + "\"," +
                "\"amount\": \"" + amount + "\"," +
                "\"dueData\": \"" + formato.format(dueData) + "\"" +
                "}";
    }

}
