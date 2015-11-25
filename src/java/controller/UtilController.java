package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilController {

    DateFormat dataformato = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = Calendar.getInstance();

    Date today = Calendar.getInstance().getTime();
    private String dataString = dataformato.format(today);

    public UtilController() {
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String Datar() {
        return dataString;
    }

}
