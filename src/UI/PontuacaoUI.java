package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PontuacaoUI extends JFrame{
    
    private JPanel contentPane;
    private Image img;	
    
    protected String pontuacaoVencedor;
    protected String nomeVencedor;
    protected String pontuacaoDerrotado;
    protected String nomeDerrotado;
    
    public PontuacaoUI(){
        img = new ImageIcon("resources/tela_ranking2.jpg").getImage();
		
        setTitle("Pontuação");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, img.getWidth(null), img.getHeight(null) + 25);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        contentPane.setPreferredSize(size);
        contentPane.setMinimumSize(size);
        contentPane.setMaximumSize(size);
        contentPane.setSize(size);						

        JLabel lblPontuacaoVitoria = new JLabel("3700");
        lblPontuacaoVitoria.setHorizontalAlignment(SwingConstants.CENTER);
        lblPontuacaoVitoria.setForeground(Color.WHITE);
        lblPontuacaoVitoria.setBackground(Color.WHITE);
        lblPontuacaoVitoria.setFont(new Font("Abduction2002", Font.BOLD, 16));
        lblPontuacaoVitoria.setBounds(118, 111, 174, 33);
        contentPane.add(lblPontuacaoVitoria);

        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {	
        super.paint(g);
        g.drawImage(img,0, 25, this);

        g.setColor(Color.WHITE);

        /*Vencedor*/
        g.setFont(new Font("Abduction2002", Font.BOLD, 16));
        g.drawString(nomeVencedor, 80, 100);

        g.setFont(new Font("Abduction2002", Font.BOLD, 30));
        g.drawString(String.valueOf(pontuacaoVencedor), 80, 205);

        /*Derrotado*/
        g.setFont(new Font("Abduction2002", Font.BOLD, 16));
        g.drawString(String.valueOf(nomeDerrotado), 337, 100);

        g.setFont(new Font("Abduction2002", Font.BOLD, 30));
        g.drawString(pontuacaoDerrotado, 335, 205);
    }	
    
}
