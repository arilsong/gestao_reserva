package org.gestao_reserva.service;

import org.gestao_reserva.dao.ReservaDAO;
import org.gestao_reserva.entity.Cliente;
import org.gestao_reserva.entity.Quarto;
import org.gestao_reserva.entity.Reserva;
import org.gestao_reserva.screens.TelaHome;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReservaService {
    ReservaDAO reservaDAO = new ReservaDAO();
    Map<Integer, Quarto> quartosMap;

    public void adicionarReserva(Date dataCheckin, Date dataCheckout, double valorTotal, int idQuarto){
        Reserva reserva = new Reserva();
        reserva.setDataCheckin(dataCheckin);
        reserva.setDataCheckout(dataCheckout);
        reserva.setValorTotal(valorTotal);

        reservaDAO.adicionarReserva(reserva,idQuarto);
    }

    public Map<Integer, Quarto> getQuartosMap() {
        return quartosMap;
    }

    public void listarReservaCliente(){
        List<Reserva> lista = reservaDAO.lisarReservaCliente();

        if(lista.isEmpty()){
            System.out.println("Voce ainda nao tem nehuma reserva");
            TelaHome.telaHome();
        }else{
            int idWidth = 5;
            int width = 15;

            // Cabeçalho
            System.out.println("-------------------------------------------------------------------------------------------------------");
            String format = "|%-" +
                    idWidth + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|";
            System.out.println(String.format(format, " ID", " DATA CHECKIN", " DATA CHECKOUT", "  VALOR TOTAL", "  NUMERO Q.", " QNT. LEITOS", " PRECO BASE"));
            System.out.println("-------------------------------------------------------------------------------------------------------");

            // Conteúdo
            for (Reserva reserva : lista) {

               Quarto quarto = reserva.getQuarto();

                System.out.println(String.format(format,
                        " "+reserva.getId(),
                        reserva.getDataCheckin(),
                        reserva.getDataCheckout(),
                        reserva.getValorTotal(),
                        "  "+quarto.getNumero(),
                        "   "+quarto.getQuantidadeLeitos(),
                        quarto.getPrecoBase()));
                System.out.println("-------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void listaReservas(){
        List<Reserva> lista = reservaDAO.listaReservas();

        if(lista.isEmpty()){
            System.out.println("nehuma reserva");
            TelaHome.telaHome();
        }else{
            int width = 20;

            // Cabeçalho
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String format = "|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|%-" +
                    width + "s|";
            System.out.println(String.format(format, "NOME","EMAIL","TELEFONE", " DATA CHECKIN", " DATA CHECKOUT", "  VALOR TOTAL", "NUMERO Q.", "TIPO"));
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Conteúdo
            for (Reserva reserva : lista) {

                Quarto quarto = reserva.getQuarto();
                Cliente cliente = reserva.getCliente();

                System.out.println(String.format(format,
                       cliente.getNome()+ cliente.getSobreNome(),
                        cliente.getEmail(),
                        cliente.getTelefone(),
                        reserva.getDataCheckin(),
                        reserva.getDataCheckout(),
                        reserva.getValorTotal(),
                        quarto.getNumero(),
                        quarto.getTipo()));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public Reserva umReserva(int id){
        return reservaDAO.umReserva(id);
    }

    public void atualizarReserva(Date dataCheckin, Date dataCheckout, int idreserva, double precoTotal){
        Reserva reserva = new Reserva();

        reserva.setDataCheckin(dataCheckin);
        reserva.setDataCheckout(dataCheckout);
        reserva.setValorTotal(precoTotal);

        reservaDAO.atualizarReserva(reserva, idreserva);
    }


    public void removerReseerva(int id){
        reservaDAO.removerReserva(id);
    }

    public int buscarIdAcomodacao(int idReserva){
        int numeroQuarto = reservaDAO.buscarIdAcomodacao(idReserva);
        return numeroQuarto;
    }

}
