package Pivante;

import java.awt.FlowLayout;
import javax.swing.JFrame;


public class MainPivante {
    public static void main(String[] args) {
        JFrame janela = new JFrame();
        TestPanel painel = new TestPanel();
        janela.add(painel);
        
        janela.setSize(640,480);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
