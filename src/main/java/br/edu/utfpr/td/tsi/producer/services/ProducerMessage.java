package br.edu.utfpr.td.tsi.producer.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.producer.dto.Transacao;

@Component
public class ProducerMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void sendTransacao(Transacao transacao) {
        rabbitTemplate.convertAndSend(this.queue.getName(), transacao);
    }
}
