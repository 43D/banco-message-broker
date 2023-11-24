package br.edu.utfpr.td.tsi.producer.services.CSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import br.edu.utfpr.td.tsi.producer.services.Producer.iProducer;
import br.edu.utfpr.td.tsi.producer.util.CreateDTO;
import jakarta.annotation.PostConstruct;

@Component
public class ScammerCSV {

    @Autowired
    iProducer produtor;

    @PostConstruct
    public void read() {
        Resource resource = new ClassPathResource("transacoes.csv");
        try {
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
          
            CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(csvParser).withSkipLines(1).build();
            String[] nextRecord;

            int i = 1;
            while ((nextRecord = csvReader.readNext()) != null) {
                this.sendMessage(nextRecord);
                System.out.println(i++ + ", id: " + nextRecord[0] + ", "+ ((double) i / 1000 * 100) + "%");
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String[] record ){
        produtor.sendTransacao(CreateDTO.createTransacao(record));
    }
}
