package view;

import dao.ProdutoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import model.Produto;
import util.Mensagens;
import util.UploadUtils;

@ManagedBean
public class ProdutoBean {

    Produto produto = new Produto();
    ProdutoDao produtoDao = new ProdutoDao();
    private Part file1;
    private String idSelectedProduto;

    public String getIdSelected() {
        produto = produtoDao.procurarPorId(Integer.parseInt(idSelectedProduto));
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String getIdSelectedProduto() {
        return idSelectedProduto;
    }

    public void setIdSelectedProduto(String idSelectedProduto) {
        this.idSelectedProduto = idSelectedProduto;
    }

    public void limparCampos() {
        produto = null;
    }

    public void salvar() {
        if (file1 != null) {
            produto.setImagem(UploadUtils.getFilename(file1));
            try {
                UploadUtils.upload(file1);
                Mensagens.addMensagem("", "Produto salvo com sucesso.");
            } catch (Exception e) {
                Mensagens.addMensagem("", "Erro ao salvar produto.");
            }
        }
        produtoDao.salvar(produto);
        limparCampos();
    }

    public String carregarImagem() {
        if (produto.getImagem() != null) {
            return "resources/imgsPizza/" + produto.getImagem();
        }
        return "resources/imgs/pizza3.png";
    }

    public void alterar() {
        produtoDao.salvar(produto);
        limparCampos();
    }

    public void excluir(Produto produto) {
        produtoDao.excluir(produto);
        limparCampos();
    }

    public List<Produto> getProdutos() {
        return produtoDao.listar();
    }

}
