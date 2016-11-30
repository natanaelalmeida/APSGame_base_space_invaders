package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
            
    private Image img;
    
    public CriarContaUI(){
        img = new ImageIcon("resources/cadastro.jpg").getImage();
		
        setTitle("Criar Conta");        
        setBounds(100, 100, img.getWidth(null), img.getHeight(null));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        contentPane.setPreferredSize(size);
        contentPane.setMinimumSize(size);
        contentPane.setMaximumSize(size);
        contentPane.setSize(size);			

        txtEmail = new JTextField();
        txtEmail.setBounds(25, 130, 390, 26);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(25, 185, 390, 26);
        contentPane.add(txtUsuario);
        txtEmail.setColumns(10);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(25, 240, 390, 26);
        contentPane.add(txtSenha);
        txtSenha.setColumns(10);

        btnSalvar = new JButton("");
        btnSalvar.setIcon(new ImageIcon("resources/salvar.jpg"));
        btnSalvar.setBounds(295, 320, 116, 56);
        btnSalvar.addActionListener(btnSalvarOnClick);
        contentPane.add(btnSalvar);

        btnLimpar = new JButton("");
        btnLimpar.setIcon(new ImageIcon("resources/limpar.jpg"));
        btnLimpar.setBounds(162, 320, 116, 56);
        btnLimpar.addActionListener(btnLimparOnClick);
        contentPane.add(btnLimpar);

        btnCancelar = new JButton("");
        btnCancelar.setIcon(new ImageIcon("resources/cancelar.jpg"));
        btnCancelar.setBounds(30, 320, 116, 56);
        btnCancelar.addActionListener(btnCancelarOnClick);
        contentPane.add(btnCancelar);

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {	
        super.paint(g);
        g.drawImage(img,0, 0, this);		
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
