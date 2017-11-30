
package gui;

import javax.swing.JOptionPane;

/**
 *
 * @author omar
 */
public class Mensaje {

    /**
     *
     */
    public static void miMensaje(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, 
            titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
