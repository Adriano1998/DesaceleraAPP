package com.example.exemplo_1.modelos;

public class Profissional implements Cloneable{

    private int id_profissionais;
    private String loginEmail_profissionais;
    private String senha_profissionais;
    private String nome_profissionais;
    private String sobrenome_profissionais;
    private String numeroRegistro_profissionais;
    private String dataNascimento_profissionais;


    public Profissional(){}

    public Profissional(String loginEmail_profissionais, String senha_profissionais){
        this.loginEmail_profissionais = loginEmail_profissionais;
        this.senha_profissionais = senha_profissionais;
    }

    public Profissional(String nome_profissionais, String numeroRegistro_profissionais, String loginEmail_profissionais){
        this.nome_profissionais = nome_profissionais;
        this.numeroRegistro_profissionais = numeroRegistro_profissionais;
        this.loginEmail_profissionais = loginEmail_profissionais;
    }

    public Profissional(int id_profissionais, String loginEmail_profissionais, String senha_profissionais){
        this.id_profissionais = id_profissionais;
        this.loginEmail_profissionais = loginEmail_profissionais;
        this.senha_profissionais = senha_profissionais;
    }

    public Profissional(int id_profissionais, String loginEmail_profissionais, String senha_profissionais,
                        String nome_profissionais, String sobrenome_profissionais,
                        String numeroRegistro_profissionais, String dataNascimento_profissionais){
        this.id_profissionais = id_profissionais;
        this.loginEmail_profissionais = loginEmail_profissionais;
        this.senha_profissionais = senha_profissionais;
        this.nome_profissionais = nome_profissionais;
        this.sobrenome_profissionais = sobrenome_profissionais;
        this.numeroRegistro_profissionais = numeroRegistro_profissionais;
        this.dataNascimento_profissionais = dataNascimento_profissionais;
    }



    public Profissional(Profissional p){
        this.id_profissionais = p.id_profissionais;
        this.loginEmail_profissionais = p.loginEmail_profissionais;
        this.senha_profissionais = p.senha_profissionais;
        this.nome_profissionais = p.nome_profissionais;
        this.sobrenome_profissionais = p.sobrenome_profissionais;
        this.numeroRegistro_profissionais = p.numeroRegistro_profissionais;
        this.dataNascimento_profissionais = p.dataNascimento_profissionais;
    }
    public Profissional(String nome_profissionais, String sobrenome_profissionais, String loginEmail_profissionais,
                        String numeroRegistro_profissionais,
                        String dataNascimento_profissionais, String senha_profissionais){
        this.nome_profissionais = nome_profissionais;
        this.sobrenome_profissionais = sobrenome_profissionais;
        this.loginEmail_profissionais = loginEmail_profissionais;
        this.numeroRegistro_profissionais = numeroRegistro_profissionais;
        this.dataNascimento_profissionais = dataNascimento_profissionais;
        this.senha_profissionais = senha_profissionais;
    }



    public int getId_profissionais(){
        return this.id_profissionais;
    }

    public void setId_profissionais(int id_profissionais){
        this.id_profissionais = id_profissionais;
    }

    public String getLoginEmail_profissionais() {
        return this.loginEmail_profissionais;
    }

    public void setLoginEmail_profissionais(String loginEmail_profissionais) {
        this.loginEmail_profissionais = loginEmail_profissionais;
    }

    public String getSenha_profissionais(){
        return this.senha_profissionais;
    }

    public void setSenha_profissionais(String senha_profissionais){
        this.senha_profissionais = senha_profissionais;
    }

    public String getNome_profissionais(){
        return this.nome_profissionais;
    }
    public void setNome_profissionais(String nome_profissionais){
        this.nome_profissionais = nome_profissionais;
    }

    public String getSobrenome_profissionais(){
        return this.sobrenome_profissionais;
    }
    public void setSobrenome_profissionais(String sobrenome_profissionais){
        this.sobrenome_profissionais = sobrenome_profissionais;
    }
    public String getNumeroRegistro_profissionais(){
        return this.numeroRegistro_profissionais;
    }
    public void setNumeroRegistro_profissionais(String numeroRegistro_profissionais){
        this.numeroRegistro_profissionais = numeroRegistro_profissionais;
    }
    public String getDataNascimento_profissionais(){
        return this.dataNascimento_profissionais;
    }
    public void setDataNascimento_profissionais(String dataNascimento_profissionais){
        this.dataNascimento_profissionais = dataNascimento_profissionais;
    }



    @Override
    public Object clone(){
        Profissional clone = new Profissional(this);
        return clone;
    }
}
