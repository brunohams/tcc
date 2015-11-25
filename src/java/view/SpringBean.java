package view;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean
public class SpringBean {

    private String cliente;
    private final FacesContext fc = FacesContext.getCurrentInstance();
    private final ExternalContext ec = fc.getExternalContext();
    private String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }



    public SpringBean() throws IOException {
        cliente = SecurityContextHolder.getContext().getAuthentication().getName();
        url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        
        /**
         * Aqui eu redireciono de acordo com o login da pessoa.
         * Você deve modificar isso buscando o usuário que possua esse login e 
         * mudar o switch abaixo para redirecionar de acordo com o perfil de pessoa.
         */
        switch(cliente.toLowerCase()) {
            case "admin":
                ec.redirect(url + "/admin/testeWilliam.jsf");
                break;
            case "degenerationsgamers@gmail.com":
                ec.redirect(url + "/relatorios/index.jsf");
                break;
            case "relatorios":
                ec.redirect(url + "/relatorios/indexFinanceiro.jsf");
                break;
        }        
    }
}
