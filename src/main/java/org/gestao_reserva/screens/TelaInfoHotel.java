package org.gestao_reserva.screens;

import org.gestao_reserva.service.HotelService;

public class TelaInfoHotel {
    public static void teçainfoHoel(){
        HotelService hotelService = new HotelService();
        System.out.println("----------------------------------");
        System.out.println("       Informacoes do Hotel       ");
        System.out.println("-----------------------------------");

        hotelService.infoHotel();
    }
}
