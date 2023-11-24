package br.edu.utfpr.td.tsi.producer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.utfpr.td.tsi.dto.Transacao;

public class CreateDTO {
    public static Transacao createTransacao(String[] record) {
        Transacao DTO = new Transacao(createId(record[0]), record[1], record[2], createPrice(record[3]),
                createDate(record[4]));
        return DTO;
    }

    private static Long createId(String str) {
        Long id = Long.parseLong(str);
        return id;
    }

    private static Double createPrice(String str) {
        Double price = Double.parseDouble(str);
        return price;
    }

    private static Date createDate(String str) {
        String data = str.replaceAll("/", "-");

        Date dataTransacao = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            dataTransacao = formato.parse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataTransacao;
    }
}
