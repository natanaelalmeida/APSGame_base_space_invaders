package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuJogarUI extends JFrame {

    private JPanel contentPane;
    protected JButton btnUmJogador;
    protected JButton btnDoisJogador;
    protected JButton btnMenuPrincipal;

    public MenuJogarUI() {
        setTitle("Jogar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 299, 244);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnUmJogador = new JButton("Um jogador");
        btnUmJogador.setBounds(10, 41, 263, 41);
        btnUmJogador.addActionListener(btnUmJogadorOnClick);
        contentPane.add(btnUmJogador);

        btnDoisJogador = new JButton("Dois jogador");
        btnDoisJogador.setBounds(10, 93, 263, 41);
        btnDoisJogador.addActionListener(btnDoisJogadorOnClick);
        contentPane.add(btnDoisJogador);

        btnMenuPrincipal = new JButton("Menu principal");
        btnMenuPrincipal.setBounds(10, 145, 263, 41);
        btnMenuPrincipal.addActionListener(btnMenuPrincipalOnClick);
        contentPane.add(btnMenuPrincipal);

        JLabel lblDescricaoJogar = new JLabel("Escolha abaixo com quantos jogador \r\ndeseja jogar...");
        lblDescricaoJogar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblDescricaoJogar.setBounds(10, 11, 284, 30);
        contentPane.add(lblDescricaoJogar);
        
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private AbstractAction btnUmJogadorOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnUmJogador_OnClick(e);
        }
    };

    private AbstractAction btnDoisJogadorOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnDoisJogador_OnClick(e);
        }
    };

    private AbstractAction btnMenuPrincipalOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnMenuPrincipal_OnClick(e);
        }
    };
    
    protected void btnUmJogador_OnClick(ActionEvent e){
        
    }
    
    protected void btnDoisJogador_OnClick(ActionEvent e){
        
    }
    
    protected void btnMenuPrincipal_OnClick(ActionEvent e){
        
    }

}
