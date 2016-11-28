package view;

import Enums.Dificuldade;
import UI.MenuDificuldadeUI;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import model.Jogador;

public class MenuDificuldadeView extends MenuDificuldadeUI{

    private Jogador jogador;
    private HashMap<Integer, Jogador> hashJogador = new HashMap<>();
    
    public MenuDificuldadeView(Jogador jogador){
        this.jogador = jogador;
    }
    
    public MenuDificuldadeView(HashMap<Integer, Jogador> hashJogador){
        this.hashJogador = hashJogador;
    }
    
    @Override
    protected void btnFacil_OnClick(ActionEvent e) {
      hide();
      if(hashJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Facil, hashJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Facil, jogador))).start();  
    }

    @Override
    protected void btnMedio_OnClick(ActionEvent e) {
       hide();
        if(hashJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Medio, hashJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Medio, jogador))).start();      
    }

    @Override
    protected void btnDificil_OnClick(ActionEvent e) {
       hide();
        if(hashJogador.size() > 0)
        (new Thread(new GameView(Dificuldade.Dificil, hashJogador))).start();  
      else
        (new Thread(new GameView(Dificuldade.Dificil, jogador))).start();  
    }            
}