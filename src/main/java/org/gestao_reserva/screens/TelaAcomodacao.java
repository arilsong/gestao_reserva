package org.gestao_reserva.screens;

import org.gestao_reserva.service.QuartoService;

import java.util.Scanner;

public class TelaAcomodacao {
    public  static  void telaAcomodacao(){
        QuartoService quartoService = new QuartoService();
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("---------------------------");
        System.out.println("| 1.Ver Acomodacoes       |");
        System.out.println("| 2.Adicionar Acomodacao  |");
        System.out.println("| 3.Editar acomodacao     |");
        System.out.println("| 4.Remover Acomodacao    |");
        System.out.println("| 0.Voltar                |");
        System.out.println("---------------------------");


        do {
            System.out.print("Escolha uma opcao: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    quartoService.listarQuarto();
                    telaAcomodacao();
                    break;
                case 2:
                    System.out.println("-------------------------------");
                    System.out.println("|   ADICIONAR ACOMODACAO     |");
                    System.out.println("-------------------------------");

                    System.out.print("Insira o numero da acomodacao: ");
                    int numero = input.nextInt();

                    input.nextLine();
                    System.out.print("Insira o tipo: ");
                    String tipo = input.nextLine();

                    System.out.print("Insira o email do Numero de Leitos: ");
                    int qtdLeitos = input.nextInt();

                    input.nextLine();
                    System.out.print("Insira o preço: ");
                    double preco = input.nextDouble();

                    input.nextLine();
                    System.out.print("Insira o tamanho: ");
                    String tamanho = input.nextLine();

                    quartoService.adicionarQuarto(numero, tipo, qtdLeitos, preco, tamanho);

                    break;
                case 3:
                    menuEditar();
                    break;
                case 4:
                    quartoService.listarQuarto();
                    System.out.print("Insira o numero de quarto que deseja excluir: ");
                    int numeroInput = input.nextInt();
                    quartoService.removerquarto(numeroInput);
                    telaAcomodacao();
                    break;
                case 0:
                    TelaAreaFunc.telaAreaFunc();
            }
        }while (choice != 0) ;
    }

    public static void menuEditar(){
        Scanner input = new Scanner(System.in);
        QuartoService quartoService = new QuartoService();

        System.out.println("-------------------------------------");
        System.out.println("|   EDITAR ADICIONAR ACOMODACAO     |");
        System.out.println("-------------------------------------");

        System.out.print("Editar o numero da acomodacao: ");
        int numero = input.nextInt();

        input.nextLine();
        System.out.print("Editar o tipo: ");
        String tipo = input.nextLine();

        System.out.print("Editar o email do Numero de Leitos: ");
        int qtdLeitos = input.nextInt();

        input.nextLine();
        System.out.print("Editar o preço: ");
        double preco = input.nextDouble();

        input.nextLine();
        System.out.print("Editar o tamanho: ");
        String tamanho = input.nextLine();

        quartoService.atualizarQuarto(numero, tipo, qtdLeitos, preco, tamanho);
    }
}
