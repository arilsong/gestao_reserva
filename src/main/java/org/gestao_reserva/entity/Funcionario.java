package org.gestao_reserva.entity;

class Funcionario extends Utilizadores{
    private String cargo;
    private String setor;
    public Funcionario(String nome, String email, String telefone, String cargo, String setor){
        super(nome, email, telefone);
        this.cargo = cargo;
        this.setor = setor;
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
}
