package org.gestao_reserva.dao;

import org.gestao_reserva.connection.Connect;
import org.gestao_reserva.entity.Funcionario;
import org.gestao_reserva.entity.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {
    public void adcionarQuarto(Quarto quarto){
        String sql = "INSERT INTO acomodacoes (numero, tipo, quantidade_leitos, preco_base, tamanho) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setDouble(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setInt(3, quarto.getQuantidadeLeitos());
            ps.setDouble(4, quarto.getPrecoBase());
            ps.setString(5, quarto.getTamanho());


            ps.execute();
            ps.close();

            System.out.println("\nQuarto Adicionado\n");
        }catch(SQLException e){
            System.out.println("Erro ao adicionar quarto");
            System.out.println(e.getMessage().toString());
        }
    }

    public List<Quarto> listarQuarto(){
        Connection con = Connect.getConnection();
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM ACOMODACOES";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet result = smt.executeQuery();
            while (result.next()){
                Quarto quarto = new Quarto();
                quarto.setId(result.getInt("id"));
                quarto.setNumero(result.getInt("numero"));
                quarto.setTipo(result.getString("tipo"));
                quarto.setQuantidadeLeitos(result.getInt("quantidade_leitos"));
                quarto.setPrecoBase(result.getDouble("preco_base"));
                quarto.setTamanho(result.getString("tamanho"));
                quarto.setEstado(result.getBoolean("estado"));

                lista.add(quarto);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return lista;
    }

    public Quarto umQuarto(int numeroQuarto){
        Connection con = Connect.getConnection();
        Quarto quarto = null;
        String sql = "SELECT * FROM ACOMODACOES WHERE numero = ?";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, numeroQuarto);
            ResultSet result = smt.executeQuery();
            if(result.next()){
                quarto = new Quarto();
                quarto.setId(result.getInt("id"));
                quarto.setNumero(result.getInt("numero"));
                quarto.setTipo(result.getString("tipo"));
                quarto.setQuantidadeLeitos(result.getInt("quantidade_leitos"));
                quarto.setPrecoBase(result.getDouble("preco_base"));
                quarto.setTamanho(result.getString("tamanho"));
                quarto.setEstado(result.getBoolean("estado"));
            }else{
                return quarto;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
        return quarto;
    }

    public void actualizarQuarto(Quarto quarto){
        Connection con = Connect.getConnection();
        String sql = "UPDATE ACOMODACOES SET numero = ?, tipo = ?, quantidade_leitos = ?, quantidade_leitos = ?, tamanho = ? WHERE id = ?";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setDouble(1, quarto.getNumero());
            smt.setString(2, quarto.getTipo());
            smt.setInt(3, quarto.getQuantidadeLeitos());
            smt.setDouble(4, quarto.getPrecoBase());
            smt.setString(5, quarto.getTamanho());

            smt.executeUpdate();
            smt.close();
            System.out.println("\nDADOS DO QUARTO ATUALIZDO\n");
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }
    }

    public void actualizarEstadoQuarto(boolean estado, int id){
        Connection con = Connect.getConnection();
        String sql = "UPDATE ACOMODACOES SET estado = ? WHERE id = ?";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setBoolean(1, estado);
            smt.setDouble(2, id);


            smt.executeUpdate();
            smt.close();
            System.out.println("\nDADOS DO QUARTO ATUALIZDO\n");
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());
        }

    }

    public void removerQuarto(int numeroQuarto){
        Connection con = Connect.getConnection();
        String sql = "DELETE FROM ACOMODACOES WHERE numero = ? ";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, numeroQuarto);
            smt.executeUpdate();
            smt.close();
            System.out.println("\nQUARTO REMOVIDO COM SUCESSO\n");
        }catch (SQLException e){
            System.out.println(e.getMessage().toString());;
        }
    }

}
