import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TelaPivante extends JPanel{
    private JLabel textoLogin;
    private JLabel textoSenha;
    private JLabel textoTitulo;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public TelaPivante() {
        textoLogin = new JLabel("Login:   ");
        textoSenha = new JLabel("Senha: ");
        textoTitulo = new JLabel("Entrar no Sistema");

        textoTitulo.setFont(new java.awt.Font("Tahoma", 1, 14));

        campoLogin = new JTextField(20);
        campoSenha = new JPasswordField(20);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
            }
        });

        JPanel painelLogin = new JPanel();
        painelLogin.add(textoLogin);
        painelLogin.add(campoLogin);

        JPanel painelSenha = new JPanel();
        painelSenha.add(textoSenha);
        painelSenha.add(campoSenha);

        JPanel painelTitulo = new JPanel();
        painelTitulo.add(textoTitulo);

        JPanel painelBotao = new JPanel();
        painelBotao.add(botaoEntrar);

        GridLayout layout = new GridLayout(10, 1);

        JPanel painelEspaço = new JPanel();
        JPanel painelEspaço2 = new JPanel();

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(layout);
        painelCentral.add(painelEspaço2);
        painelCentral.add(painelEspaço);
        painelCentral.add(painelTitulo);
        painelCentral.add(painelLogin);
        painelCentral.add(painelSenha);
        painelCentral.add(painelBotao);
        
        this.setBorder(BorderFactory.createLineBorder(Color.PINK));
        BorderLayout layout2 = new BorderLayout();
        this.setLayout(layout2);
        this.add(painelCentral);
        
        
        
        
    }
    
}