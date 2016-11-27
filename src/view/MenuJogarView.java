package view;

import UI.MenuJogarUI;
import java.awt.event.ActionEvent;

public class MenuJogarView extends MenuJogarUI {

    @Override
    protected void btnUmJogador_OnClick(ActionEvent e) {
        hide();
        new MenuDificuldadeView().setVisible(true);
    }

    @Override
    protected void btnDoisJogador_OnClick(ActionEvent e) {
        hide();
        super.btnDoisJogador_OnClick(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void btnMenuPrincipal_OnClick(ActionEvent e) {
        hide();   
        new MenuDificuldadeView().setVisible(true);
    }        
}
