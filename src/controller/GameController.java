package controller;

import Enums.Dificuldade;
import abstracts.Entidade;
import gameUtil.AlienEntidade;
import gameUtil.FireEntidade;
import gameUtil.NaveEntidade;
import gameUtil.Sons;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.EntidadeBase;
import model.Game;
import view.GameView;

public class GameController {
    
    private final Sons sons = new Sons();
    
    private final GameView gv;
    private Game gm;
    private final ArrayList<Entidade> lstEntidade;
    private final ArrayList<Entidade> lstEntidadeRemover;
    private Entidade nave;
    
    private int qtdAlien;
    private int qtdAlienCriado;
    private int qtdLine;
    
    public GameController(GameView gv, ArrayList<Entidade> lstEntidade, ArrayList<Entidade> lstEntidadeRemover){
        this.gv = gv;
        this.lstEntidade = lstEntidade;
        this.lstEntidadeRemover = lstEntidadeRemover;
    }
    
    public Game BaseGame(Dificuldade dif, BufferStrategy strategy){
        gm = new Game();
        double moveSpeed = 0;
        long interDisparo = 0;
        int qtdAlien = 0;
        
        switch(dif){
            case Facil :
                moveSpeed = 300;
                interDisparo = 500;
                qtdAlien = 10;
                qtdLine = 2;
                break;
            case Medio :
                moveSpeed = 350;
                interDisparo = 400;
                qtdAlien = 12;
                qtdLine = 4;
                break;
            case Dificil :
                moveSpeed = 370;
                interDisparo = 350;
                qtdAlien = 14;                
                qtdLine = 5;
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
    
    public void iniciaAlien(EntidadeBase eb){     
        Double x = eb.getX();
        Double y = eb.getY();
        this.qtdAlien = gm.getQtdAlien();
        
        qtdAlienCriado = 0;
        for(int line = 0; line < qtdLine; line++){
            for(int i = 0; i < gm.getQtdAlien(); i++){
                eb.setX(x.intValue() + (i * 50));
                eb.setY(y.intValue() + line * 30);
                Entidade alien = new AlienEntidade(eb, gv);
                lstEntidade.add(alien);
                qtdAlienCriado++;
            }
        }        
    }
    
    public Entidade iniciaNave(EntidadeBase eb){
        nave = new NaveEntidade(eb, gv);
        lstEntidade.add(nave);
        return nave;
    }
    
    public void atirar(){
        if((currentTimeMillis() - gm.getUltTiro()) < gm.getIntervaloDisparo()){
            return;
        }
                
        gm.setUltTiro(currentTimeMillis());  
        
        EntidadeBase eb = new EntidadeBase();
        Double x = nave.getX();
        Double y = nave.getY();        
        
        eb.setSrc("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\shot.gif");
        eb.setX(x.intValue() + 10);
        eb.setY(y.intValue() - 30);
        lstEntidade.add(new FireEntidade(gv, eb));        
    }
    
    public void InitGameLoop(){
        long UltimoLoop = currentTimeMillis();
        while(gm.isGameExec()){
            long delta = currentTimeMillis() - UltimoLoop;
            UltimoLoop = currentTimeMillis();
            
            Graphics2D g2d = (Graphics2D) gm.getbfStrategy().getDrawGraphics();
            g2d.setColor(Color.black);                
            g2d.fillRect(0, 0, 800, 600);
           
            try {
                Image img = ImageIO.read(new File("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\background.gif"));
                g2d.drawImage(img, 0, 0, gv);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!gm.isEspraKeyPress()){
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
                    
                    if(me.colisao(him)){
                        me.colide(him);
                        him.colide(me);
                    }
                }
            }
            
            lstEntidade.removeAll(lstEntidadeRemover);
            lstEntidadeRemover.clear();
            
            if(gm.isLoop()){
                for (int i = 0; i < lstEntidade.size(); i++) {
                    Entidade entidade = (Entidade) lstEntidade.get(i);
                    entidade.doLogic();
                }
                
                gm.setLoop(false);
            }
            
            if(gm.isEspraKeyPress()){
                g2d.setColor(Color.white);
                g2d.drawString(gm.getMessage(), 
                (800 - g2d.getFontMetrics().stringWidth(gm.getMessage())) / 2, 250);
                
                g2d.drawString("Pressione qualquer tecla para Iniciar", 
                (800 - g2d.getFontMetrics().stringWidth("Pressione qualquer tecla para Iniciar")) / 2,300);
            }
            
            g2d.dispose();
            gm.getBfStrategy().show();
            
            nave.setMovX(0);
            
            if((gm.isLeftPressed()) && (!gm.isRightPressed())){
                nave.setMovX(-gm.getMovSpeed());
            }
            else if((gm.isRightPressed()) && (!gm.isLeftPressed())){
                nave.setMovX(gm.getMovSpeed());
            }
            
            if(gm.isTiroPressionado()){
                atirar();
            }
            
            try { Thread.sleep(10); } catch (Exception e) {}
        }        
    }
    
    public void atualizaLogicLoop(){
        gm.setLoop(true);
    }
    
    public void alienMorreu(){
        qtdAlienCriado--;        
        if(qtdAlienCriado == 0){
            jogardorGanhou();
        }
        
        lstEntidade.stream().filter((e) -> (e instanceof AlienEntidade)).forEachOrdered((e) -> {
            e.setMovX(e.getMovX() * 1.02);
        });             
    }
    
    public void removerEntidade(Entidade entidade){
        lstEntidadeRemover.add(entidade);        
    }
    
    private void jogardorGanhou(){
        gm.setMessage("Parabéns! Você ganhou!");
        gm.setEspraKeyPress(true);
    }
    
    public void jogadorPerdeu(){
         gm.setMessage("Ah! Você perdeu, deseja tentar novamente?");
        gm.setEspraKeyPress(true);
    }
}
