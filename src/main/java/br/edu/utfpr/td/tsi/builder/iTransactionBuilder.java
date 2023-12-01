package br.edu.utfpr.td.tsi.builder;

import br.edu.utfpr.td.tsi.dto.Transaction;

public interface iTransactionBuilder {
    public TransactionBuilder createTransactionFromCSV(String[] record);

    public TransactionBuilder createTransactionFromJson(String json);

    public TransactionBuilder setId(String str);

    public TransactionBuilder setLender(String str);

    public TransactionBuilder setDebtor(String str);

    public TransactionBuilder setAmount(String str);

    public TransactionBuilder setDueDate(String str);

    public Transaction builder();

}
