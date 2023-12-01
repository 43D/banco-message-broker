package br.edu.utfpr.td.tsi.builder;

import br.edu.utfpr.td.tsi.dto.Transacao;

public interface iTransacaoBuilder {
    public TransacaoBuilder createTransacaoFromCSV(String[] record);

    public TransacaoBuilder createTransacaoFromJson(String json);

    public TransacaoBuilder setId(String str);

    public TransacaoBuilder setLender(String str);

    public TransacaoBuilder setDebtor(String str);

    public TransacaoBuilder setPrice(String str);

    public TransacaoBuilder setDate(String str);

    public Transacao builder();

}
