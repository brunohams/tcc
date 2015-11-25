package controller;

import model.Cliente;
import util.Conexao;

public class ClienteController {
    
    private Conexao conn = new Conexao();
    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
//    public void verificarSenha() {
//        if(cliente.getSenha().equals(cliente.getConfirmarSenha())) {
//            conn.incluir(cliente);
//        } else {
//            System.out.println("As senhas não coincidem!");
//        }
//    }
    
}
