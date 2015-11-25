package dao;

import java.util.List;
import javax.persistence.Query;
import model.ItensPedido;
import model.Produto;
import util.Conexao;

public class ItensPedidoDao {

    private Conexao conn = new Conexao();

    public void salvar(ItensPedido itensPedido) {
        if (itensPedido.getId() == null) {
            conn.incluir(itensPedido);
        } else {
            conn.alterar(itensPedido);
        }
    }
    public void alterar(ItensPedido itensPedido) {
        conn.alterar(itensPedido);
    }
    
    public void excluir(ItensPedido itensPedido) {
        conn.excluir(itensPedido);
    }
    
    public List<ItensPedido> listar() {
        Query q = conn.getEm().createQuery("select it FROM tb_itensPedido it");
        List<ItensPedido> itensPedido = q.getResultList();
        conn.desconectar();
        return itensPedido;
    }

}
