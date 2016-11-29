package view;

import UI.MenuPrincipalUI;
import java.awt.event.ActionEvent;

public class MenuPrincipalView extends MenuPrincipalUI{
    
    @Override
    protected void btnJogar_OnClick(ActionEvent e) {        
        new MenuJogarView().setVisible(true);
    }

    @Override
    protected void btnRanking_OnClick(ActionEvent e) {
        super.btnRanking_OnClick(e);
    }

    @Override
    protected void btnCriarConta_OnClick(ActionEvent e) {        
        new CriarContaView().setVisible(true);
    }

    @Override
    protected void btnSair_OnClick(ActionEvent e) {
        super.btnSair_OnClick(e); 
    }        
    
    public static void main(String[] args) {
        new MenuPrincipalView().setVisible(true);
    }
    
}
