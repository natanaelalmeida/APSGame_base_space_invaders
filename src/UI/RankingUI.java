package UI;

import DAO.PontuacaoDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.Pontuacao;

public class RankingUI extends JFrame{
    
    private JPanel contentPane;
    private Image img;
    
    
    private PontuacaoDao pontuacaDao = new PontuacaoDao();
    private List<Pontuacao> lst = pontuacaDao.ListaTodas();
    
    public RankingUI(){
        img = new ImageIcon("resources/tela_rankin.jpg").getImage();
		
        setTitle("Ranking");        
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
    
    public void paint(Graphics g) {	
        super.paint(g);                
        
        g.drawImage(img,0, 25, this);

        g.setColor(Color.WHITE);

        int i = 1;
        for(Pontuacao pontuacao : lst){
            /*Vencedor*/
            g.setFont(new Font("Abduction2002", Font.BOLD, 20));            

            g.drawString(pontuacao.getIdJogador().getUsuario(), 80, 100 * i);            
            g.drawString(String.valueOf( pontuacao.getPontuacao()), 335, 100 * i);
            i++;
        }                
    }	
}
