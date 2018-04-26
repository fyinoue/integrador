
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaFelipe extends JPanel {
    public TelaFelipe() {
        JButton botao = new JButton("Botao");
        
        this.add(botao);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
    }
}
