package controller;

import DAO.JogadorDao;
import model.Jogador;

public class JogadorController {
    
    private String msgErro;
    private JogadorDao repositorio = new JogadorDao();             
    
    public boolean Salvar(Jogador jogador){
        boolean status =  repositorio.Inserir(jogador);
        msgErro = repositorio.getMsgErro();
        return status;
    }
    
    public Jogador Selecionar(long id_jogador){
        return repositorio.Selecionar(id_jogador);
    }
    
    public String getMsgErro() {
        return msgErro;
    }
}
