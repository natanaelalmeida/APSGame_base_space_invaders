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
import javax.swing.border.EmptyBorder;

public class MenuPrincipalUI extends JFrame {

    private JPanel contentPane;

    protected JButton btnJogar;
    protected JButton btnRanking;
    protected JButton btnCriarConta;
    protected JButton btnSair;
    
    private Image img;

    public MenuPrincipalUI() {
        img = new ImageIcon("resources/menu.jpg").getImage();
		
        setTitle("Menu Principal");
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

        btnJogar = new JButton("");
        btnJogar.setIcon(new ImageIcon("resources/jogar.jpg"));
        btnJogar.setBounds(250, 80, 299, 75);
        btnJogar.addActionListener(btnJogarOnClick);
        contentPane.add(btnJogar);

        btnRanking = new JButton("");
        btnRanking.setIcon(new ImageIcon("resources/Ranking.jpg"));
        btnRanking.setBounds(250, 80 * 2, 299, 75);
        btnRanking.addActionListener(btnRankingOnClick);
        contentPane.add(btnRanking);

        btnCriarConta = new JButton("");
        btnCriarConta.setIcon(new ImageIcon("resources/CriarConta.jpg"));
        btnCriarConta.setBounds(250, 80 * 3, 299, 75);
        btnCriarConta.addActionListener(btnCriarContaOnClick);
        contentPane.add(btnCriarConta);

        btnSair = new JButton("");
        btnSair.setIcon(new ImageIcon("resources/Sair.jpg"));
        btnSair.setBounds(250, 80 * 4, 299, 75);
        btnSair.addActionListener(btnSairOnClick);
        contentPane.add(btnSair);

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true); 
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0, 0, null);
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
