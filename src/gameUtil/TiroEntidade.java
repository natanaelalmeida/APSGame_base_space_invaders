package gameUtil;

import abstracts.Entidade;
import model.EntidadeBase;
import view.GameView;

public class TiroEntidade extends Entidade{

    private double moveSpeed = -300;
    private final GameView game;
    private boolean usando = false;
    
    public TiroEntidade(GameView game, EntidadeBase entidadeBase) {
        super(entidadeBase.getSrc(), (int)entidadeBase.getX(), (int)entidadeBase.getY());
        this.game = game;
        
        vy = moveSpeed;
    }

    @Override
    public void move(long delta) {
        super.move(delta);
        
        if(y < -100){
            game.removerEntidade(this);
        }
    }
    
    
    @Override
    public void colide(Entidade other) {
        if(usando){
            return;
        }
        
        if(other instanceof AlienEntidade){
            game.removerEntidade(this);
            game.removerEntidade(other);    
            
            game.alienteMorreu();
            usando = true;
        }
    }           
           
}
