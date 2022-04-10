package com.example.exemplo_1.modelos;

public class Usuario implements Cloneable{

    private int id;
    private String loginEmail;
    private String senha;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String telefone;


    public Usuario(){}

    public Usuario(String loginEmail, String senha){
        this.loginEmail = loginEmail;
        this.senha = senha;
    }

    public Usuario(int id, String loginEmail, String senha){
        this.id = id;
        this.loginEmail = loginEmail;
        this.senha = senha;
    }


    public Usuario(Usuario u){
       this.id = u.id;
       this.loginEmail = u.loginEmail;
       this.senha = u.senha;
       this.nome = u.nome;
       this.sobrenome = u.sobrenome;
       this.dataNascimento = u.dataNascimento;
       this.telefone = u.telefone;
    }

    public Usuario(int id, String loginEmail, String senha, String nome, String sobrenome,
                   String dataNascimento, String telefone ) {
        this.id = id;
        this.loginEmail = loginEmail;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }
    public Usuario(String nome, String sobrenome, String loginEmail, String dataNascimento,
                   String telefone, String senha ) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.loginEmail = loginEmail;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.senha = senha;
    }


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLoginEmail() {
        return this.loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }


    @Override
    public Object clone(){
        Usuario clone = new Usuario(this);
        return clone;
    }

}
