package org.gestao_reserva.service;

import org.gestao_reserva.dao.HotelDAO;
import org.gestao_reserva.entity.Hotel;

<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelService {
    QuartoDAO quartoDAO = new QuartoDAO();

    public void adicionarQuarto(int numero,String tipo,int quantidadeLeitos,double precoBase,String tamanho){
        Quarto quarto = new Quarto();

        quarto.setNumero(numero);
        quarto.setTipo(tipo);
        quarto.setQuantidadeLeitos(quantidadeLeitos);
        quarto.setPrecoBase(precoBase);
        quarto.setTamanho(tamanho);
        quartoDAO.adcionarQuarto(quarto);
    }

    public void listarQuarto(){
        List<Quarto> quartos = quartoDAO.listarQuarto();
        // Defina a largura das colunas
        int numeroWidth = 10;
        int tipoWidth = 10;
        int qtdLeitosWidth = 10;
        int prcBaseWidth = 10;
        int tamWidth = 10;
        if(AuthManager.getFuncionarioLogado() != null){
            System.out.println("ta parsi tudo");
            int estadoWith = 15;

            // Cabeçalho
            String format = "|%-" + numeroWidth + "s|%-" + tipoWidth + "s|%-" + qtdLeitosWidth + "s|%-" + prcBaseWidth + "s|%-" + tamWidth + "s|%-" + estadoWith + "s|";
            System.out.println(String.format(format, "NUMERO", "TIPO", "QTD LEITOS", " PRECO CVE", "TAMANHO", "ESTADO"));
            System.out.println("--------------------------------------------------------------------");

            // Conteúdo
            for (Quarto quarto : quartos) {
                String estado = null;
                if(quarto.getEstado()){
                    estado = "Reservado";
                }else{
                    estado = "Livre";
                }

                System.out.println(String.format(format,
                        quarto.getNumero(),
                        quarto.getTipo(),
                        quarto.getQuantidadeLeitos(),
                        quarto.getPrecoBase(),
                        quarto.getTamanho(),
                        estado));
                System.out.println("--------------------------------------------------------------------");
            }
        }else{
            System.out.println("\n--------------------------");
            System.out.println("| ACOMODACOES DISPONIVEIS  |");
            System.out.println("----------------------------\n");
            List<Quarto> quartosDisponivel = quartos.stream()
                    .filter(quarto -> quarto.getEstado() == false)
                    .toList();

            String format = "|%-" + numeroWidth + "s|%-" + tipoWidth + "s|%-" + qtdLeitosWidth + "s|%-" + prcBaseWidth + "s|%-" + tamWidth + "s|";
            System.out.println(String.format(format, "NUMERO", "TIPO", "QTD LEITOS", " PRECO CVE", "TAMANHO"));
            System.out.println("--------------------------------------------------------");

            for (Quarto quarto : quartosDisponivel) {

                System.out.println(String.format(format,
                        quarto.getNumero(),
                        quarto.getTipo(),
                        quarto.getQuantidadeLeitos(),
                        quarto.getPrecoBase(),
                        quarto.getTamanho()));
                System.out.println("--------------------------------------------------------");
            }
        }

    }

    public Quarto umQuarto(int numeroQuarto){
        Quarto quarto =  quartoDAO.umQuarto(numeroQuarto);
        return quarto;
    }
=======
public class HotelService {
    public void infoHotel(){
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.infoHotel();
>>>>>>> 831066d6e9350366394100594a715bda15bbc6c3


        System.out.println(
                hotel.getNome()+"\n" +
                hotel.getContato()+"\n" +
                hotel.getLocalizacao()+"\n" +
                hotel.getDescricao()+"\n" +
                hotel.getClassificacao()
        );
    }
}
