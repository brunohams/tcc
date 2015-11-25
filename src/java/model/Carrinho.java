package model;

import java.util.ArrayList;
import java.util.List;


public class Carrinho {
    public static List<Pizza> pizzascarrinho = new ArrayList<>();  
    public static List<Produto> produtoscarrinho = new ArrayList<>();  

            
    public Carrinho() {
    }

    
    public List<Pizza> getPizzascarrinho() {
        return pizzascarrinho;
    }

    public void setPizzascarrinho(List<Pizza> pizzascarrinho) {
        Carrinho.pizzascarrinho = pizzascarrinho;
    }

    public List<Produto> getProdutoscarrinho() {
        return produtoscarrinho;
    }

    public void setProdutoscarrinho(List<Produto> produtoscarrinho) {
        Carrinho.produtoscarrinho = produtoscarrinho;
    }


   

    

    
    
}
