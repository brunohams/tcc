package view;

import dao.ItensPedidoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.ItensPedido;

@ManagedBean
public class ItensPedidoBean {
    
    ItensPedido itensPedido = new ItensPedido();
    ItensPedidoDao itensPedidoDao = new ItensPedidoDao();

    public ItensPedido getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ItensPedido itensPedido) {
        this.itensPedido = itensPedido;
    }
    
    public void salvar(ItensPedido itensPedido) {
        itensPedidoDao.salvar(itensPedido);
    }
    
    public void exlcuir(ItensPedido itensPedido) {
        itensPedidoDao.excluir(itensPedido);
    }
    
    public List<ItensPedido> getItensPedidos() {
        return itensPedidoDao.listar();
    }
    
}
