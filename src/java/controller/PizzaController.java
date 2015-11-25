package controller;

import java.util.ArrayList;
import java.util.List;
import model.Pizza;

public class PizzaController {
    
    private List<Pizza> pizzas = new ArrayList<Pizza>();
    private Pizza pizza;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
    
    
    
}
