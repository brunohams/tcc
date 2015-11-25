package view;

import dao.ClienteDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;
import model.Cliente;

@ManagedBean
public class ClienteBean {

    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    private String idSelectedCliente;
    
    public String getIdSelected() {
        cliente = clienteDAO.procurarPorId(Integer.parseInt(idSelectedCliente));
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdSelectedCliente() {
        return idSelectedCliente;
    }

    public void setIdSelectedCliente(String idSelectedCliente) {
        this.idSelectedCliente = idSelectedCliente;
    }    

    public void limparCampos() {
        cliente = null;
    }

    public void salvar() {
        clienteDAO.salvar(cliente);
        limparCampos();
    }

    public void excluir(Cliente cliente) {
        clienteDAO.excluir(cliente);
        limparCampos();
    }

    public List<Cliente> getClientes() {
        return clienteDAO.listar();
    }

}
