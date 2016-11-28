package controller;

import DAO.JogadorDao;
import model.Jogador;

public class LoginController {
    
    private JogadorDao jogadorDao = new JogadorDao();
    
    public Jogador Entrar(Jogador jogador){
        return jogadorDao.Login(jogador);
    }
}
