package controller;

import model.Login;

public class LoginControler {

    Login login = new Login();

    public LoginControler(Login log) {
        this.login = login;
    }

    public String logar() {
        if (login.getEmailnome().equals("admin") && login.getSenha().equals("admin")) {
            login.isLogado();
        } else {
            return "Login ou Senha inválidos";
        }

        return null;
    }

}
