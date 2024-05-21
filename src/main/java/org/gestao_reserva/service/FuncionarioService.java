package org.gestao_reserva.service;

import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.dao.FuncionarioDAO;
import org.gestao_reserva.entity.Funcionario;
import org.gestao_reserva.entity.Quarto;

import java.util.List;

public class FuncionarioService {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrarFuncionario(String nome,
                                     String sobrenome,
                                     String nomeUsuario,
                                     String email,
                                     String senha,
                                     String telefone,
                                     String endereco,
                                     String cargo,
                                     String nivel_de_acesso){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setSobreNome(sobrenome);
        funcionario.setNomeUsuario(nomeUsuario);
        funcionario.setEmail(email);
        funcionario.setSenha(senha);
        funcionario.setTelefone(telefone);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);
        funcionario.setNivel_de_acesso(nivel_de_acesso);

        funcionarioDAO.cadastrarFuncionario(funcionario);
    }

    public void listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionario();
        // Defina a largura das colunas
        int nomeWidth = 10;
        int sobrenomeWidth = 10;
        int nome_usuarioWidth = 10;
        int emailWidth = 20;
        int telefoneWidth = 10;
        int cargoWidth = 15;
        int nivelacessoWidth = 20;

        // Cabeçalho
        System.out.println("-------------------------------------------------------------------------------------------------------");
        String format = "|%-" + nomeWidth + "s|%-" + sobrenomeWidth + "s|%-" + nome_usuarioWidth + "s|%-" + emailWidth + "s|%-" + telefoneWidth + "s|%-" + cargoWidth + "s|%-" + nivelacessoWidth + "s|";
        System.out.println(String.format(format, "NOME", "SOBRENOME", "NOME USUARIO", "EMAIL", "TELEFONE", "CARGO", "NIVEL DE ACESSO"));
        System.out.println("-------------------------------------------------------------------------------------------------------");

        // Conteúdo
        for (Funcionario funcionario : funcionarios) {

            System.out.println(String.format(format,
                    funcionario.getNome(),
                    funcionario.getSobreNome(),
                    funcionario.getNomeUsuario(),
                    funcionario.getEmail(),
                    funcionario.getTelefone(),
                    funcionario.getCargo(),
                    funcionario.getNivel_de_acesso()));
            System.out.println("-------------------------------------------------------------------------------------------------------");
        }
    }

    public void atualizarFuncionario(String usuarioAntigo,
                                     String nome,
                                     String sobrenome,
                                     String nomeUsuario,
                                     String email,
                                     String senha,
                                     String telefone,
                                     String endereco,
                                     String cargo,
                                     String nivel_de_acesso){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setSobreNome(sobrenome);
        funcionario.setNomeUsuario(nomeUsuario);
        funcionario.setEmail(email);
        funcionario.setSenha(senha);
        funcionario.setTelefone(telefone);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);
        funcionario.setNivel_de_acesso(nivel_de_acesso);

        String nomeUsuarioAntigo = usuarioAntigo;

        if(nomeUsuarioAntigo == null){
            nomeUsuarioAntigo = AuthManager.getFuncionarioLogado().getNomeUsuario();
        }


        funcionarioDAO.actualizarFuncionario(funcionario, nomeUsuarioAntigo);
    }

    public void removerFuncionario(String nomeUsuario){
        funcionarioDAO.removerFuncionario(nomeUsuario);
    }
}