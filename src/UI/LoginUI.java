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

public class LoginUI extends JFrame{
    
    private JPanel contentPane;
    protected JLabel lblPreenchaOsCampos;
    protected JTextField txtUsuario;
    protected JPasswordField txtSenha;
    
    protected JButton btnEntrar;
    
    public LoginUI(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 321, 268);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPreenchaOsCampos = new JLabel("Preencha os campos abaixo para acessar o jogo.");
        lblPreenchaOsCampos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblPreenchaOsCampos.setBounds(10, 11, 284, 30);
        contentPane.add(lblPreenchaOsCampos);

        txtUsuario = new JTextField(10);
        txtUsuario.setColumns(10);
        txtUsuario.setBounds(10, 69, 284, 30);
        contentPane.add(txtUsuario);

        JLabel lblUsurio = new JLabel("Usuário");
        lblUsurio.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsurio.setBounds(10, 44, 46, 14);
        contentPane.add(lblUsurio);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 12));
        lblSenha.setBounds(10, 110, 46, 14);
        contentPane.add(lblSenha);

        btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(btnEntrarOnClick);
        btnEntrar.setBounds(10, 176, 284, 41);
        contentPane.add(btnEntrar);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(10, 135, 284, 30);
        contentPane.add(txtSenha);
        
        setLocationRelativeTo(this);
        setResizable(false);
    }
    
    private AbstractAction btnEntrarOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnEntrar_OnClick(e);
        }
    };
    
    protected void btnEntrar_OnClick(ActionEvent e){
        
    }
}
