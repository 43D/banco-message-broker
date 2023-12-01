package br.edu.utfpr.td.tsi.producer.services.CSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import br.edu.utfpr.td.tsi.builder.iTransactionBuilder;
import br.edu.utfpr.td.tsi.dto.Transaction;
import br.edu.utfpr.td.tsi.producer.services.Producer.iProducer;

@Component
public class ScammerCSV {

    private List<Transaction> transacoes = new ArrayList<Transaction>();
    @Autowired
    iProducer produtor;

    @Autowired
    private iTransactionBuilder TransactionBuilder;
    
    public List<Transaction> read() {
        Resource resource = new ClassPathResource("transacoes.csv");
        try {
            InputStream is = resource.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(csvParser).withSkipLines(1).build();
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                this.sendMessage(nextRecord);
                System.out.println(nextRecord[0]);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return transacoes;
    }

    private void sendMessage(String[] record) {
        Transaction dto = TransactionBuilder.createTransactionFromCSV(record).builder();
        transacoes.add(dto);
    }
}
