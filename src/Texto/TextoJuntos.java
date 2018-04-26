
package Texto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextoJuntos {
    public static void main(String[] args) {
        JLabel label1 = new JLabel("Texto: ");
        JLabel label2 = new JLabel("Texto: ");
        
        JTextField campoTexto = new JTextField(20);
        campoTexto.setEditable(true);   
        campoTexto.setToolTipText("Digite seu texto aqui!");
        
        JTextArea areaTexto = new JTextArea(3,20);
        areaTexto.setEditable(true);   
        areaTexto.setToolTipText("Digite seu texto aqui!");
        
        FlowLayout layout1 = new FlowLayout(FlowLayout.LEFT);
        FlowLayout layout2 = new FlowLayout(FlowLayout.LEFT);
        
        JPanel conteiner1 = new JPanel();
        conteiner1.setLayout(layout1);
        conteiner1.add(label1);
        conteiner1.add(campoTexto);
        
        JPanel conteiner2 = new JPanel();
        conteiner2.setLayout(layout2);
        conteiner2.add(label2);
        conteiner2.add(areaTexto);

        
        JFrame janela = new JFrame();
        janela.add(conteiner1, BorderLayout.NORTH);
        janela.add(conteiner2, BorderLayout.CENTER);
        janela.setSize(350, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }
}
