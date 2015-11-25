package view;

import dao.PizzaDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import model.Pizza;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.Mensagens;

@ManagedBean
public class RelatorioBean {

    private String pdfselecionado = "";

    public String getPdfselecionado() {
        return pdfselecionado;
    }

    public void setPdfselecionado(String pdfselecionado) {
        this.pdfselecionado = pdfselecionado;
    }


    public void relatorioPizzas() throws JRException, SQLException {
        PizzaBean pizzaBean = new PizzaBean();
        List lista = new ArrayList();
        String nomePDF = "RelatorioPizza.pdf";
        try {
            System.out.println("Gerando relatório...");
            lista = pizzaBean.getPizzas();

            JasperReport report = JasperCompileManager
                    .compileReport("C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\relatorios\\RelatorioPizzas.jrxml");

            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\web\\"+nomePDF);
            System.out.println("Relatório gerado.");
            Mensagens.addMensagem("", "Relatório gerado com sucesso!");
            pdfselecionado = nomePDF;
            
        } catch (Exception e) {
            System.out.println("Não foi possivel gerar o relatório" + e);
            Mensagens.addMensagem("", "Falha ao gerar relatório!");
        }

    }

    public void relatorioPizzasPrecos() throws JRException, SQLException {
        PizzaBean pizzaBean = new PizzaBean();
        List lista = new ArrayList();
        String nomePDF = "RelatorioPizzaPrecos.pdf";

        try {
            System.out.println("Gerando relatório...");
            lista = pizzaBean.getPizzas();

            JasperReport report = JasperCompileManager
                    .compileReport("C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\relatorios\\RelatorioPizzasPrecos.jrxml");

            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\web\\"+nomePDF);
            System.out.println("Relatório gerado.");
            Mensagens.addMensagem("", "Relatório gerado com sucesso!");
            pdfselecionado = nomePDF;

        } catch (Exception e) {
            System.out.println("Não foi possivel gerar o relatório" + e);
            Mensagens.addMensagem("", "Falha ao gerar relatório!");

        }

    }

    public void relatorioClientesCadastrados() throws JRException, SQLException {
        ClienteBean clienteBean = new ClienteBean();
        List lista = new ArrayList();
        String nomePDF = "RelatorioClientesCadastrados.pdf";

        try {
            System.out.println("Gerando relatório...");
            lista = clienteBean.getClientes();

            JasperReport report = JasperCompileManager
                    .compileReport("C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\relatorios\\RelatorioClientesCadastrados.jrxml");

            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));

            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Senai\\Documents\\NetBeansProjects\\TCC\\web\\"+nomePDF);
            System.out.println("Relatório gerado.");
            Mensagens.addMensagem("", "Relatório gerado com sucesso!");
            pdfselecionado = nomePDF;

        } catch (Exception e) {
            System.out.println("Não foi possivel gerar o relatório" + e);
            Mensagens.addMensagem("", "Falha ao gerar relatório!");

        }
    }

}
