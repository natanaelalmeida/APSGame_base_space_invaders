package view;

import Enums.Dificuldade;
import UI.MenuDificuldadeUI;
import java.awt.event.ActionEvent;

public class MenuDificuldadeView extends MenuDificuldadeUI{

    @Override
    protected void btnFacil_OnClick(ActionEvent e) {
      hide();
     (new Thread(new GameView(Dificuldade.Facil))).start();  
    }

    @Override
    protected void btnMedio_OnClick(ActionEvent e) {
       hide();
       (new Thread(new GameView(Dificuldade.Medio))).start();       
    }

    @Override
    protected void btnDificil_OnClick(ActionEvent e) {
       hide();
       (new Thread(new GameView(Dificuldade.Dificil))).start();  
    }            
}