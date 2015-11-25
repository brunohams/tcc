package dao;

import java.util.List;
import javax.persistence.Query;
import model.Funcionario;
import util.Conexao;

public class FuncionarioDao {

    private Conexao conn = new Conexao();

    public void salvar(Funcionario funcionario) {
        if (funcionario.getId() == null) {
            conn.incluir(funcionario);
        } else {
            conn.alterar(funcionario);
        }
    }
    
    public void excluir(Funcionario funcionario) {
        conn.excluir(funcionario);
    }
    
    public void alterar(Funcionario funcionario) {
        conn.alterar(funcionario);
    }
    
    public List<Funcionario> listar() {
        Query q = conn.getEm().createQuery("select f FROM tb_funcionario f");
        List<Funcionario> funcionarios = q.getResultList();
        conn.desconectar();
        return funcionarios;
    }
    
    public Funcionario procurarPorId(Integer id) {
        Funcionario f = conn.getEm().find(Funcionario.class, id);
        conn.desconectar();
        return f;
    }
    
    public Funcionario procurarPeloNome(String nome) {
        Query q = conn.getEm().createQuery("select f FROM tb_funcionario f WHERE f.nome LIKE '%" + nome + "%'");
        Funcionario f = (Funcionario) q.getSingleResult();
        conn.desconectar();
        return f;
    }

}
