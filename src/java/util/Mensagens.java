package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagens {
        
    public static void addMensagem(String tipo, String mensagem) {
        FacesMessage message = new FacesMessage(tipo, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
