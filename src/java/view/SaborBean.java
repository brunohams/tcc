package view;

import dao.SaborDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import model.Pizza;
import model.Sabor;
import util.Mensagens;
import util.UploadUtils;

@ManagedBean
public class SaborBean {

    Pizza pizza = new Pizza();
    Sabor sabor = new Sabor();
    SaborDao saborDao = new SaborDao();
    private String idSelectedSabor;
    private Part file1;


    public String getIdSelected() {
        sabor = saborDao.procurarPorId(Integer.parseInt(idSelectedSabor));
        return null;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String getIdSelectedSabor() {
        return idSelectedSabor;
    }

    public void setIdSelectedSabor(String idSelectedSabor) {
        this.idSelectedSabor = idSelectedSabor;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void limparCampos() {
        sabor = null;
    }

    public void salvar() {
        if (file1 != null) {
            sabor.setImagem(UploadUtils.getFilename(file1));
            try {
                UploadUtils.upload(file1);
                Mensagens.addMensagem("", "Salvo com sucesso!!");
            } catch (Exception e) {
                Mensagens.addMensagem("", "Erro ao salvar imagem!!");
            }
        }
        saborDao.salvar(sabor);
        limparCampos();
    }

    public String carregarImagem() {
        if (sabor.getImagem() != null) {
            return "resources/imgsPizza/" + sabor.getImagem();
        }
        return "resources/imgs/pizza3.png";
    }

    public void alterar() {
        saborDao.alterar(sabor);
        limparCampos();
    }

    public void excluir(Sabor sabor) {
        saborDao.excluir(sabor);
        limparCampos();
    }

    public List<Sabor> getSabores() {
        return saborDao.listar();
    }


}
