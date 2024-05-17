package org.gestao_reserva.screens;

import com.mysql.cj.xdevapi.Client;

import java.util.Scanner;

public class TelaSignUpCliente {
    public static void telaSignUP(){
        final Scanner input = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("|   CRIAR CONTA     |");
        System.out.println("--------------------");

        System.out.println("Insira o seu nome: ");
        String nome = input.nextLine();

        System.out.print("Insira o seu email: ");
        String email = input.nextLine();

        System.out.println("Insira o seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("Insira o seu endereço: ");
        String endereco = input.nextLine();

        System.out.println("Insira a sua senha: ");
        String senha = input.nextLine();

        System.out.println("Cadastro concluído com sucesso!");
        exibirMenu(email);
        TelaInicial.telaInicial();
    }

    private static void exibirMenu(String email){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------------------");
            System.out.println("|  ESCOLHA UMA OPCAO:  |");
            System.out.println("| 1. ADICIONAR RESERVA |");
            System.out.println("| 2. CANCELAR RESERVA  |");
            System.out.println("| 3. SAIR              |");
            System.out.println("------------------------");

            System.out.println("Opcao");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    adicionarReserva(email);
                    break;
                case 2:
                    cancelarReserva(email);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 3);
        scanner.close();
    }
    private static void adicionarReserva(String email){
        System.out.println("Adicionar codigo");
    }

    private static void cancelarReserva(String email){
        System.out.println("Adicionar codigo");
    }
}
