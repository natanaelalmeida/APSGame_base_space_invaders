package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CriarContaUI extends JFrame{
    
    private JPanel contentPane;
    protected JTextField txtEmail;
    protected JTextField txtUsuario;
    protected JPasswordField txtSenha;
    
    protected JButton btnSalvar;
    protected JButton btnLimpar;
    protected JButton btnCancelar;
            
    
    public CriarContaUI(){
        setTitle("Criar Conta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 317, 323);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos abaixo para realizar o cadastro.");
        lblPreenchaOsCampos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblPreenchaOsCampos.setBounds(10, 11, 284, 30);
        contentPane.add(lblPreenchaOsCampos);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
        lblEmail.setBounds(10, 41, 46, 14);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(10, 59, 284, 30);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        txtUsuario = new JTextField(10);
        txtUsuario.setColumns(10);
        txtUsuario.setBounds(10, 125, 284, 30);
        contentPane.add(txtUsuario);

        JLabel lblUsurio = new JLabel("Usu\u00E1rio");
        lblUsurio.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsurio.setBounds(10, 100, 46, 14);
        contentPane.add(lblUsurio);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        lblSenha.setBounds(10, 166, 46, 14);
        contentPane.add(lblSenha);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(208, 232, 89, 41);
        btnSalvar.addActionListener(btnSalvarOnClick);
        contentPane.add(btnSalvar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(109, 232, 89, 41);
        btnLimpar.addActionListener(btnLimparOnClick);
        contentPane.add(btnLimpar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(10, 232, 89, 41);
        btnCancelar.addActionListener(btnCancelarOnClick);
        contentPane.add(btnCancelar);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(10, 191, 284, 30);
        contentPane.add(txtSenha);
        
        setLocationRelativeTo(this);
        setResizable(false);
    }
    
    private AbstractAction btnSalvarOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnSalvar_OnClick(e);
        }
    };
    
    private AbstractAction btnLimparOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
           btnLimpar_OnClick(e);
        }
    };
    
    private AbstractAction btnCancelarOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnCancelar_OnClick(e);
        }
    };
    
    protected void btnSalvar_OnClick(ActionEvent e){
        
    }
    
    protected void btnLimpar_OnClick(ActionEvent e){
        
    }
    
    protected void btnCancelar_OnClick(ActionEvent e){
        
    }
}
