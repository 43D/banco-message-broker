package br.edu.utfpr.td.tsi.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class ConsumerMBApplication {

	@Bean
	public Queue myQueue() {
		return new Queue("transacoes.financeiras", true);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMBApplication.class, args);
	}
}
