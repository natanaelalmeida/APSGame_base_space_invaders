package controller;

import Repositorio.JogadorRepositorio;
import model.Jogador;
import view.CriarContaView;

public class JogadorController {
    
    private JogadorRepositorio repositorio = new JogadorRepositorio();
    
    public void getCriarJogador(){
          new CriarContaView().setVisible(true);
    }
    
    public void Salvar(Jogador jogador){
        repositorio.Inserir(jogador);
    }
}
