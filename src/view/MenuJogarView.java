package view;

import Enums.Jogar;
import UI.MenuJogarUI;
import gameUtil.Sons;
import java.awt.event.ActionEvent;

public class MenuJogarView extends MenuJogarUI {

    private Sons sons;
    
    public MenuJogarView(Sons sons){
        this.sons = sons;
    }
    
    @Override
    protected void btnUmJogador_OnClick(ActionEvent e) {        
        new LoginView(Jogar.Um, sons).setVisible(true);
        setVisible(false);
    }

    @Override
    protected void btnDoisJogador_OnClick(ActionEvent e) {        
        new LoginView(Jogar.Dois, sons).setVisible(true);
        setVisible(false);
    }

    @Override
    protected void btnMenuPrincipal_OnClick(ActionEvent e) {        
        new MenuPrincipalView().setVisible(true);
        setVisible(false);
    }        
}
