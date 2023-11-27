package br.edu.utfpr.td.tsi.consumer;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class BrokenConfig {
    @Autowired
    private Queue queue;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    private void init() {
        amqpAdmin.declareQueue(queue);
    }
}
