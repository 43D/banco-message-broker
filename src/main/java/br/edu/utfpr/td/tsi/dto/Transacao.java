package br.edu.utfpr.td.tsi.dto;

import java.io.Serializable;
import java.util.Date;

public class Transacao implements Serializable {
    private long id;
    private String credente;
    private String pagador;
    private double valor;
    private Date vencimento;

    public Transacao(long id, String credente, String pagador, double valor, Date vencimento) {
        this.id = id;
        this.credente = credente;
        this.pagador = pagador;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public long getId() {
        return id;
    }
    
    public String getCredente() {
        return credente;
    }
    
    public String getPagador() {
        return pagador;
    }
    
    public double getValor() {
        return valor;
    }
    
    public Date getVencimento() {
        return vencimento;
    }

}
