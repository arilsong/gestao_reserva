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
            System.out.println("|  3. Sair              |");
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
                    TelaLogin.telaLogin();
                    break;
                case 2:
                    TelaSignUpCliente.telaSignUP();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEscolha inválida.\n");
            }

        } while (choice != 2);

    }
}
