package view;

import Enums.Jogar;
import UI.MenuJogarUI;
import java.awt.event.ActionEvent;

public class MenuJogarView extends MenuJogarUI {

    @Override
    protected void btnUmJogador_OnClick(ActionEvent e) {
        hide();
        new LoginView(Jogar.Um).setVisible(true);
    }

    @Override
    protected void btnDoisJogador_OnClick(ActionEvent e) {
        hide();
        new LoginView(Jogar.Dois).setVisible(true);
    }

    @Override
    protected void btnMenuPrincipal_OnClick(ActionEvent e) {
        hide();   
        new MenuPrincipalView().setVisible(true);
    }        
}
