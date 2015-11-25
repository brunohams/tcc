package view;

import dao.FuncionarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Funcionario;
import util.Mensagens;

@ManagedBean
public class FuncionarioBean {

    Funcionario funcionario = new Funcionario();
    FuncionarioDao funcionarioDao = new FuncionarioDao();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void limparCampos() {
        funcionario = null;
    }

    public void salvar() {
        try {
            funcionarioDao.salvar(funcionario);
            limparCampos();
            Mensagens.addMensagem("", "Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            Mensagens.addMensagem("", "Erro ao cadastrar funcionário.");

        }

    }

    public void excluir(Funcionario funcionario) {
        funcionarioDao.excluir(funcionario);
        limparCampos();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioDao.listar();
    }

}
