package org.gestao_reserva.screens;

import java.util.Scanner;

public class TelaInicial {
    public static void telaInicial(){
        final Scanner input = new Scanner(System.in);
        int choice;

        do{
            System.out.println("-------------------------");
            System.out.println("|  1. Fazer login       |");
            System.out.println("|  2. Criar conta       |");
            System.out.println("|  3. Area funcionario  |");
            System.out.println("|  4. Info Hotel        |");
            System.out.println("|  0. Sair              |");
            System.out.println("-------------------------");

            System.out.println();
            System.out.print("Digite um número: ");
            while (!input.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número: ");
                input.next();
            }

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    TelaLogin.telaLoginCliente();
                    break;
                case 2:
                    TelaSignUp.telaSignUpCliente();
                    break;
                case 3:
                    TelaLogin.telaLoginFuncionario();
                    break;
                case 4:
                    TelaInfoHotel.teçainfoHoel();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEscolha inválida.\n");
            }

        } while (choice != 0);
    }
}