package br.edu.utfpr.td.tsi.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.edu.utfpr.td.tsi.consumer", "br.edu.utfpr.td.tsi.builder"})
public class ConsumerMBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMBApplication.class, args);
	}
}
