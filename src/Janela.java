
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
    private TelaFelipe telaF01;
    
    private JMenuItem menuMatheus01;
    private TelaMatheus telaMDS01;

    public Janela(){
        
        telaF01 = new TelaFelipe();
        
        telaMDS01 = new TelaMatheus();
        
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
        
        menuMenuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        menuFelipe01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leiaute.show(conteiner, "F01");
                
            }
        });
        
        menuMatheus01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leiaute.show(conteiner, "MDS");
            }
        });
        
        menuMenu.add(menuMenuSair);
        menuFelipe.add(menuFelipe01);
        menuMatheus.add(menuMatheus01);
        barraMenu.add(menuMenu);
        barraMenu.add(menuDiego);
        barraMenu.add(menuFelipe);
        barraMenu.add(menuMarcio);
        barraMenu.add(menuMatheus);
        barraMenu.add(menuPivante);
        
        conteiner.setLayout(leiaute);
        
        JPanel painelInicial = new JPanel();
        painelInicial.setBorder(BorderFactory.createLineBorder(Color.yellow));
        
        conteiner.add(painelInicial, "INICIAL");
        conteiner.add(telaF01, "F01");
        conteiner.add(telaMDS01, "MDS");
        
        
        setJMenuBar(barraMenu);
        

        
        add(conteiner);
        
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
}
