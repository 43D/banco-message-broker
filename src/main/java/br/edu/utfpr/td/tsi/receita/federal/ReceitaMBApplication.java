package br.edu.utfpr.td.tsi.receita.federal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.receita.federal")
public class ReceitaMBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitaMBApplication.class, args);
	}

}
