package UI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipalUI extends JFrame {

    private JPanel contentPane;

    protected JButton btnJogar;
    protected JButton btnRanking;
    protected JButton btnCriarConta;
    protected JButton btnSair;

    public MenuPrincipalUI() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 299, 259);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnJogar = new JButton("Jogar");
        btnJogar.setBounds(10, 11, 263, 41);
        btnJogar.addActionListener(btnJogarOnClick);
        contentPane.add(btnJogar);

        btnRanking = new JButton("Ranking");
        btnRanking.setBounds(10, 63, 263, 41);
        btnRanking.addActionListener(btnRankingOnClick);
        contentPane.add(btnRanking);

        btnCriarConta = new JButton("Criar Conta");
        btnCriarConta.setBounds(10, 115, 263, 41);
        btnCriarConta.addActionListener(btnCriarContaOnClick);
        contentPane.add(btnCriarConta);

        btnSair = new JButton("Sair");
        btnSair.setBounds(10, 167, 263, 41);
        btnSair.addActionListener(btnSairOnClick);
        contentPane.add(btnSair);               
        
        setLocationRelativeTo(null);
        setResizable(false);        
    }

    private AbstractAction btnJogarOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
           btnJogar_OnClick(e);
        }
    };

    private AbstractAction btnRankingOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnRanking_OnClick(e);
        }
    };

    private AbstractAction btnCriarContaOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnCriarConta_OnClick(e);
        }
    };

    private AbstractAction btnSairOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnSair_OnClick(e);
        }
    };

    protected void btnJogar_OnClick(ActionEvent e) {

    }

    protected void btnRanking_OnClick(ActionEvent e) {

    }

    protected void btnCriarConta_OnClick(ActionEvent e) {

    }

    protected void btnSair_OnClick(ActionEvent e) {

    }

}
