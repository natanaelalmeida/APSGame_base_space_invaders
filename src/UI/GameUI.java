package UI;

import abstracts.Entidade;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameUI extends Canvas{

    protected int pressCount = 1;
    
    public GameUI(){
        JFrame frm = new JFrame("Alien Attack");        
        JPanel pnl = (JPanel) frm.getContentPane();       
        
        pnl.setPreferredSize(new Dimension(800, 600));
        pnl.setLayout(null);
        
        setBounds(0, 0, 800, 600);
        pnl.add(this);
        
        setIgnoreRepaint(false);               
        
        //frm.setLocationRelativeTo(null);
        frm.pack();
        frm.setResizable(false);
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frm.setVisible(true);
        
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
