package org.gestao_reserva.screens;

import org.gestao_reserva.service.ClienteService;
import org.gestao_reserva.service.FuncionarioService;

import java.util.Scanner;

public class TelaSignUp {
    public static void telaSignUpCliente(){
        ClienteService clienteService = new ClienteService();
        final Scanner input = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("|   CRIAR CONTA     |");
        System.out.println("--------------------");

        System.out.print("Insira o seu nome: ");
        String nome = input.nextLine();

        System.out.print("Insira o seu Sobrenome: ");
        String sobreNome = input.nextLine();

        System.out.print("Insira o seu email: ");
        String email = input.nextLine();

        System.out.print("Crie uma senha: ");
        String senha = input.nextLine();

        System.out.print("Insira o seu o nº telefone: ");
        String telefone = input.nextLine();

        clienteService.criarConta(nome, sobreNome, email, senha, telefone);

        TelaInicial.telaInicial();
    }

    public static void telaSignUpFuncionario(){
        FuncionarioService funcionarioService = new FuncionarioService();
        final Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------");
        System.out.println("|   ADICIONAR FUNCIONARIO     |");
        System.out.println("-------------------------------");

        System.out.print("Insira o nome do funcionario: ");
        String nome = input.nextLine();

        System.out.print("Insira o Sobrenome do funcionario: ");
        String sobreNome = input.nextLine();

        System.out.print("Insira o email do funcionario: ");
        String email = input.nextLine();

        System.out.print("Insira o telefone do funcionario: ");
        String telefone = input.nextLine();

        System.out.print("Insira o enderco: ");
        String endereco = input.nextLine();

        System.out.print("Insira o cargo do funcionario: ");
        String cargo = input.nextLine();

        System.out.print("Insira nivel de acesso(admin/normal): ");
        String nivel_de_acesso = input.nextLine();

        System.out.print("Insira nome do usuario do funcionario: ");
        String nomeUsuario = input.nextLine();

        System.out.print("Insira a senha do usuario: ");
        String senha = input.nextLine();

        funcionarioService.cadastrarFuncionario(nome, sobreNome, nomeUsuario, email, senha, telefone, endereco, cargo, nivel_de_acesso);


        TelaGestaoFunc.telaGestaoFunc();
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
