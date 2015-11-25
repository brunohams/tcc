package view;

import dao.PizzaDao;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Carrinho;
import model.Pizza;
import model.Produto;

@ManagedBean
public class CarrinhoBean {

    Carrinho carrinho = new Carrinho();
    public static List<Pizza> pizzapersonalizada = new ArrayList<>();
    private static String idsabor;
    private static Double totalPedido = 0.0;
    PizzaDao pizzaDao = new PizzaDao();

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public static List<Pizza> getPizzapersonalizada() {
        return pizzapersonalizada;
    }

    public static void setPizzapersonalizada(List<Pizza> pizzapersonalizada) {
        CarrinhoBean.pizzapersonalizada = pizzapersonalizada;
    }

    public String getIdsabor() {
        return idsabor;
    }

    public void setIdsabor(String idsabor) {
        this.idsabor = idsabor;
    }

    public void addPizzaCarrinho(Pizza pizza) {
        Carrinho.pizzascarrinho.add(pizza);
        totalPedido += pizza.getPreco();
    }

    public void excluirPizzaCarrinho(Pizza pizza) {
        Carrinho.pizzascarrinho.remove(pizza);
        totalPedido -= pizza.getPreco();
    }

    public void addSabor(Pizza pizza) {
        pizzapersonalizada.add(pizza);
    }

    public void addProdutoCarrinho(Produto produto) {
        Carrinho.produtoscarrinho.add(produto);
        totalPedido += produto.getPreco();
    }

    public void exlcuirProdutoCarrinho(Produto produto) {
        Carrinho.produtoscarrinho.remove(produto);
        totalPedido -= produto.getPreco();
    }

}
