package org.gestao_reserva.dao;


import org.gestao_reserva.Auth.AuthManager;
import org.gestao_reserva.connection.Connect;
import org.gestao_reserva.entity.Cliente;
import org.gestao_reserva.entity.Quarto;
import org.gestao_reserva.entity.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    public void adicionarReserva(Reserva reserva, int idQuarto){
        String sql = "INSERT INTO reservas (dataCheckin, dataCheckout, valorTotal, id_cliente, id_acomodacao) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setDate(1,  new java.sql.Date(reserva.getDataCheckin().getTime()));
            ps.setDate(2,  new java.sql.Date(reserva.getDataCheckout().getTime()));
            ps.setDouble(3, reserva.getValorTotal());
            ps.setInt(4, AuthManager.getClienteLogado().getId());
            ps.setInt(5, idQuarto);
            ps.execute();
            ps.close();

            System.out.println("\nReserva feito com sucesso\n");
        }catch(SQLException e){
            System.out.println("Erro ao fazer reserva: " + e.getMessage().toString());


        }
    }

    public List<Reserva> lisarReservaCliente(){
        Connection con = Connect.getConnection();
        List<Reserva> listaReserva = new ArrayList<>();

        String sql = "SELECT reservas.id as id_reserva, reservas.*, acomodacoes.* FROM reservas JOIN clientes ON clientes.id = reservas.id_cliente JOIN acomodacoes ON acomodacoes.id = reservas.id_acomodacao WHERE clientes.id = ?";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, AuthManager.getClienteLogado().getId());
            ResultSet result = smt.executeQuery();
            while (result.next()){
                Reserva reserva = new Reserva();
                Quarto quarto = new Quarto();
                reserva.setId(result.getInt("id"));
                reserva.setDataCheckin(result.getDate("dataCheckin"));
                reserva.setDataCheckout(result.getDate("dataCheckout"));
                reserva.setEstado(result.getBoolean("estado"));
                reserva.setValorTotal(result.getDouble("valorTotal"));

                quarto.setNumero(result.getInt("numero"));
                quarto.setTipo(result.getString("tipo"));
                quarto.setQuantidadeLeitos(result.getInt("quantidade_leitos"));
                quarto.setPrecoBase(result.getDouble("preco_base"));


                reserva.setQuartos(quarto);

                listaReserva.add(reserva);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return listaReserva;
    }

    public List<Reserva> listaReservas(){
        Connection con = Connect.getConnection();
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT reservas.*, clientes.*, acomodacoes.* FROM reservas JOIN clientes ON clientes.id = reservas.id_cliente join acomodacoes on acomodacoes.id = reservas.id_acomodacao";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet result = smt.executeQuery();
            while (result.next()){
                Reserva reserva = new Reserva();
                Quarto quarto = new Quarto();
                Cliente cliente = new Cliente();

                reserva.setId(result.getInt("id"));
                reserva.setDataCheckin(result.getDate("dataCheckin"));
                reserva.setDataCheckout(result.getDate("dataCheckout"));
                reserva.setValorTotal(result.getDouble("valorTotal"));

                quarto.setNumero(result.getInt("numero"));
                quarto.setTipo(result.getString("tipo"));

                cliente.setNome(result.getString("nome"));
                cliente.setSobreNome(result.getString("sobrenome"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));

                reserva.setQuarto(quarto);
                reserva.setCliente(cliente);

                lista.add(reserva);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return lista;
    }

    public Reserva umReserva(int id){
        Connection con = Connect.getConnection();
        Reserva reserva = null;
        String sql = "SELECT * FROM reservas WHERE id = ?";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, id);
            ResultSet result = smt.executeQuery();
            if(result.next()){
                reserva = new Reserva();
                reserva.setId(result.getInt("id"));
                reserva.setDataCheckin(result.getDate("dataCheckin"));
                reserva.setDataCheckout(result.getDate("dataCheckout"));
                reserva.setEstado(result.getBoolean("estado"));
                reserva.setValorTotal(result.getDouble("valorTotal"));
            }else{
                return reserva;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return reserva;
    }

    public void atualizarReserva(Reserva reserva,int idReserva){
        Connection con = Connect.getConnection();
        StringBuilder sql = new StringBuilder("UPDATE RESERVAS SET ");
        List<Object> params = new ArrayList<>();

        if(reserva.getDataCheckin() != null) {
            sql.append("dataCheckin = ?, ");
            params.add(reserva.getDataCheckin());
        }

        if (reserva.getDataCheckout() != null) {
            sql.append("dataCheckout = ?, ");
            params.add(reserva.getDataCheckout());
        }

        if (reserva.getValorTotal() != 0) {
            sql.append("valorTotal = ?, ");
            params.add(reserva.getValorTotal());
        }

        if (!params.isEmpty()) {
            sql.setLength(sql.length() - 2);
//            sql.append(" valorTotal = ?");
//            params.add(reserva.getValorTotal());
            sql.append(" WHERE id = ?");
            params.add(idReserva);

            try (PreparedStatement smt = con.prepareStatement(sql.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    smt.setObject(i + 1, params.get(i));
                }

                smt.executeUpdate();
                System.out.println("\nDADOS DA RESERVA ATUALIZADO\n");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("\nNenhum dado para atualizar.\n");
        }
    }

    public void atualizarReserva1(Reserva reserva, int idReserva){
        String sql = "UPDATE RESERVAS SET dataCheckin = ?, dataCheckout = ? WHERE id = ?";

        PreparedStatement ps = null;

        try{
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setDate(1, (Date) reserva.getDataCheckin());
            ps.setDate(2,(Date) reserva.getDataCheckout());
            ps.executeUpdate();
            ps.close();

            System.out.println("\nReserva atualizada com sucesso\n");
        }catch(SQLException e){
            System.out.println("Erro ao atualizar reserva");
            e.getMessage().toString();
        }
    }
    public void removerReserva(int id){
        Connection con = Connect.getConnection();
        String sql = "DELETE FROM RESERVAS WHERE id = ? ";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, id);
            smt.executeUpdate();
            smt.close();
            System.out.println("\nRESERVA REMOVIDO COM SUCESSO\n");
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());;
        }
    }

    //alternativa para ir busacar numero de acomodacao relacionado a reserva para poder calcular preco total de novo caso o utilizador mudar a data de chechOu
    public int buscarIdAcomodacao(int idReserva){
        Connection con = Connect.getConnection();
        int numeroQuarto = 0;
        String sql = "SELECT acomodacoes.numero FROM reservas JOIN clientes ON clientes.id = reservas.id_cliente join acomodacoes on acomodacoes.id = reservas.id_acomodacao WHERE reservas.id = ?";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, idReserva);
            ResultSet result = smt.executeQuery();
            if(result.next()){
                numeroQuarto = result.getInt("numero");
            }else{
                return numeroQuarto;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return numeroQuarto;
    }
}
