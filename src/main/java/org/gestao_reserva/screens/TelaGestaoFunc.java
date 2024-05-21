package org.gestao_reserva.screens;

import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.service.FuncionarioService;

import java.util.Scanner;

public class TelaGestaoFunc {
    public static void telaGestaoFunc(){
        FuncionarioService funcionarioService = new FuncionarioService();
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("-----------------------------");
        System.out.println("| 1. Litar os funcionarios   |");
        System.out.println("| 2. Adicionar funcionario  |");
        System.out.println("| 3. Editar funcionario     |");
        System.out.println("| 4. Remover funcionario     |");
        System.out.println("| 0. Voltar                |");
        System.out.println("-----------------------------");


        do {
            System.out.print("Escolha uma opcao: ");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    funcionarioService.listarFuncionarios();
                    telaGestaoFunc();
                    break;
                case 2:
                    TelaSignUp.telaSignUpFuncionario();
                    telaGestaoFunc();
                    break;
                case 3:
                    funcionarioService.listarFuncionarios();
                    munuEditarFunc();
                    telaGestaoFunc();
                case 4:
                    funcionarioService.listarFuncionarios();
                    input.nextLine();
                    System.out.print("Insira o nome usuario do funcionario que deseja apagar: ");
                    String nomeUsuarioIn = input.nextLine();
                    funcionarioService.removerFuncionario(nomeUsuarioIn);
                    telaGestaoFunc();
                    break;
                case 0:
                    TelaAreaFunc.telaAreaFunc();
                    break;
                default:
                    System.out.println("opcao invalida..");
            }
        }while (choice != 0);
    }

    public static void munuEditarFunc(){
        FuncionarioService funcionarioService = new FuncionarioService();
        Scanner input = new Scanner(System.in);
        boolean isadmin = AuthManager.getFuncionarioLogado().getNivel_de_acesso().equals("admin");
        String nomeUsuarioAntigo = null;

        if(isadmin){
            System.out.print("Insira nome usuario do funconario que deseja editar: ");
            nomeUsuarioAntigo = input.nextLine();
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|     EDITAR FUNCIONARIO(deixe em branco campo que nao desja editar)      |");
        System.out.println("--------------------------------------------------------------------------");

        System.out.print("Editar o nome do funcionario: ");
        String nome = input.nextLine();

        System.out.print("Editar o Sobrenome do funcionario: ");
        String sobreNome = input.nextLine();

        System.out.print("Editar o email do funcionario: ");
        String email = input.nextLine();

        System.out.print("Editar o telefone do funcionario: ");
        String telefone = input.nextLine();

        System.out.print("Editar o enderco: ");
        String endereco = input.nextLine();


        System.out.print("Editar nome do usuario do funcionario: ");
        String nomeUsuario = input.nextLine();

        System.out.print("Editar a senha do usuario: ");
        String senha = input.nextLine();

        String nivel_de_acesso = null;
        String cargo = null;

        if(isadmin){
            System.out.print("Editar nivel de acesso(admin/normal): ");
            nivel_de_acesso = input.nextLine();

            System.out.print("Editar o cargo do funcionario: ");
            cargo = input.nextLine();
        }

        funcionarioService.atualizarFuncionario(nomeUsuarioAntigo, nome, sobreNome, nomeUsuario, email, senha, telefone, endereco, cargo, nivel_de_acesso);

        if (isadmin) {
            telaGestaoFunc();
        } else {
            TelaAreaFunc.telaAreaFunc();
        }
    }
}