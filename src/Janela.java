


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Janela extends JFrame{
    private JMenuBar barraMenu;
    JMenu menuArquivo;
    JMenu menuAjuda;
    JMenuItem menuArquivoSair;
    JMenuItem menuAjudaSobre;

    
    public Janela(){
        barraMenu = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic('A');
        menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic('j');
        menuArquivoSair = new JMenuItem("Sair");
        menuArquivoSair.setMnemonic('r');
        
        menuArquivoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        JMenuItem menuAjudaSobre = new JMenuItem("Ajuda Sobre");
        menuAjudaSobre.setMnemonic('S');
        menuAjudaSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               JOptionPane.showMessageDialog(null, "Aplicação 1.0");
            }
        });
        
        menuArquivo.add(menuArquivoSair);
        menuAjuda.add(menuAjudaSobre);
        
        barraMenu.add(menuArquivo);
        barraMenu.add(menuAjuda);
        
        setJMenuBar(barraMenu);
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
}
