package view;

import UI.PontuacaoUI;
import java.util.List;
import model.Pontuacao;

public class PontuacaoView extends PontuacaoUI{
    
    public PontuacaoView(List<Pontuacao> lstPontuacao){
        super();
        
        Pontuacao jogador1 = lstPontuacao.get(0);
        Pontuacao jogador2 = lstPontuacao.get(1);
        
        if(jogador1.getPontuacao() > jogador2.getPontuacao()){
            nomeVencedor = jogador1.getIdJogador().getUsuario();
            pontuacaoVencedor = String.valueOf(jogador1.getPontuacao());
            
            nomeDerrotado = jogador2.getIdJogador().getUsuario();
            pontuacaoDerrotado = String.valueOf(jogador2.getPontuacao());
        }
        else {
            nomeVencedor = jogador2.getIdJogador().getUsuario();
            pontuacaoVencedor = String.valueOf(jogador2.getPontuacao());
            
            nomeDerrotado = jogador1.getIdJogador().getUsuario();
            pontuacaoDerrotado = String.valueOf(jogador1.getPontuacao());
        }
    }
    
}
