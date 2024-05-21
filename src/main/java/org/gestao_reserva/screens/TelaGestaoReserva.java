package org.gestao_reserva.screens;


import org.gestao_reserva.entity.Quarto;
import org.gestao_reserva.service.ReservaService;
import org.gestao_reserva.utils.FormatarData;

import java.util.Date;
import java.util.Scanner;


public class TelaGestaoReserva {
    ReservaService reservaService = new ReservaService();
    public static void telaGestaReserva(){
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println(" 1.Editar reserva");
        System.out.println(" 2.Cancelar reserva");
        System.out.println(" 0.voltar          ");


        do {
            System.out.print("Escolha uma opcao: ");
            choice = input.nextInt();
            Quarto quarto = new Quarto();
            switch (choice){
                case 1:
                    ReservaService reservaService = new ReservaService();
                    System.out.print("Ensira o id de reserva que deseja editar: ");
                    int idreserva = input.nextInt();

                    input.nextLine();
                    System.out.print("Editar a data de checkin no formato dd-MM-yyyy:");
                    String dataCheckinIn = input.nextLine();
                    Date dataCheckin = FormatarData.formatarData(dataCheckinIn);

                    System.out.print("Editar a data de checkout no formato dd-MM-yyyy:");
                    String dataCheckoutIn = input.nextLine();
                    Date dataCheckout = FormatarData.formatarData(dataCheckoutIn);

                    quarto.actualizarReserva(dataCheckin, dataCheckout, idreserva);

                    TelaHome.telaHome();
                    break;
                case 2:
                    System.out.print("Insira id da reserva que desja cancelar: ");
                    idreserva = input.nextInt();
                    quarto.cancelarReserva(idreserva);
                    TelaHome.telaHome();
                    break;
                case 0:
                    TelaHome.telaHome();
                    break;
                default:
                    System.out.println("opcao invalida...");
            }
        }while (choice != 0);

    }
}
