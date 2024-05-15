package org.gestao_reserva.entity;

class Funcionario extends Utilizadores{
    private String cargo;
    private String setor;
    private int niveldeacesso;
    public Funcionario(String nome, String email, String telefone, String cargo, String setor, int niveldeacesso){
        super(nome, email, telefone);
        this.cargo = cargo;
        this.setor = setor;
        this.niveldeacesso = niveldeacesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getNiveldeacesso() {
        return niveldeacesso;
    }

    public void setNiveldeacesso(int niveldeacesso) {
        this.niveldeacesso = niveldeacesso;
    }
}
