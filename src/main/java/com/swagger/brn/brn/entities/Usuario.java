package com.swagger.brn.brn.entities;

//Classe contendo a estrutura do objeto usuario, e seus tipos
public class Usuario {
    private Integer id;
    private String login;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Usuario(String login, String password) {
        this.id = 10;
        this.login = login;
        this.password = password;
    }

    public Usuario(Integer id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword(){
        return password;
    }

}
