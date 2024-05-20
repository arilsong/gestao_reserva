package org.gestao_reserva.entity;

import org.gestao_reserva.screens.TelaHome;
import org.gestao_reserva.service.QuartoService;
import org.gestao_reserva.service.ReservaService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Quarto extends Acomodacao implements Reservavel {
    private boolean disponivel;

    @Override
    public void reservar(int numQuarto,Date dataCheckIn, Date dataCheckOut) {
        QuartoService quartoService = new QuartoService();
        Quarto quarto = quartoService.umQuarto(numQuarto);
        ReservaService reservaService = new ReservaService();
        if(quarto == null){
            System.out.println("\nerro ao fazer reserva tente novamenten\n");
            TelaHome.telaHome();
        }
        if(!quarto.getEstado()){
            double precoTotal = clcPrecoTotal(dataCheckIn, dataCheckOut, quarto.getPrecoBase());
            reservaService.adicionarReserva(dataCheckIn, dataCheckOut, precoTotal, quarto.getId());
            quartoService.actualizarEstadoQuarto(true, quarto.getId());
        }else{
            System.out.println("quarto ja reservado");
        }
    }

    @Override
    public void cancelarReserva(int idReserva) {
        QuartoService quartoService = new QuartoService();
        ReservaService reservaService = new ReservaService();
        int numQuarto = reservaService.buscarIdAcomodacao(idReserva);
        System.out.println(numQuarto);
        quartoService.actualizarEstadoQuarto(false, quartoService.umQuarto(numQuarto).getId());
        reservaService.removerReseerva(idReserva);
    }

    public void actualizarReserva(Date dataCheckIn, Date dataCheckOut, int idreserva){

        ReservaService reservaService = new ReservaService();
        QuartoService quartoService = new QuartoService();
        int numQuarto = reservaService.buscarIdAcomodacao(idreserva);
        //busacar quarto
        Quarto quarto =  quartoService.umQuarto(numQuarto);
        if(quarto == null){
            System.out.println("quarto vazio");
            TelaHome.telaHome();
        }

        if(dataCheckIn == null || dataCheckOut == null){
            System.out.println("\nerro ao atualizar, ensira as datas");
            TelaHome.telaHome();
        }

        double precoTotal = clcPrecoTotal(dataCheckIn, dataCheckOut, quarto.getPrecoBase());
        reservaService.atualizarReserva(dataCheckIn, dataCheckOut, idreserva, precoTotal);

    }

    public double clcPrecoTotal(Date dataCheckin,Date dataCheckout, double precoPorDia){
        LocalDate localDataCheckin = dataCheckin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDataCheckout = dataCheckout.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long numeroDeDias = ChronoUnit.DAYS.between(localDataCheckin, localDataCheckout);

        return numeroDeDias * precoPorDia;
    }
}
