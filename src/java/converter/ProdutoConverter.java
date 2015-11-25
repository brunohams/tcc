package converter;

import dao.ProdutoDao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

    private ProdutoDao produtoDao = new ProdutoDao();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return (value != null && !value.isEmpty()) ? produtoDao.procurarPorId(Integer.parseInt(value)) : null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        try {
            Produto produto = (Produto) value;
            return produto.getId() != null ? String.valueOf(produto.getId()) : null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar converter: " + e.getMessage());
        }
        return null;
    }

}