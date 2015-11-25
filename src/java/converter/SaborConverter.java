package converter;

import dao.SaborDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Sabor;

@FacesConverter("saborConverter")
public class SaborConverter implements Converter{

    private SaborDao saborDao = new SaborDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return (value != null && !value.isEmpty()) ? saborDao.procurarPorId(Integer.parseInt(value)) : null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        try {
            Sabor sabor = (Sabor) value;
            return sabor.getId() != null ? String.valueOf(sabor.getId()) : null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar converter: " + e.getMessage());
        }
        return null;
    }

    

}
