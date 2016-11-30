package controller;

import DAO.PontuacaoDao;
import Enums.Dificuldade;
import Enums.Jogar;
import abstracts.Entidade;
import gameUtil.AlienEntidade;
import gameUtil.TiroEntidade;
import gameUtil.NaveEntidade;
import gameUtil.Sons;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import model.EntidadeBase;
import model.Game;
import model.Jogador;
import model.Pontuacao;
import view.GameView;
import view.PontuacaoView;

public class GameController {
    
    private PontuacaoDao pontuacaDao = new PontuacaoDao();
    private final Sons sons = new Sons();

    private final GameView gv;
    private Game gm;
    private final ArrayList<Entidade> lstEntidade;
    private final ArrayList<Entidade> lstEntidadeRemover;
    private Entidade nave;

    private int qtdAlien;
    private int qtdAlienCriado;
    private int qtdLine;

    private Jogar jogar;
    private Jogador jogador;
    private Jogador jogadorAtual;
    private List<Jogador> lstJogador;
    private List<Pontuacao> lstPontuacao = new ArrayList<>();
    private int qtdJogada = 1;
    private boolean partidaIniciada2Jogadores;
    
    private HashMap<Integer, Jogador> hashJogador = new HashMap<>();
    
    private Clip tiro;
    private Clip game;
    private boolean tiroNull = true;
    
    public GameController(GameView gv, ArrayList<Entidade> lstEntidade, ArrayList<Entidade> lstEntidadeRemover, Jogador jogador) {
        this.gv = gv;
        this.lstEntidade = lstEntidade;
        this.lstEntidadeRemover = lstEntidadeRemover;
        this.jogadorAtual = jogador;
        jogar = Jogar.Um;
    }
    
     public GameController(GameView gv, ArrayList<Entidade> lstEntidade, ArrayList<Entidade> lstEntidadeRemover, List<Jogador> lstJogador) {
        this.gv = gv;
        this.lstEntidade = lstEntidade;
        this.lstEntidadeRemover = lstEntidadeRemover;
        this.lstJogador = lstJogador;
        jogadorAtual = lstJogador.get(0);
        jogar = Jogar.Dois;
    }

    public Game BaseGame(Dificuldade dif, BufferStrategy strategy) {
        gm = new Game();
        double moveSpeed = 0;
        long interDisparo = 0;
        int qtdAlien = 0;

        switch (dif) {
            case Facil:
                moveSpeed = 300;
                interDisparo = 500;
                qtdAlien = 10;
                qtdLine = 4;
                break;
            case Medio:
                moveSpeed = 350;
                interDisparo = 400;
                qtdAlien = 12;
                qtdLine = 5;
                break;
            case Dificil:
                moveSpeed = 370;
                interDisparo = 350;
                qtdAlien = 14;
                qtdLine = 7;
                break;
        }

        gm.setGameExec(true);
        gm.setMovSpeed(moveSpeed);
        gm.setUltTiro(0);
        gm.setIntervaloDisparo(interDisparo);
        gm.setQtdAlien(qtdAlien);

        gm.setMessage("");
        gm.setLeftPressed(false);
        gm.setRightPressed(false);
        gm.setEspraKeyPress(true);
        gm.setLoop(false);
        gm.setTiroPressionado(false);
        gm.setBfStrategy(strategy);
        return gm;
    }

    public void iniciaAlien(EntidadeBase eb) {
        Double x = eb.getX();
        Double y = eb.getY();
        this.qtdAlien = gm.getQtdAlien();

        qtdAlienCriado = 0;
        for (int line = 0; line < qtdLine; line++) {
            for (int i = 0; i < gm.getQtdAlien(); i++) {
                eb.setX(x.intValue() + (i * 50));
                eb.setY(y.intValue() + line * 30);
                Entidade alien = new AlienEntidade(eb, gv);
                lstEntidade.add(alien);
                qtdAlienCriado++;
            }
        }
    }

    public Entidade iniciaNave(EntidadeBase eb) {
        nave = new NaveEntidade(eb, gv);
        lstEntidade.add(nave);
        return nave;
    }

    public void atirar() {
        if ((currentTimeMillis() - gm.getUltTiro()) < gm.getIntervaloDisparo()) {
            return;
        }

        gm.setUltTiro(currentTimeMillis());

        EntidadeBase eb = new EntidadeBase();
        Double x = nave.getX();
        Double y = nave.getY();

        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\resources\\shot.gif");        
        eb.setX(x.intValue() + 10);
        eb.setY(y.intValue() - 30);
        lstEntidade.add(new TiroEntidade(gv, eb));
        
        if(tiroNull)
            tiro = sons.Tiro();
    }

    public void InitGameLoop() {        
        long UltimoLoop = currentTimeMillis();
        game = sons.Game();
        while (gm.isGameExec()) {
            long delta = currentTimeMillis() - UltimoLoop;
            UltimoLoop = currentTimeMillis();

            Graphics2D g2d = (Graphics2D) gm.getbfStrategy().getDrawGraphics();
              
                Image img = new ImageIcon("resources/background.gif").getImage();
                g2d.drawImage(img, 0, 0, gv);

            g2d.setColor(Color.white);
            g2d.drawString("PONTUAÇÃO: " + gm.getPontos(), 15, 20);

            g2d.setColor(Color.white);
            g2d.drawString("JOGADOR: " + jogadorAtual.getUsuario(), 180, 20);
            
            if (!gm.isPause()) {
                if (!gm.isEspraKeyPress()) {
                    for (int i = 0; i < lstEntidade.size(); i++) {
                        Entidade entidade = (Entidade) lstEntidade.get(i);
                        entidade.move(delta);
                    }
                }

                for (int i = 0; i < lstEntidade.size(); i++) {
                    Entidade entidade = (Entidade) lstEntidade.get(i);
                    entidade.draw(g2d);
                }

                for (int i = 0; i < lstEntidade.size(); i++) {
                    for (int j = i + 1; j < lstEntidade.size(); j++) {
                        Entidade me = (Entidade) lstEntidade.get(i);
                        Entidade him = (Entidade) lstEntidade.get(j);

                        if (me.colisao(him)) {
                            me.colide(him);
                            him.colide(me);
                        }
                    }
                }

                lstEntidade.removeAll(lstEntidadeRemover);
                lstEntidadeRemover.clear();

                if (gm.isLoop()) {
                    for (int i = 0; i < lstEntidade.size(); i++) {
                        Entidade entidade = (Entidade) lstEntidade.get(i);
                        entidade.doLogic();
                    }

                    gm.setLoop(false);
                }

                if (gm.isEspraKeyPress()) {
                    game.start();
                    g2d.setColor(Color.white);
                    g2d.setFont(new Font("Abduction2002", Font.BOLD, 70));
                    g2d.drawString(gm.getMessage(),
                            (800 - g2d.getFontMetrics().stringWidth(gm.getMessage())) / 2, 250);

                    if(jogar == Jogar.Dois){                                                        
                        JogarDeDois();                    
                        
                        g2d.setFont(new Font("Abduction2002", Font.BOLD, 16));
                        g2d.drawString(qtdJogada <= 1 ? "Pressione qualquer tecla para Iniciar a partida do 1 jogador" 
                            : "Pressione qualquer tecla para Iniciar a partida do 2 jogador",
                            (800 - g2d.getFontMetrics().stringWidth(
                            "Pressione qualquer tecla para Iniciar a partida do 1 jogador")) / 2, 300);
                    }
                    else {
                        g2d.setFont(new Font("Abduction2002", Font.BOLD, 16));
                        g2d.drawString("Pressione qualquer tecla para Iniciar",
                            (800 - g2d.getFontMetrics().stringWidth("Pressione qualquer tecla para Iniciar")) / 2, 300);
                    }

                    gm.setPontos(0);
                }

                g2d.dispose();
                gm.getBfStrategy().show();

                nave.setMovX(0);

                if ((gm.isLeftPressed()) && (!gm.isRightPressed())) {
                    nave.setMovX(-gm.getMovSpeed());
                } else if ((gm.isRightPressed()) && (!gm.isLeftPressed())) {
                    nave.setMovX(gm.getMovSpeed());
                }

                if (gm.isTiroPressionado()) {
                    atirar();
                }
            }
            else{
                g2d.setColor(Color.white);
                g2d.drawString("Pause",
                (800 - g2d.getFontMetrics().stringWidth("Pause")) / 2, 300);
            }

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void atualizaLogicLoop() {
        gm.setLoop(true);
    }

    public void alienMorreu() {
        qtdAlienCriado--;
        if (qtdAlienCriado == 0) {
            jogardorGanhou();
        }

        lstEntidade.stream().filter((e) -> (e instanceof AlienEntidade)).forEachOrdered((e) -> {
            e.setMovX(e.getMovX() * 1.02);
        });
        
        gm.setPontos(gm.getPontos() + 100);
    }

    public void removerEntidade(Entidade entidade) {
        lstEntidadeRemover.add(entidade);
    }

    private void jogardorGanhou() { 
        gm.setMessage("VITORIA");
        gm.setEspraKeyPress(true);
        
        if(jogar == Jogar.Um){
            JogadorDeUm(new Pontuacao(jogadorAtual, gm.getPontos()));
        }
        else if(jogar == Jogar.Dois && qtdJogada == 1){
           lstPontuacao.add(new Pontuacao(jogadorAtual, gm.getPontos()));  
           jogadorAtual = lstJogador.get(1);
           qtdJogada++;
        }        
        
        tiro.stop();               
    }

    public void jogadorPerdeu() {
        gm.setMessage("DERROTA");
        gm.setEspraKeyPress(true);
                
        
        if(jogar == Jogar.Um){
            JogadorDeUm(new Pontuacao(jogadorAtual, gm.getPontos()));
        }
        else if(jogar == Jogar.Dois && qtdJogada == 1){
           lstPontuacao.add(new Pontuacao(jogadorAtual, gm.getPontos())); 
           jogadorAtual = lstJogador.get(1);
           qtdJogada++;
        }                 
        else if(jogar == Jogar.Dois && lstPontuacao.size() == 1 && hashJogador.size() == 2){
            lstPontuacao.add(new Pontuacao(jogadorAtual, gm.getPontos())); 
        }
        
        tiro.stop();
    }
    
    public void Mudo(){        
        tiroNull = false;
        game.stop();
    }
    
    public void Som(){
        tiroNull = true;
        game.start();
    }
    
    private void JogarDeDois(){
        
        if(!hashJogador.containsKey(jogadorAtual.getIdJogador())){
            hashJogador.put(jogadorAtual.getIdJogador(), jogadorAtual);
        }
        else if(hashJogador.size() == 2 && lstPontuacao.size() > 1){
            gv.close();                 
            new PontuacaoView(lstPontuacao);    
        }       
    }
    
    private void JogadorDeUm(Pontuacao pontuacao){
        Pontuacao j1 = pontuacaDao.SelecionarPorJogador(jogadorAtual);
        
        if(j1 != null){
            j1.setPontuacao(pontuacao.getPontuacao());
        }
        else {
            j1 = pontuacao;
        }
        
        pontuacaDao.Insert(j1);
    }
}
