package gameUtil;

import java.awt.Graphics;
import java.awt.Image;

public class Render {
    private Image img;
    
    public Render(Image img){
        this.img = img;
    }
    
    public int getWidth(){
        return img.getWidth(null);
    }
    
    public int getHeight(){
        return img.getHeight(null);
    }
    
    public void drawImg(Graphics gr, int x, int y){
        gr.drawImage(img, x, y, null);
    }
}
