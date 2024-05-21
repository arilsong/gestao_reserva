package org.gestao_reserva.screens;

import org.gestao_reserva.Auth.AuthManager;
import java.util.Scanner;

public class TelaLogin {

    //tela login 
    public static void telaLoginCliente(){
        AuthManager authManager = new AuthManager();
        final Scanner input = new Scanner(System.in);
        boolean credentiasCorreto = false;

        System.out.println("---------------------------------------------------------");
        System.out.println("------------     BEM VINDO AO HOTEL     -----------------");
        System.out.println("---------------------------------------------------------");

        do{
            System.out.println("\nFaça login para continuar.......");
            System.out.println("");
        
            System.out.print("email: ");
            String email = input.nextLine();

            System.out.print("senha: ");
            String password = input.nextLine();

            if(authManager.authenticateCliente(email, password)){
                credentiasCorreto = true;
            }else {
                System.out.println("\nCredencias incoreto");
            }


        } while (credentiasCorreto == false);

        TelaHome.telaHome();
    }

    public static void telaLoginFuncionario(){
        AuthManager authManager = new AuthManager();
        final Scanner input = new Scanner(System.in);
        boolean credentiasCorreto = false;

        System.out.println("---------------------------------------------------------");
        System.out.println("------------     BEM VINDO AO HOTEL     -----------------");
        System.out.println("---------------------------------------------------------");

        do{
            System.out.println("\nFaça login para continuar.......");
            System.out.println("");

            System.out.print("Nome de usuario: ");
            String nomeUsuario = input.nextLine();

            System.out.print("senha: ");
            String password = input.nextLine();
            System.out.println(authManager.authenticateCliente(nomeUsuario, password));
            if(authManager.authenticateFuncionario(nomeUsuario, password)){
                credentiasCorreto = true;
            }else {
                System.out.println("\nCredencias incoreto");
            }


        } while (credentiasCorreto == false);

        TelaAreaFunc.telaAreaFunc();
    }



}
