package br.edu.utfpr.td.tsi.producer.services.Producer;

import br.edu.utfpr.td.tsi.dto.Transacao;

public interface iProducer {
    public void sendTransacao(Transacao transacao);
}
