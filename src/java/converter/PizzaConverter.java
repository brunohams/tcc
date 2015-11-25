package converter;

import dao.PizzaDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Pizza;

@FacesConverter("pizzaConverter")
public class PizzaConverter implements Converter {
    
    private PizzaDao pizzaDao = new PizzaDao();    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return (value != null && !value.isEmpty()) ? pizzaDao.procurarPorId(Integer.parseInt(value)) : null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        try {
            Pizza pizza = (Pizza) value;
            return pizza.getId() != null ? String.valueOf(pizza.getId()) : null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar converter: " + e.getMessage());
        }
        return null;
    }
    
}
