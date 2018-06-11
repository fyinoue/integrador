
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaFelipe extends JPanel {
    
    private JLabel labelLocal;
    private JTextField campoLocal;
    
    private JLabel labelData;
    private JFormattedTextField campoData;
    
    private JLabel labelHorario;
    private JTextField campoHorario;
    
    private JLabel labelTipo;
    private JComboBox campoTipo;
    
    private JLabel labelConvidados;
    private JTable tabelaConvidados;
    private JScrollPane campoConvidados;
    
    private JLabel labelAssunto;
    private JTextArea campoAssunto;
    private JScrollPane campoAssuntoRolagem;
    
    private JLabel labelApontamentos;
    private JTextArea campoApontamentos;
    private JScrollPane campoApontamentosRolagem;
    
    private JLabel labelDecisoes;
    private JTextArea campoDecisoes;
    private JScrollPane campoDecisoesRolagem;
    
    private JLabel labelClassificacao;
    private JComboBox campoClassificacao;
    
    private JLabel labelEncaminhamentos;
    private JTextField campoEncaminhamentos;
    
    private JButton botaoCancelar;
    private JButton botaoEnviar;
    
    private JPanel painelDadosAta;
    private JPanel painelDadosAtaLabels;
    private JPanel painelDadosAtaCampos;
    private JPanel painelConvidados;
    private JPanel painelAssunto;
    private JPanel painelApontamentos;
    private JPanel painelDecisoes;
    private JPanel painelBotoes;
    
    public TelaFelipe() {
        labelLocal = new JLabel("Local: ");
        campoLocal = new JTextField(10);
        
        labelData = new JLabel("Data: ");
        campoData = new JFormattedTextField(createFormatter("##/##/####"));
        campoData.setColumns(10);
        
        labelHorario = new JLabel("Horário: ");
        campoHorario = new JFormattedTextField(createFormatter("##:##"));
        campoHorario.setColumns(10);
        
        labelTipo = new JLabel("Tipo: ");
        String[] tipos = {"Reunião", "Assembléia", "Convenção"};
        campoTipo = new JComboBox(tipos);
        
        labelConvidados = new JLabel("Convidados: ");
        Object[][] dadosConvidados = {};
        String[] colunasConvidados = {"Nome","Presente?"};
        tabelaConvidados = new JTable(dadosConvidados, colunasConvidados);
        tabelaConvidados.setPreferredScrollableViewportSize(new Dimension(440, 70));
        campoConvidados = new JScrollPane(tabelaConvidados);
        
        labelAssunto = new JLabel("Assuntos: ");
        campoAssunto = new JTextArea(10,40);
        campoAssunto.setLineWrap(true);
        campoAssunto.setWrapStyleWord(true);
        campoAssuntoRolagem = new JScrollPane();
        campoAssuntoRolagem.setViewportView(campoAssunto);
        
        labelApontamentos = new JLabel("Apontamentos: ");
        campoApontamentos = new JTextArea(10,40);
        campoApontamentos.setLineWrap(true);
        campoApontamentos.setWrapStyleWord(true);
        campoApontamentosRolagem = new JScrollPane();
        campoApontamentosRolagem.setViewportView(campoApontamentos);
        
        labelDecisoes = new JLabel("Decisões: ");
        campoDecisoes = new JTextArea(10,40);
        campoDecisoes.setLineWrap(true);
        campoDecisoes.setWrapStyleWord(true);
        campoDecisoesRolagem = new JScrollPane();
        campoDecisoesRolagem.setViewportView(campoDecisoes);
        
        labelClassificacao = new JLabel("Classificação: ");
        String[] classificacao = {"Pública", "Privada"};
        campoClassificacao = new JComboBox(classificacao);
        
        labelEncaminhamentos = new JLabel("Encaminhamentos: ");
        campoEncaminhamentos = new JTextField(10);
        
        botaoCancelar = new JButton("Cancelar");
        botaoEnviar = new JButton("Enviar");
        
        painelDadosAta = new JPanel();
        painelDadosAta.setBorder(BorderFactory.createTitledBorder("Dados da Ata"));
        
        painelDadosAtaLabels = new JPanel();
        painelDadosAtaLabels.setLayout(new GridLayout(6,1));
        painelDadosAtaLabels.add(labelLocal);
        painelDadosAtaLabels.add(labelData);
        painelDadosAtaLabels.add(labelHorario);
        painelDadosAtaLabels.add(labelTipo);
        painelDadosAtaLabels.add(labelClassificacao);
        painelDadosAtaLabels.add(labelEncaminhamentos);
        
        painelDadosAtaCampos = new JPanel();
        painelDadosAtaCampos.setLayout(new GridLayout(6,1));
        painelDadosAtaCampos.add(campoLocal);
        painelDadosAtaCampos.add(campoData);
        painelDadosAtaCampos.add(campoHorario);
        painelDadosAtaCampos.add(campoTipo);
        painelDadosAtaCampos.add(campoClassificacao);
        painelDadosAtaCampos.add(campoEncaminhamentos);
        
        painelDadosAta.setLayout(new BorderLayout());
        painelDadosAta.add(painelDadosAtaLabels, BorderLayout.WEST);
        painelDadosAta.add(painelDadosAtaCampos, BorderLayout.CENTER);
        
        painelConvidados = new JPanel();
        painelConvidados.setBorder(BorderFactory.createTitledBorder("Convidados"));
        painelConvidados.add(campoConvidados);
        
        painelAssunto = new JPanel();
        painelAssunto.setBorder(BorderFactory.createTitledBorder("Assunto"));
        painelAssunto.add(campoAssuntoRolagem);
        
        painelApontamentos = new JPanel();
        painelApontamentos.setBorder(BorderFactory.createTitledBorder("Apontamentos"));
        painelApontamentos.add(campoApontamentosRolagem);
        
        painelDecisoes = new JPanel();
        painelDecisoes.setBorder(BorderFactory.createTitledBorder("Decisões"));
        painelDecisoes.add(campoDecisoesRolagem);
        
        painelBotoes = new JPanel();
        painelBotoes.add(botaoCancelar);
        painelBotoes.add(botaoEnviar);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.add(painelDadosAta);
        painelPrincipal.add(painelConvidados);
        painelPrincipal.add(painelAssunto);
        painelPrincipal.add(painelApontamentos);
        painelPrincipal.add(painelDecisoes);
        painelPrincipal.add(painelBotoes);
        
        JScrollPane painelPrincipalRolagem = new JScrollPane();
        painelPrincipalRolagem.setViewportView(painelPrincipal);
        painelPrincipalRolagem.setSize(640,480);
        
        BorderLayout layoutPrincipal = new BorderLayout();
        this.setLayout(layoutPrincipal);
        this.add(painelPrincipalRolagem);
    }
    
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (ParseException ex) {
            System.err.println("Formatter is bad: " + ex.getMessage());
            System.exit(-1);
        } finally {
            
        }
        return formatter;
    }
}