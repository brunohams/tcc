package dao;

import java.util.List;
import javax.persistence.Query;
import model.Produto;
import util.Conexao;

public class ProdutoDao {
    
    private Conexao conn = new Conexao();
    
    public void salvar(Produto produto) {
        if (produto.getId() == null) {
            conn.incluir(produto);
        } else {
            conn.alterar(produto);
        }
    }
    
    public void alterar(Produto produto) {
        conn.alterar(produto);
    }
    
    public void excluir(Produto produto) {
        conn.excluir(produto);
    }
    
    public List<Produto> listar() {
        Query q = conn.getEm().createQuery("select pr FROM tb_produto pr");
        List<Produto> produtos = q.getResultList();
        conn.desconectar();
        return produtos;
    }
    
    public Produto procurarPorId(Integer id) {
        Produto pr = conn.getEm().find(Produto.class, id);
        conn.desconectar();
        return pr;
    }
    
    public Produto procurarPeloNome(String nome) {
        Query q = conn.getEm().createQuery("select pr FROM tb_produto pr WHERE pr.nome LIKE '%" + nome + "%'");
        Produto pr = (Produto) q.getSingleResult();
        conn.desconectar();
        return pr;
    }
    
}
