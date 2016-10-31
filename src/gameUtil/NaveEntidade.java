package gameUtil;

import abstracts.Entidade;
import model.EntidadeBase;
import view.GameView;

public class NaveEntidade extends Entidade{

    private GameView game;
    
    public NaveEntidade(EntidadeBase eb, GameView gv){
        super(eb.getSrc(), (int) eb.getX(), (int) eb.getY());
        this.game = gv;
    }

    @Override
    public void move(long delta) {        
        if ((vx < 0) && (x < 10)) {
            return;
        }
        
        if ((vx > 0) && (x > 750)) {
            return;
        }
        
        super.move(delta);
    }        
    
    @Override
    public void colide(Entidade other) {
        if (other instanceof AlienEntidade) {
            //game.notifyDeath();
        }
    }
    
}
