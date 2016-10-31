package view;

import UI.GameUI;
import abstracts.Entidade;
import controller.GameController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import model.EntidadeBase;
import model.GameModel;

public class GameView extends GameUI{
    private GameController gameController;
    private GameModel gm;
    private EntidadeBase eb;
    private ArrayList<Entidade> lstEntidade = new ArrayList<Entidade>();
    private ArrayList<Entidade> lstEntidadeRemovidas = new ArrayList<Entidade>();      
        
    public GameView(){  
        super();
        
        gm = new GameModel();        
        gm.setGameExec(true);
        gm.setMovSpeed(500);
        gm.setUltTiro(0);
        gm.setIntervaloDisparo(500);
        gm.setQtdAlien(10); 
        
        gm.setMessage("");
        gm.setLeftPressed(false);
        gm.setRightPressed(false);        
        gm.setEspraKeyPress(true);                   
        gm.setLoop(false);
        gm.setTiroPressionado(false);
        
        gameController = new GameController(this, gm, lstEntidade, lstEntidadeRemovidas);
                
        createBufferStrategy(2);
        gm.setBfStrategy(getBufferStrategy());
        startEntidade();
    }

    @Override
    protected void startGame() {
        lstEntidade.clear();
        startEntidade();
              
        gm.setLeftPressed(false);
        gm.setRightPressed(false);
        gm.setTiroPressionado(false);
    }        
    
    @Override
    protected void startEntidade() {
        eb = new EntidadeBase();
        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\ship.gif");
        eb.setX(370);
        eb.setY(550);
        gameController.iniciaNave(eb);
        
        eb = new EntidadeBase();
        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\alien.gif");
        eb.setX(100);
        eb.setY(50);
        gameController.iniciaAlien(eb);        
    }    

    @Override
    public void updateLogic() {
        gameController.atualizaLogicLoop();
    }        

    @Override
    public void initgameLoop() {
        gameController.InitGameLoop();
    }     

    @Override
    public void morreu() {
        gm.setMessage("Se fudeu");
        gm.setEspraKeyPress(true);
    }      

    @Override
    public void venceu() {
        gm.setMessage("Venceu! Menos na vida");
        gm.setEspraKeyPress(true);
    }        

    @Override
    public void KeyPressed(KeyEvent e) {
        if(gm.isEspraKeyPress()){
            return;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            gm.setLeftPressed(true);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            gm.setRightPressed(true);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gm.setTiroPressionado(true);
        }        
    }        

    @Override
    public void KeyReleased(KeyEvent e) {
         if(gm.isEspraKeyPress()){
            return;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            gm.setLeftPressed(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            gm.setRightPressed(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gm.setTiroPressionado(false);
        } 
    }        

    @Override
    public void KeyTyped(KeyEvent e) {
        if(gm.isEspraKeyPress()){
            if(pressCount == 1){
                gm.setEspraKeyPress(false);
                startGame();
                pressCount = 0;
            }
            else {
                pressCount++;
            }
        }
        
        if (e.getKeyChar() == 27) {
            System.exit(0);
        }
    }        
    
    public static void main(String[] args) {
        GameView game = new GameView();
        game.initgameLoop();
    }  
}