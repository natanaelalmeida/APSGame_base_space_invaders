package UI;

import abstracts.Entidade;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameUI extends Canvas{

    protected int pressCount = 1;
    protected JLabel lblPontos;
    protected JFrame frmGame;
    
    public GameUI(){
        frmGame = new JFrame("Alien Attack");        
        JPanel pnl = (JPanel) frmGame.getContentPane();       
        
        pnl.setPreferredSize(new Dimension(800, 600));
        pnl.setLayout(null);
        
        setBounds(0, 0, 800, 600);
        pnl.add(this);
        
        setIgnoreRepaint(false);               
        
        //frm.setLocationRelativeTo(null);
        frmGame.pack();
        frmGame.setResizable(false);
        frmGame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmGame.setVisible(true);
        
        addKeyListener(KeyInput());        
        
        requestFocus();                
        
        createBufferStrategy(2);
    }      
    
    protected void startEntidade(){
        
    }
    
    protected void startGame(){
    
    }
    
    public void updateLogic(){
        
    }     
    
    public void initgameLoop(){
        
    }
    
    public void removerEntidade(Entidade entidade){
        
    }
    
    public void morreu(){
        
    }
    
    public void venceu(){
        
    }
    
    public void alienteMorreu(){
        
    }
    
    public void pontos(int pontos){
        
    }
    
    public void KeyPressed(KeyEvent e){
        
    }
    
    public void KeyReleased(KeyEvent e) {
        
    }
    
    public void KeyTyped(KeyEvent e) {
        
    }
    
    private KeyAdapter KeyInput(){
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyReleased(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                KeyTyped(e);
            }                                
        };
    }
}
