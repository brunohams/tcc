
package model;


public class Login {
    
    private String emailnome;
    private String senha;
    private boolean logado;
    public Login() {
    }

    public Login(String emailnome, String senha) {
        this.emailnome = emailnome;
        this.senha = senha;
    }

    
    public String getEmailnome() {
        return emailnome;
    }

    public void setEmailnome(String emailnome) {
        this.emailnome = emailnome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
   
    
    
    
    
}
