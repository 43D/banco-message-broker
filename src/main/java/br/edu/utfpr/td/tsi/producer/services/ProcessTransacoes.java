package br.edu.utfpr.td.tsi.producer.services;

import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.dto.Transaction;
import br.edu.utfpr.td.tsi.producer.services.CSV.ScammerCSV;
import br.edu.utfpr.td.tsi.producer.services.Producer.iProducer;
import jakarta.annotation.PostConstruct;

@Component
public class ProcessTransacoes {

    @Autowired
    private Queue queue;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private iProducer produtor;

    @Autowired
    private ScammerCSV scam;

    @PostConstruct
    public void init() {
        amqpAdmin.declareQueue(queue);
        List<Transaction> transacoes = scam.read();
        for (Transaction transaction : transacoes) {
            produtor.sendTransaction(transaction);
        }
    }
}
