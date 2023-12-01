package br.edu.utfpr.td.tsi.policia.federal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.policia.federal")
public class PoliciaFederalMBApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliciaFederalMBApplication.class, args);
	}

}
