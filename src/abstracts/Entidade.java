package abstracts;

import gameUtil.Render;
import gameUtil.RenderConstruct;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entidade {
    protected double x;
    protected double y;
    protected double vx; //velocidade em x
    protected double vy; //velocidade em y
    private Rectangle me = new Rectangle();; //espaçamento da nave
    private Rectangle him = new Rectangle();; //espaçamento do alien    
    private Render render;
    
    public Entidade(String src, int x, int y){
        render = RenderConstruct.getRenderConstruct().getRender(src);
        this.x  = x;
        this.y  = y;
    }
    
    public void setMovX(double vx){
        this.vx = vx;
    }
    
    public void setMovY(double vy){
        this.vy = vy;
    }
    
    public double getMovX(){
        return vx;
    }
    
    public double getMovY(){
        return vy;
    }

    public double getX() {
        return (int) x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return (int) y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void move(long delta) {
        x += (delta * vx) / 1000;
        y += (delta * vy) / 1000;
    }
    
    /* Sem implementação */
    public void doLogic() {
    }
    
    public void draw(Graphics g) {
        render.drawImg(g,(int) x,(int) y);
    }
    
    public boolean colisao(Entidade e){
       me.setBounds((int)x, (int)y, render.getWidth(), render.getHeight());
       him.setBounds((int)e.x, (int)e.y, e.render.getWidth(), e.render.getHeight());
       
       return me.intersects(him);
    }
                
    public abstract void colide(Entidade other);
}