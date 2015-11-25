package view;

import dao.PizzaDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import model.Pizza;
import model.Sabor;
import util.Mensagens;

@ManagedBean
public class PizzaBean {

    Pizza pizza = new Pizza();
    PizzaDao pizzaDao = new PizzaDao();
    private Part file1;
    private String idSelectedPizza;
    private List<Sabor> saboresSelecionados = new ArrayList<>();

    public String getIdSelected() {
        pizza = pizzaDao.procurarPorId(Integer.parseInt(idSelectedPizza));
        return null;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getIdSelectedPizza() {
        return idSelectedPizza;
    }

    public void setIdSelectedPizza(String idSelectedPizza) {
        this.idSelectedPizza = idSelectedPizza;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public List<Sabor> getSaboresSelecionados() {
        return saboresSelecionados;
    }

    public void setSaboresSelecionados(List<Sabor> saboresSelecionados) {
        this.saboresSelecionados = saboresSelecionados;
    }

    public void limparCampos() {
        pizza = null;
    }

    public void salvar() {
        try {
            pizza.setSabores(saboresSelecionados);
            pizzaDao.salvar(pizza);
            limparCampos();
            Mensagens.addMensagem("", "Pizza cadastrada com sucesso.");
        } catch (Exception e) {
            Mensagens.addMensagem("", "Falha ao cadastrar pizza.");

        }

    }

    public void alterar() {
        pizza.setSabores(saboresSelecionados);
        pizzaDao.alterar(pizza);
        limparCampos();
    }

    public void excluir(Pizza pizza) {
        pizzaDao.excluir(pizza);
        limparCampos();
    }

    public List<Pizza> getPizzas() {
        return pizzaDao.listar();
    }

    public void addSaborPizza(Sabor sabor) {

        saboresSelecionados.add(sabor);

    }

}
