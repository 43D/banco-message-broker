package br.edu.utfpr.td.tsi.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.producer")
public class ProducerMBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerMBApplication.class, args);
	}

	@Bean
	public Queue myQueue() {
		return new Queue("transacoes.financeiras", false);
	}	

}
