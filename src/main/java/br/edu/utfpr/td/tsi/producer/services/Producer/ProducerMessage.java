package br.edu.utfpr.td.tsi.producer.services.Producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.dto.Transacao;

@Component
public class ProducerMessage implements iProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void sendTransacao(Transacao transacao) {
        rabbitTemplate.convertAndSend(this.queue.getName(), transacao);
    }
}
