package view;

import Enums.Dificuldade;
import UI.GameUI;
import abstracts.Entidade;
import controller.GameController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import model.EntidadeBase;
import model.Game;
import model.Jogador;

public class GameView extends GameUI implements Runnable{

    private final GameController gameController;
    private Game gm;
    private EntidadeBase eb;
    private final ArrayList<Entidade> lstEntidade = new ArrayList<>();
    private final ArrayList<Entidade> lstEntidadeRemovidas = new ArrayList<>();    
    
    private Jogador jogador;
    private HashMap<Integer, Jogador> hashJogador = new HashMap<>();
        
    public GameView(Dificuldade dificuldade, Jogador jogador){  
        super();        
        
        gameController = new GameController(this, lstEntidade, lstEntidadeRemovidas);                       
        gm = gameController.BaseGame(dificuldade, getBufferStrategy());        
        startEntidade();
    }
    
      public GameView(Dificuldade dificuldade, HashMap<Integer, Jogador> hashjogador){  
        super();        
        this.hashJogador = hashjogador;
        gameController = new GameController(this, lstEntidade, lstEntidadeRemovidas);                       
        gm = gameController.BaseGame(dificuldade, getBufferStrategy());        
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
       gameController.jogadorPerdeu();
    }      

    @Override
    public void venceu() {
        gm.setMessage("Venceu! Menos na vida");
        gm.setEspraKeyPress(true);
    }        

    @Override
    public void alienteMorreu() {
       gameController.alienMorreu();
    }   
    
    @Override
    public void removerEntidade(Entidade entidade) {
        gameController.removerEntidade(entidade);
    }       

    @Override
    public void pontos(int pontos) {
        lblPontos.setText("PONTUAÇÃO: " + pontos);
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
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            gm.setGameExec(false);
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
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            gm.setGameExec(true);
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
    
    @Override
    public void run() {
        initgameLoop();
    }
}