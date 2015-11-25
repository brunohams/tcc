package view;

import dao.PedidoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Pedido;

@ManagedBean
public class PedidoBean {
    
    Pedido pedido = new Pedido();
    PedidoDao pedidoDao = new PedidoDao();

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void limparCampos() {
        pedido = null;
    }
    
    public void salvar() {
        pedidoDao.salvar(pedido);
        pedido = new Pedido();
        limparCampos();
    }
    
    public void excluir() {
        pedidoDao.excluir(pedido);
        limparCampos();
    }
    
    public List<Pedido> getPedidos() {
        return pedidoDao.listar();
    }
    
}
