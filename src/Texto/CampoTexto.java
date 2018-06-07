
package Texto;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CampoTexto {
    public static void main(String[] args) {
        JLabel label = new JLabel("Texto: ");
        
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        
        JTextField campoTexto = new JTextField(20);
        campoTexto.setEditable(true);   
        campoTexto.setToolTipText("Digite seu texto aqui!");
        
        JPanel conteiner = new JPanel();
        conteiner.setLayout(layout);        
        conteiner.add(label);
        conteiner.add(campoTexto);

        
        JFrame janela = new JFrame();
        janela.add(conteiner);
        janela.setSize(350, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }
}
