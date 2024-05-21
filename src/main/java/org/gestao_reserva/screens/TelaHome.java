package org.gestao_reserva.screens;

import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.entity.Cliente;
import org.gestao_reserva.entity.Quarto;
import org.gestao_reserva.service.ClienteService;
import org.gestao_reserva.service.QuartoService;
import org.gestao_reserva.service.ReservaService;
import org.gestao_reserva.utils.FormatarData;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class TelaHome {
    public static void telaHome(){
        Cliente cliente = AuthManager.getClienteLogado();
        QuartoService quartoService = new QuartoService();
        ClienteService clienteService = new ClienteService();
        Scanner input = new Scanner(System.in);
        int choice;

        if(cliente != null){
            System.out.println("\nBEM VINDO  " + cliente.getNome().toUpperCase());

            System.out.println("----------------------------------");
            System.out.println("|  1. Ver as acomodacoes do Hotel|");
            System.out.println("|  2. Fazer reserva              |");
            System.out.println("|  3. Ver as minhas reservas     |");
            System.out.println("|  4. Editar minha conta         |");
            System.out.println("|  5. Excluir minha conta        |");
            System.out.println("|  0. Sair                       |");
            System.out.println("----------------------------------");

            do {
                System.out.print("Escolha uma opcao: ");
                choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        quartoService.listarQuarto();
                        break;
                    case 2:
                        Quarto quarto = new Quarto();
                        quartoService.listarQuarto();
                        System.out.print("Escolha um quarto para reservar(numero do quarto): ");
                        int numQuarto = input.nextInt();

                        input.nextLine();
                        System.out.print("Insira a data de checkin no formato dd-MM-yyyy:");
                        String dataCheckinIn = input.nextLine();
                        Date dataCheckin = FormatarData.formatarData(dataCheckinIn);

                        System.out.print("Insira a data de checkout no formato dd-MM-yyyy:");
                        String dataCheckoutIn = input.nextLine();
                        Date dataCheckout = FormatarData.formatarData(dataCheckoutIn);

                        quarto.reservar(numQuarto, dataCheckin, dataCheckout);
                        telaHome();
                        break;
                    case 3:
                        ReservaService reservaService = new ReservaService();
                        System.out.println("-----------------------");
                        System.out.println("|   SUAS RESERVAS     |");
                        System.out.println("-----------------------");

                        reservaService.listarReservaCliente();

                        TelaGestaoReserva telaGestaoReserva = new TelaGestaoReserva();
                        telaGestaoReserva.telaGestaReserva();
//                        System.out.print("Pressione qualquer tecla para voltar...");
//
//                        try {
//                            System.in.read();
//                            telaHome();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        break;
                    case 4:
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("|   EDITE SUA CONTA(!!campo que nao quizer editar deixe em branco )     |");
                        System.out.println("-------------------------------------------------------------------------");

                        System.out.print(" o seu nome: ");
                        String nome = input.nextLine();

                        System.out.print("Insira o seu Sobrenome: ");
                        String sobreNome = input.nextLine();

                        System.out.print("Insira o seu email: ");
                        String email = input.nextLine();

                        System.out.print("Crie uma senha: ");
                        String senha = input.nextLine();

                        System.out.print("Insira o seu o nº telefone: ");
                        String telefone = input.nextLine();

                        clienteService.atualizarCliente(nome, sobreNome, email, senha, telefone);
                        break;
                    case 5:
                        clienteService.removerCliente(cliente.getId());
                        TelaInicial.telaInicial();
                        break;
                    case 0:
                        System.exit(0);
                }
            }while (true) ;

        }else{
            TelaLogin.telaLoginCliente();
        }
    }
}