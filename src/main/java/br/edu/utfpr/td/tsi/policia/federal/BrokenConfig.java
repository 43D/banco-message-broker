package br.edu.utfpr.td.tsi.policia.federal;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class BrokenConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("transacoes.suspeitas", true, false);
    }

    @Bean
    public Queue policiaFederalQueue() {
        return new Queue("policia.federal", true);
    }

    @Bean
    public Binding bindingPoliciaFederal(Queue policiaFederalQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(policiaFederalQueue).to(fanoutExchange);
    }

    @PostConstruct
    private void init() {
        Queue qPoliciaFederal = policiaFederalQueue();
        amqpAdmin.declareQueue(qPoliciaFederal);
        FanoutExchange fanout = fanoutExchange();
        amqpAdmin.declareExchange(fanout);
        amqpAdmin.declareBinding(bindingPoliciaFederal(qPoliciaFederal, fanout));
    }
}
