package view;

import Enums.Dificuldade;
import UI.GameUI;
import abstracts.Entidade;
import controller.GameController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.EntidadeBase;
import model.Game;
import model.Jogador;

public class GameView extends GameUI implements Runnable{

    private final GameController gameController;
    private Game game;
    private EntidadeBase eb;
    private final ArrayList<Entidade> lstEntidade = new ArrayList<>();
    private final ArrayList<Entidade> lstEntidadeRemovidas = new ArrayList<>();    
    
    private Jogador jogador;
    private List<Jogador> lstJogador = new ArrayList<>();
        
    public GameView(Dificuldade dificuldade, Jogador jogador){  
        super();        
        
        gameController = new GameController(this, lstEntidade, lstEntidadeRemovidas, jogador);                       
        game = gameController.BaseGame(dificuldade, getBufferStrategy());        
        startEntidade();
    }
    
      public GameView(Dificuldade dificuldade, List<Jogador> lstJogador){  
        super();        
        this.lstJogador = lstJogador;
        gameController = new GameController(this, lstEntidade, lstEntidadeRemovidas, lstJogador);                       
        game = gameController.BaseGame(dificuldade, getBufferStrategy());        
        startEntidade();
    }

    @Override
    protected void startGame() {
        lstEntidade.clear();
        startEntidade();
              
        game.setLeftPressed(false);
        game.setRightPressed(false);
        game.setTiroPressionado(false);
    }        
    
    @Override
    protected void startEntidade() {
        eb = new EntidadeBase();
        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\resources\\ship.gif");
        eb.setX(370);
        eb.setY(550);
        gameController.iniciaNave(eb);
        
        eb = new EntidadeBase();
        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\resources\\alien.gif");
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
        game.setMessage("Venceu! Menos na vida");
        game.setEspraKeyPress(true);
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
    public void KeyPressed(KeyEvent e) {
       
        if(e.getKeyCode() != KeyEvent.VK_F1){
            if(game.isEspraKeyPress()){
                return;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            game.setLeftPressed(true);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.setRightPressed(true);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            game.setTiroPressionado(true);
        }        
        
        if(e.getKeyCode() == KeyEvent.VK_P){            
            game.setPause(!game.isPause() ? true : false);           
            if(game.isPause()){
                new MenuPauseView(game, this).setVisible(true);
            }
        } 
        
        if(e.getKeyCode() == KeyEvent.VK_M){
            game.setGameMudo(!game.isGameMudo() ? true : false);
            if(game.isGameMudo())
                gameController.Mudo();
            else
                gameController.Som();
        }
        
        if(e.getKeyCode() == KeyEvent.VK_F1){                        
            
            game.setPause(!game.isPause() ? true : false);    
            if(game.isPause()){
                /*Chama a view aqui*/
                JOptionPane.showConfirmDialog(null, "TEste");
            }
        }
    }        

    @Override
    public void KeyReleased(KeyEvent e) {       
        if(game.isEspraKeyPress()){
            return;
        }                 
         
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            game.setLeftPressed(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.setRightPressed(false);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            game.setTiroPressionado(false);
        }                 
    }        

    @Override
    public void KeyTyped(KeyEvent e) {
        if(game.isEspraKeyPress()){
            if(pressCount == 1){
                game.setEspraKeyPress(false);
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
    
    public void close(){
        game.setGameExec(false);
        gameController.Mudo();
        Thread.interrupted();        
        frmGame.setVisible(false);
    }
    
    @Override
    public void run() {
        initgameLoop();
    }
}