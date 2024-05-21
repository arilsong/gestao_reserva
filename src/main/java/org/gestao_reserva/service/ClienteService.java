package org.gestao_reserva.service;

import org.gestao_reserva.dao.ClienteDAO;
import org.gestao_reserva.entity.Cliente;

public class ClienteService {
    ClienteDAO clienteDAO = new ClienteDAO();

    public void criarConta(String nome,
                           String sobreNome,
                           String email,
                           String senha,
                           String telefone){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobreNome(sobreNome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setTelefone(telefone);

        clienteDAO.criarContaCliente(cliente);
    }

    public void atualizarCliente(String nome,
                                 String sobreNome,
                                 String email,
                                 String senha,
                                 String telefone){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSobreNome(sobreNome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setTelefone(telefone);

        clienteDAO.actualizarCliente(cliente);
    }
    public void removerCliente(int id){
        clienteDAO.removerCliente(id);
    }
}