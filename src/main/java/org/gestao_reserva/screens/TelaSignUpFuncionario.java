package org.gestao_reserva.screens;

import java.util.Scanner;

public class TelaSignUpFuncionario {
    public static void telaSignUP(){
        final Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------");
        System.out.println("|   ADICIONAR FUNCIONARIO     |");
        System.out.println("-------------------------------");

        System.out.print("Insira o nome do funcionario: ");
        String nome = input.nextLine();

        System.out.print("Insira o email do funcionario: ");
        String email = input.nextLine();

        System.out.print("Insira o telefone do funcionario: ");
        String telefone = input.nextLine();

        System.out.print("Insira o cargo do funcionario: ");
        String cargo = input.nextLine();

        System.out.print("Insira o setor do funcionario: ");
        String setor = input.nextLine();

        System.out.println("Funcionario registrado com sucesso!");

        TelaLogin.telaLogin();
    }
}
