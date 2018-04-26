
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JPanel painel = new JPanel();
        painel.setBackground(Color.CYAN);
        
        JFrame janela = new JFrame();
        janela.add(painel);
        janela.setSize(640,480);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
