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
        super();
        this.id = id;
        this.credente = credente;
        this.pagador = pagador;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public Transacao() {
        super();
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCredente(String credente) {
        this.credente = credente;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return "{" +
                    "\"id\": \"" + id + "\"," +
                    "\"credente\": \"" + credente + "\"," +
                    "\"pagador\": \"" + pagador + "\"," +
                    "\"valor\": \"" + valor + "\"," +
                    "\"vencimento\": \"" + vencimento + "\"" +
                "}";
    }

}
