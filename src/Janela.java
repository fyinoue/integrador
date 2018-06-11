
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Janela extends JFrame{
    private JMenuBar barraMenu;
    private JMenu menuMenu;
    private JMenu menuDiego;
    private JMenu menuFelipe;
    private JMenu menuMarcio;
    private JMenu menuMatheus;
    private JMenu menuPivante;
    private JMenuItem menuMenuSair;
    
    private CardLayout leiaute;
    private JPanel conteiner;
    
    private JMenuItem menuFelipe01;
    private TelaFelipe telaFelipe01;
    
    private JMenuItem menuMatheus01;
    private TelaMatheus telaMatheus01;

    private JMenuItem menuPivante01;
    private TelaPivante telaPivante01;
    
    public Janela(){
        
        telaFelipe01 = new TelaFelipe();
        
        telaMatheus01 = new TelaMatheus();
        
        telaPivante01 = new TelaPivante();
        
        leiaute = new CardLayout();
        conteiner = new JPanel();
        
        barraMenu = new JMenuBar();
        menuMenu = new JMenu("Menu");
        menuMenu.setMnemonic('M');
        menuMenuSair = new JMenuItem("Sair");
        menuMenuSair.setMnemonic('r');
        menuDiego = new JMenu("Diego");
        menuFelipe = new JMenu("Felipe");
        menuFelipe01 = new JMenuItem("Tela 01");
        menuMarcio = new JMenu("Marcio");
        menuMatheus = new JMenu("Matheus");
        menuMatheus01 = new JMenuItem("Tela Login");
        menuPivante = new JMenu("Pivante");
        menuPivante01 = new JMenuItem("Tela Pivante");
        
        menuMenuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        menuFelipe01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leiaute.show(conteiner, "FELIPE1");
                
            }
        });
        
        menuMatheus01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leiaute.show(conteiner, "MATHEUS1");
            }
        });
        
        menuPivante01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leiaute.show(conteiner, "PIVANTE1");
            }
        });
        
        menuMenu.add(menuMenuSair);
        menuFelipe.add(menuFelipe01);
        menuMatheus.add(menuMatheus01);
        menuPivante.add(menuPivante01);
        barraMenu.add(menuMenu);
        barraMenu.add(menuDiego);
        barraMenu.add(menuFelipe);
        barraMenu.add(menuMarcio);
        barraMenu.add(menuMatheus);
        barraMenu.add(menuPivante);
        
        conteiner.setLayout(leiaute);
        
        JPanel painelInicial = new JPanel();
        
        conteiner.add(painelInicial, "INICIAL");
        conteiner.add(telaFelipe01, "FELIPE1");
        conteiner.add(telaMatheus01, "MATHEUS1");
        conteiner.add(telaPivante01, "PIVANTE1");
        
        setJMenuBar(barraMenu);
        this.add(conteiner, BorderLayout.CENTER);
        
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
}
