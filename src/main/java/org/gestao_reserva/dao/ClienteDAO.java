package org.gestao_reserva.dao;

import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.connection.Connect;
import org.gestao_reserva.entity.Cliente;
import org.gestao_reserva.entity.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void criarContaCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTES (nome, sobrenome, email, senha, telefone, preferancia) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobreNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSenha());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getPreferencia());
            ps.execute();
            ps.close();

            System.out.println("\nCONTA CRIADO COM SUCESSO\n");
        }catch(SQLException e){
            System.out.println("Erro ao criarConta");
            e.getMessage().toString();
        }
    }


    public Cliente umCliente(String email){
        Connection con = Connect.getConnection();
        Cliente cliente = null;
        String sql = "SELECT * FROM CLIENTES WHERE email = ?";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setString(1, email);
            ResultSet result = smt.executeQuery();
            if(result.next()){
                cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSobreNome(result.getString("sobrenome"));
                cliente.setEmail(result.getString("email"));
                cliente.setSenha(result.getString("senha"));
                cliente.setTelefone(result.getString("telefone"));
            }else{
                return cliente;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return cliente;
    }

    public void actualizarCliente(Cliente cliente){
        Connection con = Connect.getConnection();
        StringBuilder sql = new StringBuilder("UPDATE CLIENTES SET ");
        List<Object> params = new ArrayList<>();

        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            sql.append("nome = ?, ");
            params.add(cliente.getNome());
        }
        if (cliente.getSobreNome() != null && !cliente.getSobreNome().isEmpty()) {
            sql.append("sobrenome = ?, ");
            params.add(cliente.getSobreNome());
        }
        if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
            sql.append("email = ?, ");
            params.add(cliente.getEmail());
        }
        if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()) {
            sql.append("senha = ?, ");
            params.add(cliente.getSenha());
        }
        if (cliente.getTelefone() != null && !cliente.getTelefone().isEmpty()) {
            sql.append("telefone = ?, ");
            params.add(cliente.getTelefone());
        }

        // remover ultima virgula e espaço
        if (!params.isEmpty()) {
            sql.setLength(sql.length() - 2);
            sql.append(" WHERE id = ?");
            params.add(AuthManager.getClienteLogado().getId());

            try (PreparedStatement smt = con.prepareStatement(sql.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    smt.setObject(i + 1, params.get(i));
                }

                smt.executeUpdate();
                System.out.println("\nDADOS DO CLIENTE ATUALIZADO\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("\nNenhum dado para atualizar.\n");
        }
    }


    public void removerCliente(int id){
        Connection con = Connect.getConnection();
        String sql = "DELETE FROM CLIENTES WHERE id = ? ";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, id);
            smt.executeUpdate();
            smt.close();
            System.out.println("\nCLIENTE REMOVIDO COM SUCESSO\n");
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());;
        }
    }
}