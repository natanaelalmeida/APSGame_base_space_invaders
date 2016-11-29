package view;

import Enums.Dificuldade;
import UI.MenuDificuldadeUI;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;

public class MenuDificuldadeView extends MenuDificuldadeUI{

    private Jogador jogador;
    private List<Jogador> lstJogador = new ArrayList<>();
    
    public MenuDificuldadeView(Jogador jogador){
        this.jogador = jogador;
    }
    
    public MenuDificuldadeView(List<Jogador> lstJogador){
        this.lstJogador = lstJogador;
    }
    
    @Override
    protected void btnFacil_OnClick(ActionEvent e) {
      hide();
      if(lstJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Facil, lstJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Facil, jogador))).start();  
    }

    @Override
    protected void btnMedio_OnClick(ActionEvent e) {
       hide();
        if(lstJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Medio, lstJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Medio, jogador))).start();      
    }

    @Override
    protected void btnDificil_OnClick(ActionEvent e) {
       hide();
        if(lstJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Dificil, lstJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Dificil, jogador))).start();  
    }            
}