package br.edu.utfpr.td.tsi.builder;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

import br.edu.utfpr.td.tsi.dto.Transaction;

@Component
public class TransactionBuilder implements iTransactionBuilder {

    private Transaction dto = new Transaction();

    @Override
    public TransactionBuilder createTransactionFromCSV(String[] record) {
        this.setId(record[0]);
        this.setLender(record[1]);
        this.setDebtor(record[2]);
        this.setAmount(record[3]);
        this.setDueDate(record[4]);
        return this;
    }

    @Override
    public TransactionBuilder createTransactionFromJson(String json) {

        ObjectMapper om = new ObjectMapper();
        try {
            this.dto = om.readValue(json, Transaction.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public TransactionBuilder setId(String str) {
        dto.setId(Long.parseLong(str));
        return this;
    }

    @Override
    public TransactionBuilder setLender(String str) {
        dto.setLender(str);
        return this;
    }

    @Override
    public TransactionBuilder setDebtor(String str) {
        dto.setDebtor(str);
        return this;
    }

    @Override
    public TransactionBuilder setAmount(String str) {
        dto.setAmount(Double.parseDouble(str));
        return this;
    }

    @Override
    public TransactionBuilder setDueDate(String str) {
        String data = str.replaceAll("/", "-");

        Date dataTransaction = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            dataTransaction = formato.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dto.setDueData(dataTransaction);
        return this;
    }

    @Override
    public Transaction builder() {
        Transaction Transaction = this.dto;
        this.dto = new Transaction();
        return Transaction;
    }

}
