package org.gestao_reserva.service;

import org.gestao_reserva.dao.HotelDAO;
import org.gestao_reserva.entity.Hotel;

public class HotelService {
    public void infoHotel(){
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.infoHotel();


        System.out.println(
                hotel.getNome()+"\n" +
                hotel.getContato()+"\n" +
                hotel.getLocalizacao()+"\n" +
                hotel.getDescricao()+"\n" +
                hotel.getClassificacao()
        );
    }
}
