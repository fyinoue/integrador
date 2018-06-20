package pi.negocios;

import javax.swing.JOptionPane;

public class NegocioException extends Exception {

    public NegocioException(String string) {
        JOptionPane.showMessageDialog(null, string);
    }

    public NegocioException(String string, Throwable thrwbl) {
        JOptionPane.showMessageDialog(null, string+"\n"+thrwbl);
    }

}
