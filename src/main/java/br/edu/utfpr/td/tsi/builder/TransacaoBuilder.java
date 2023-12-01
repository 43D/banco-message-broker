package br.edu.utfpr.td.tsi.builder;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

import br.edu.utfpr.td.tsi.dto.Transacao;

public class TransacaoBuilder {

    private Transacao dto;

    public TransacaoBuilder() {
        this.dto = new Transacao();
    }

    public TransacaoBuilder createTransacaoFromCSV(String[] record) {
        this.setId(record[0]);
        this.setLender(record[1]);
        this.setDebtor(record[2]);
        this.setPrice(record[3]);
        this.setDate(record[4]);
        return this;
    }

    public TransacaoBuilder createTransacaoFromJson(String json) {

        ObjectMapper om = new ObjectMapper();
        try {
            this.dto = om.readValue(json, Transacao.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return this;
    }

    public TransacaoBuilder setId(String str) {
        dto.setId(Long.parseLong(str));
        return this;
    }

    public TransacaoBuilder setLender(String str) {
        dto.setCredente(str);
        return this;
    }

    public TransacaoBuilder setDebtor(String str) {
        dto.setPagador(str);
        return this;
    }

    public TransacaoBuilder setPrice(String str) {
        dto.setValor(Double.parseDouble(str));
        return this;
    }

    public TransacaoBuilder setDate(String str) {
        String data = str.replaceAll("/", "-");

        Date dataTransacao = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            dataTransacao = formato.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dto.setVencimento(dataTransacao);
        return this;
    }

    public Transacao builder() {
        Transacao transacao = this.dto;
        this.dto = new Transacao();
        return transacao;
    }

}
