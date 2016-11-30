package view;

import Enums.Dificuldade;
import UI.MenuDificuldadeUI;
import gameUtil.Sons;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;

public class MenuDificuldadeView extends MenuDificuldadeUI {

    private Sons sons;
    private Jogador jogador;
    private List<Jogador> lstJogador = new ArrayList<>();

    public MenuDificuldadeView(Jogador jogador, Sons sons) {
        this.jogador = jogador;
        this.sons = sons;
    }

    public MenuDificuldadeView(List<Jogador> lstJogador, Sons sons) {
        this.lstJogador = lstJogador;
        this.sons = sons;
    }

    @Override
    protected void btnFacil_OnClick(ActionEvent e) {
        if (lstJogador.size() > 0) {
            (new Thread(new GameView(Dificuldade.Facil, lstJogador))).start();
        } else {
            (new Thread(new GameView(Dificuldade.Facil, jogador))).start();
        }

        sons.Close();
        setVisible(false);
    }

    @Override
    protected void btnMedio_OnClick(ActionEvent e) {
        if (lstJogador.size() > 0) {
            (new Thread(new GameView(Dificuldade.Medio, lstJogador))).start();
        } else {
            (new Thread(new GameView(Dificuldade.Medio, jogador))).start();
        }

        sons.Close();
        setVisible(false);
    }

    @Override
    protected void btnDificil_OnClick(ActionEvent e) {
        if (lstJogador.size() > 0) {
            (new Thread(new GameView(Dificuldade.Dificil, lstJogador))).start();
        } else {
            (new Thread(new GameView(Dificuldade.Dificil, jogador))).start();
        }
        
        sons.Close();
        setVisible(false);
    }
}
