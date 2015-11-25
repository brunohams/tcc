package util;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

public class UploadUtils {

    private static final String PATHINFO = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")
            + "\\resources\\imgsPizza\\";

    public static void upload(Part file1) throws IOException {
        file1.write(PATHINFO + getFilename(file1));
    }

    public static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
