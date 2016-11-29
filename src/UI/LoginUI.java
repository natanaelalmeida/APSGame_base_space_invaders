package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
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
    private Image img;	
    
    public LoginUI(){
        img = new ImageIcon("resources/login.jpg").getImage();
		
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        txtUsuario = new JTextField();
        txtUsuario.setBounds(25, 110, 390, 26);
        contentPane.add(txtUsuario);
        txtUsuario.setColumns(10);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(25, 170, 390, 26);
        contentPane.add(txtSenha);
        txtSenha.setColumns(10);

        btnEntrar = new JButton("");
        btnEntrar.setIcon(new ImageIcon("resources/entrar.jpg"));
        btnEntrar.setBounds(160, 230, 116, 56);
        btnEntrar.addActionListener(btnEntrarOnClick);
        contentPane.add(btnEntrar);        

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {	
        super.paint(g);
        g.drawImage(img,0, 0, null);
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
