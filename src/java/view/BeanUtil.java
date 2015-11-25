package view;

import controller.UtilController;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BeanUtil {

    UtilController control = new UtilController();


    public UtilController getControl() {
        return control;
    }

    public void setControl(UtilController control) {
        this.control = control;
    }

    public String Datar() {
        return control.Datar();
    }


}
