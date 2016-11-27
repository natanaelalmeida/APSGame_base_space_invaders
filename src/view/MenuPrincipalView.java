package view;

import UI.MenuPrincipalUI;
import java.awt.event.ActionEvent;

public class MenuPrincipalView extends MenuPrincipalUI{
    
    @Override
    protected void btnJogar_OnClick(ActionEvent e) {
        hide();
        new MenuJogarView().setVisible(true);
    }

    @Override
    protected void btnRanking_OnClick(ActionEvent e) {
        super.btnRanking_OnClick(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void btnCriarConta_OnClick(ActionEvent e) {
        hide();
        new CriarContaView().setVisible(true);
    }

    @Override
    protected void btnSair_OnClick(ActionEvent e) {
        super.btnSair_OnClick(e); //To change body of generated methods, choose Tools | Templates.
    }        
    
    public static void main(String[] args) {
        new MenuPrincipalView().setVisible(true);
    }
    
}
