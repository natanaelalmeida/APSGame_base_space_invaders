package gameUtil;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class RenderConstruct {
    
    private static RenderConstruct rc = new RenderConstruct();
    private HashMap<String, Render> hm = new HashMap<>();
    
    public Render getRender(String src){
                
        if(hm.get(src) != null){
            return hm.get(src);
        }
        
        BufferedImage bf = null;
        //URL url = getClass().getClassLoader().getResource(src);                
        
        try {
            InputStream is = new FileInputStream(src);
            bf = ImageIO.read(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
        Image img = gc.createCompatibleImage(bf.getWidth(), bf.getHeight(), Transparency.BITMASK);
        img.getGraphics().drawImage(bf, 0, 0, null);
        Render rd = new Render(img);
        hm.put(src, rd);
        
        return rd;
    }
    
    public static RenderConstruct getRenderConstruct(){
        return rc;
    }
}
