package br.edu.utfpr.td.tsi.consumer.services.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "transacoes.financeiras")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
