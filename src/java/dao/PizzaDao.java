package dao;

import java.util.List;
import javax.persistence.Query;
import model.Pizza;
import util.Conexao;

public class PizzaDao {

    private Conexao conn = new Conexao();

    public void salvar(Pizza pizza) {
        if (pizza.getId() == null) {
            conn.incluir(pizza);
        } else {
            conn.alterar(pizza);
        }
    }
    
    public void alterar(Pizza pizza) {
        conn.alterar(pizza);
    }

    public void excluir(Pizza pizza) {
        conn.excluir(pizza);
    }

    public List<Pizza> listar() {
        Query q = conn.getEm().createQuery("select pi FROM tb_pizza pi");
        List<Pizza> pizzas = q.getResultList();
        conn.desconectar();
        return pizzas;
    }
    
    public Pizza procurarPorId(Integer id) {
        Pizza pr = conn.getEm().find(Pizza.class, id);
        conn.desconectar();
        return pr;
    }
    
    public Pizza procurarPeloNome(String nome) {
        Query q = conn.getEm().createQuery("select pi FROM tb_pizza pi WHERE pr.nome LIKE '%" + nome + "%'");
        Pizza pr = (Pizza) q.getSingleResult();
        conn.desconectar();
        return pr;
    }

}
