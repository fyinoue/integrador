
package Texto;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AreaTexto {
    public static void main(String[] args) {
        JLabel label = new JLabel("Área Texto Modificada: ");
        
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        
        JTextArea areaTexto = new JTextArea(3,20);
        areaTexto.setEditable(true);   
        areaTexto.setToolTipText("Digite seu texto aqui!");
        
        JPanel conteiner = new JPanel();
        conteiner.setLayout(layout);        
        conteiner.add(label);
        conteiner.add(areaTexto);

        
        JFrame janela = new JFrame();
        janela.add(conteiner);
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }
}
