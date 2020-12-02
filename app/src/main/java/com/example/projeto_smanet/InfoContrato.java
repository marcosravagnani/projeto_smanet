package com.example.projeto_smanet;

public class InfoContrato {
    private String plano, valor, login, senha;

    public InfoContrato(){

    }
    public InfoContrato(String plano, String valor, String login, String senha) {
        this.plano = plano;
        this.login = login;
        this.senha = senha;
        this.valor = valor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
