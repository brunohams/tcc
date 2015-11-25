package view;

import controller.LoginControler;
import javax.faces.bean.ManagedBean;
import model.Login;

@ManagedBean
public class LoginBean {
    
    Login login = new Login();
    LoginControler control = new LoginControler(login);
    
    public String logar(){
    return control.logar();
    }
    
    
}
