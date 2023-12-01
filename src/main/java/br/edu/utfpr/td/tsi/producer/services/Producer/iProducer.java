package br.edu.utfpr.td.tsi.producer.services.Producer;

import br.edu.utfpr.td.tsi.dto.Transaction;

public interface iProducer {
    public void sendTransaction(Transaction transaction);
}
