package UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuDificuldadeUI extends JFrame {

    private JPanel contentPane;
    protected JButton btnFacil;
    protected JButton btnMedio;
    protected JButton btnDificil;
    
    private Image img;

    public MenuDificuldadeUI() {
         img = new ImageIcon("resources/menu.jpg").getImage();
		
        setTitle("Menu Jogar");        
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

        btnFacil = new JButton("");
        btnFacil.setIcon(new ImageIcon("resources/Facil.jpg"));
        btnFacil.setBounds(250, 80, 299, 75);
        btnFacil.addActionListener(btnFacilOnClick);
        contentPane.add(btnFacil);

        btnMedio = new JButton("");
        btnMedio.setIcon(new ImageIcon("resources/Medio.jpg"));
        btnMedio.setBounds(250, 80 * 2, 299, 75);
        btnMedio.addActionListener(btnMedioOnClick);
        contentPane.add(btnMedio);

        btnDificil = new JButton("");
        btnDificil.setIcon(new ImageIcon("resources/Dificil.jpg"));
        btnDificil.setBounds(250, 80 * 3, 299, 75);
        btnDificil.addActionListener(btnDificilOnClick);
        contentPane.add(btnDificil);

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true); 
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0, 0, null);
    }
    
    private AbstractAction btnFacilOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnFacil_OnClick(e);
        }
    };

    private AbstractAction btnMedioOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnMedio_OnClick(e);
        }
    };

    private AbstractAction btnDificilOnClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnDificil_OnClick(e);
        }
    };

    protected void btnFacil_OnClick(ActionEvent e) {

    }

    protected void btnMedio_OnClick(ActionEvent e) {

    }

    protected void btnDificil_OnClick(ActionEvent e) {

    }
}
