package dao;

import java.util.List;
import javax.persistence.Query;
import model.Pedido;
import model.Produto;
import util.Conexao;

public class PedidoDao {

    private Conexao conn = new Conexao();

    public void salvar(Pedido pedido) {
        if (pedido.getId() == null) {
            conn.incluir(pedido);
        } else {
            conn.alterar(pedido);
        }
    }

    public void alterar(Pedido pedido) {
        conn.alterar(pedido);
    }

    public void excluir(Pedido pedido) {
        conn.excluir(pedido);
    }

    public List<Pedido> listar() {
        Query q = conn.getEm().createQuery("select pedid FROM tb_pedido pedid");
        List<Pedido> pedidos = q.getResultList();
        conn.desconectar();
        return pedidos;
    }

}
