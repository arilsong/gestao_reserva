package org.gestao_reserva.screens;

import java.util.Scanner;

public class TelaLogin {

    //tela login 
    public static void telaLogin(){
        final Scanner input = new Scanner(System.in);
        boolean credentiasCorreto = false;

        do{

            System.out.println("---------------------------------------------------------");
            System.out.println("------------     BEM VINDO AO HOTEL     -----------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("");
            System.out.println("Faça login para continuar.......");
            System.out.println("");
        
            System.out.print("email: ");
            String email = input.nextLine();

            System.out.print("senha: ");
            String password = input.nextLine();


            if(email.equals("arilson") &&  password.equals("12345")){
                credentiasCorreto = true;
                System.out.println("credencias corrreta");
            }else{
                System.out.println("Credencias incoreto");
            }

        } while (credentiasCorreto == false);

    }

}
