package view;

import UI.MenuPauseUI;
import gameUtil.Sons;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Game;

public class MenuPauseView extends MenuPauseUI{

    private Game game;
    private GameView gameView;
    
    public MenuPauseView(Game game, GameView gameView){
        super();
        this.game = game;
        this.gameView = gameView;
    }
    
    @Override
    protected void btnJogar_OnClick(ActionEvent e) {
        game.setPause(false);
        setVisible(false);
    }

    @Override
    protected void btnSair_OnClick(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente desistir do jogo?", "Sair",
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){            
            gameView.close();
            new Sons().Menu();
            setVisible(false);
        }        
    }        

    @Override
    public void KeyPressed(KeyEvent e) {
        game.setPause(false);
        setVisible(false);
    }        
}
