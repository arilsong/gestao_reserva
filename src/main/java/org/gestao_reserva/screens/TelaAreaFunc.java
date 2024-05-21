package org.gestao_reserva.screens;

import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.service.QuartoService;
import org.gestao_reserva.service.ReservaService;

import java.util.Scanner;

public class TelaAreaFunc {
    public static void telaAreaFunc(){
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("-----------------------------");
        System.out.println("| 1.Ver reservas            |");
        System.out.println("| 2.Gestao Acomodacoes      |");
        if(AuthManager.getFuncionarioLogado().getNivel_de_acesso().equals("admin")){
            System.out.println("| 3.Gestao Funcionario      |");
        }else{
            System.out.println("| 3.Editar conta Funcionario|");
        }
        System.out.println("| 0.Sair                    |");
        System.out.println("-----------------------------");

        do {
            System.out.print("Escolha uma opcao: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    ReservaService reservaService = new ReservaService();
                    reservaService.listaReservas();
                    telaAreaFunc();
                    break;
                case 2:
                    TelaAcomodacao.telaAcomodacao();
                    break;
                case 3:
                    if(AuthManager.getFuncionarioLogado().getNivel_de_acesso().equals("admin")){
                        TelaGestaoFunc.telaGestaoFunc();
                    }else{
                        TelaGestaoFunc.munuEditarFunc();
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true) ;
    }
}
