package dao;

import java.util.List;
import javax.persistence.Query;
import model.Sabor;
import util.Conexao;

public class SaborDao {

    private Conexao conn = new Conexao();

    public void salvar(Sabor sabor) {
        if (sabor.getId() == null) {
            conn.incluir(sabor);
        } else {
            conn.alterar(sabor);
        }
    }
    
    public void alterar(Sabor sabor) {
        conn.alterar(sabor);
    }

    public void excluir(Sabor sabor) {
        conn.excluir(sabor);
    }

    public List<Sabor> listar() {
        Query q = conn.getEm().createQuery("select sa FROM tb_sabor sa");
        List<Sabor> sabores = q.getResultList();
        conn.desconectar();
        return sabores;
    }

    public Sabor procurarPorId(Integer id) {
        Sabor sb = conn.getEm().find(Sabor.class, id);
        conn.desconectar();
        return sb;
    }

    public Sabor procurarPeloNome(String nome) {
        Query q = conn.getEm().createQuery("select sa FROM tb_sabor sa WHERE sb.nome LIKE '%" + nome + "%'");
        Sabor sb = (Sabor) q.getSingleResult();
        conn.desconectar();
        return sb;
    }
}
