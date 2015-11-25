package dao;

import java.util.List;
import javax.persistence.Query;
import model.Cliente;
import model.Pizza;
import model.Produto;
import util.Conexao;

public class ClienteDAO {

    private Conexao conn = new Conexao();

    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            conn.incluir(cliente);
        } else {
            conn.alterar(cliente);
        }
    }

    public void alterar(Cliente cliente) {
        conn.alterar(cliente);
    }

    public void excluir(Cliente cliente) {
        conn.excluir(cliente);
    }

    public List<Cliente> listar() {
        Query q = conn.getEm().createQuery("select c from tb_cliente c");
        List<Cliente> clientes = q.getResultList();
        conn.desconectar();
        return clientes;
    }

    public Cliente procurarPorId(Integer id) {
        Cliente c = conn.getEm().find(Cliente.class, id);
        conn.desconectar();
        return c;
    }

    public Cliente procurarPeloNome(String nome) {
        Query q = conn.getEm().createQuery("select c FROM tb_cliente c WHERE c.nome LIKE '%" + nome + "%'");
        Cliente c = (Cliente) q.getSingleResult();
        conn.desconectar();
        return c;
    }

}
