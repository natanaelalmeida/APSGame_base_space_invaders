package view;

import UI.MenuPrincipalUI;
import gameUtil.Sons;
import java.awt.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MenuPrincipalView extends MenuPrincipalUI{
    
    Sons sons = new Sons();
    
    public MenuPrincipalView(){
        sons.Menu();
    }        
    
    @Override
    protected void btnJogar_OnClick(ActionEvent e) {        
        new MenuJogarView(sons).setVisible(true);
    }

    @Override
    protected void btnRanking_OnClick(ActionEvent e) {
        new RankingView().setVisible(true);
    }

    @Override
    protected void btnCriarConta_OnClick(ActionEvent e) {        
        new CriarContaView().setVisible(true);
    }

    @Override
    protected void btnSair_OnClick(ActionEvent e) {        
        setVisible(false);
    }        
    
    public static void main(String[] args) {
        new MenuPrincipalView().setVisible(true);
        
        EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityFactory.createEntityManager();
    }
    
}
