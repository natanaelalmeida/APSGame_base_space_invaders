package gameUtil;

import abstracts.Entidade;
import model.EntidadeBase;
import view.GameView;

public class AlienEntidade extends Entidade{
    
    private double movPadrao = 75;    
    private GameView game;
    
    public AlienEntidade(EntidadeBase eb, GameView gv){
        super(eb.getSrc(), (int) eb.getX(), (int) eb.getY());
        this.game = gv;
        vx = -movPadrao;
    }
    
    public void move(long delta){
        if ((vx < 0) && (x < 10)) {
            game.updateLogic();
        }

        if ((vx > 0) && (x > 750)) {
            game.updateLogic();
        }
        
        super.move(delta);
    }

    @Override
    public void doLogic() {
        vx = -vx;
        y += 10;

        if (y > 570) {
            //game.notifyDeath();
        }
    }        

    @Override
    public void colide(Entidade other) {
        
    }
}