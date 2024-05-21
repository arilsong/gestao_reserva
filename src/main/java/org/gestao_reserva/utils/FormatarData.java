package org.gestao_reserva.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarData {
    public static Date formatarData(String dataInput) {
        if(!dataInput.isEmpty()){
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
            Date data = null;
            try {
                data = formatoEntrada.parse(dataInput);
//            dataFormatada = formatoSaida.format(data);
            } catch (ParseException e) {
                System.err.println("Erro ao converter a data: " + e.getMessage());
            }
            return data;
        }
        return null;
    }
}
