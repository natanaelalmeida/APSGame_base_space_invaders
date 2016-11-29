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

public class MenuJogarUI extends JFrame {

    private JPanel contentPane;
    protected JButton btnUmJogador;
    protected JButton btnDoisJogador;
    protected JButton btnMenuPrincipal;
    
    private Image img;

    public MenuJogarUI() {
        img = new ImageIcon("resources/menu.jpg").getImage();
		
        setTitle("Menu Jogar");
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

        btnUmJogador = new JButton("");
        btnUmJogador.setIcon(new ImageIcon("resources/umJogador.jpg"));
        btnUmJogador.setBounds(250, 80, 299, 75);
        btnUmJogador.addActionListener(btnUmJogadorOnClick);
        contentPane.add(btnUmJogador);

        btnDoisJogador = new JButton("");
        btnDoisJogador.setIcon(new ImageIcon("resources/DoisJogador.jpg"));
        btnDoisJogador.setBounds(250, 80 * 2, 299, 75);
        btnDoisJogador.addActionListener(btnDoisJogadorOnClick);
        contentPane.add(btnDoisJogador);

        btnMenuPrincipal = new JButton("");
        btnMenuPrincipal.setIcon(new ImageIcon("resources/MenuPrincipal.jpg"));
        btnMenuPrincipal.setBounds(250, 80 * 3, 299, 75);
        btnMenuPrincipal.addActionListener(btnMenuPrincipalOnClick);
        contentPane.add(btnMenuPrincipal);

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true); 
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0, 0, null);
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
