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

public class PontuacaoUI extends JFrame{
    
    private JPanel contentPane;
    private Image img;	
    
    protected String pontuacaoVencedor;
    protected String nomeVencedor;
    protected String pontuacaoDerrotado;
    protected String nomeDerrotado;        
        
    private PontuacaoDao pontuacaDao = new PontuacaoDao();
    
    public PontuacaoUI(List<Pontuacao> lstPontuacao){
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
        
        
        Pontuacao jogador1 = lstPontuacao.get(0);
        Pontuacao jogador2 = lstPontuacao.get(1);
        
        if(jogador1.getPontuacao() > jogador2.getPontuacao()){
            nomeVencedor = jogador1.getIdJogador().getUsuario();
            pontuacaoVencedor = String.valueOf(jogador1.getPontuacao());
            
            nomeDerrotado = jogador2.getIdJogador().getUsuario();
            pontuacaoDerrotado = String.valueOf(jogador2.getPontuacao());
        }
        else {
            nomeVencedor = jogador2.getIdJogador().getUsuario();
            pontuacaoVencedor = String.valueOf(jogador2.getPontuacao());
            
            nomeDerrotado = jogador1.getIdJogador().getUsuario();
            pontuacaoDerrotado = String.valueOf(jogador1.getPontuacao());
        }
        
        Pontuacao j1 = pontuacaDao.SelecionarPorJogador(jogador1.getIdJogador());
        Pontuacao j2 = pontuacaDao.SelecionarPorJogador(jogador2.getIdJogador());
        
        if(j1 != null){
            j1.setPontuacao(jogador1.getPontuacao());
        }
        else {
            j1 = jogador1;
        }
        
        if(j2 != null){
            j2.setPontuacao(jogador2.getPontuacao());
        }
        else {
            j2 = jogador2;
        }
        
        pontuacaDao.Insert(j1);
        pontuacaDao.Insert(j2);        
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
