
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TelaPivante extends JPanel{
    private JLabel txTipo;
    private JLabel txModelo;
    private JComboBox Tipo;
    private JComboBox Modelo;
    private JButton Voltar;
    
    public TelaPivante(){
        String[] tipos = {"Confidencial", "Restrito", "Livre"};
        String[] modelos = {"Ato", "Ata"};
        
        txTipo = new JLabel("Tipo: ");
        txModelo = new JLabel("Modelo: ");
        
        Tipo = new JComboBox(tipos);
        Modelo = new JComboBox(modelos);
        
        Voltar = new JButton("Voltar");
        
        Tipo.setSelectedIndex(Tipo.getItemCount()-1);
        
        add(Tipo);
        add(Modelo);
        
        JPanel painelCombo1 = new JPanel();
        painelCombo1.add(txTipo);
        painelCombo1.add(Tipo);
        
        JPanel painelCombo2 = new JPanel();
        painelCombo2.add(txModelo);
        painelCombo2.add(Modelo);
        
        JPanel painelBotao = new JPanel();
        painelBotao.add(Voltar);
        
        GridLayout layout = new GridLayout(10, 1);
        
        JPanel painelEspaço = new JPanel();
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(layout);
        painelCentral.add(painelEspaço);
        painelCentral.add(painelCombo1);
        painelCentral.add(painelCombo2);
        painelCentral.add(painelBotao);
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BorderLayout layout2 = new BorderLayout();
        this.setLayout(layout2);
        this.add(painelCentral);
        
    }
    
}