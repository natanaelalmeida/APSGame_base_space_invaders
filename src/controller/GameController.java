package controller;

import abstracts.Entidade;
import gameUtil.AlienEntidade;
import gameUtil.NaveEntidade;
import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import model.EntidadeBase;
import model.GameModel;
import view.GameView;

public class GameController {
     
    private final GameView gv;
    private final GameModel gm;
    private final ArrayList<Entidade> lstEntidade;
    private final ArrayList<Entidade> lstEntidadeRemover;
    private Entidade nave;
    
    public GameController(GameView gv, GameModel gm, ArrayList<Entidade> lstEntidade, ArrayList<Entidade> lstEntidadeRemover){
        this.gv = gv;
        this.gm = gm;
        this.lstEntidade = lstEntidade;
        this.lstEntidadeRemover = lstEntidadeRemover;
    }
    
    public void iniciaAlien(EntidadeBase eb){     
        Double x = new Double(eb.getX());
        Double y = new Double(eb.getY());
        
        for(int line = 0; line < 5; line++){
            for(int i = 0; i < gm.getQtdAlien(); i++){
                eb.setX(x.intValue() + (i * 50));
                eb.setY(y.intValue() + line * 30);
                Entidade alien = new AlienEntidade(eb, gv);
                lstEntidade.add(alien);
            }
        }        
    }
    
    public Entidade iniciaNave(EntidadeBase eb){
        nave = new NaveEntidade(eb, gv);
        lstEntidade.add(nave);
        return nave;
    }
    
    public void atirar(EntidadeBase eb){
        if(currentTimeMillis() - gm.getUltTiro() < gm.getIntervaloDisparo()){
            return;
        }
        
        //gm.getUltTiro() = System.currentTimeMillis();        
    }
    
    public void InitGameLoop(){
        long UltimoLoop = currentTimeMillis();
        while(gm.isGameExec()){
            long delta = currentTimeMillis() - UltimoLoop;
            UltimoLoop = currentTimeMillis();
            
            Graphics2D g2d = (Graphics2D) gm.getbfStrategy().getDrawGraphics();
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, 800, 600);
            
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
                    Entidade ent = (Entidade) lstEntidade.get(i);
                    Entidade ent2 = (Entidade) lstEntidade.get(j);
                    
                    if(ent.colisao(ent2)){
                        ent.colide(ent2);
                        ent2.colide(ent);
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
                (800 - g2d.getFontMetrics().stringWidth("Pressione qualquer tecla para Iniciar"))/2,300);
            }
            
            g2d.dispose();
            gm.getBfStrategy().show();
            
            nave.setMovX(0);
            
            if((gm.isLeftPressed()) && (!gm.isRightPressed())){
                nave.setMovX(gm.getMovSpeed());
            }
            else if((gm.isRightPressed()) && (!gm.isLeftPressed())){
                nave.setMovX(gm.getMovSpeed());
            }
            
            if(gm.isTiroPressionado()){
                //atirar(eb);
            }
            
            try { Thread.sleep(10); } catch (Exception e) {}
        }        
    }
    
    public void atualizaLogicLoop(){
        gm.setLoop(true);
    }
    
    public void removerEntidade(Entidade entidade){
        lstEntidadeRemover.add(entidade);        
    }
}
