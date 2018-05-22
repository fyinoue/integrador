
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaFelipe extends JPanel {
    public TelaFelipe() {
        JButton botao = new JButton("Botao");
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        this.add(botao);
        this.setBackground(Color.WHITE);
        
    }
}
