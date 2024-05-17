package org.gestao_reserva.entity;

import java.util.ArrayList;
import java.util.List;

class Cliente extends Utilizadores {
    private String endereco;
    private String preferecia;
    private List<Reserva> historicoReservas;
    public Cliente(String nome, String email, String telefone, String endereco, String preferecia){
        super(nome, email, telefone);
        this.endereco = endereco;
        this.preferecia = preferecia;
        this.historicoReservas = new ArrayList<>();
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPreferecia(){
        return preferecia;
    }

    public void setPreferecia(String preferecia) {
        this.preferecia = preferecia;
    }

    public List<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public void adicionarReserva(Reserva reserva){
        historicoReservas.add(reserva);
    }
}
