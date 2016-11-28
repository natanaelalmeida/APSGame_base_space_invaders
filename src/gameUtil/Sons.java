
package gameUtil;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public  class Sons {
    
    public void Tiro() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(execute("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\shipShot.wav"));
            clip.loop(0);
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Game(){
         try {
            Clip clip = AudioSystem.getClip();
            clip.open(execute("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\gameSong.wav"));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Menu(){
         try {
            Clip clip = AudioSystem.getClip();
            clip.open(execute("C:\\Users\\USER\\Desktop\\ApsGame\\ApsGame\\ApsGame\\src\\resources\\menuSong.wav"));
             clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private AudioInputStream execute(String path) throws  IOException, LineUnavailableException, 
            UnsupportedAudioFileException{
        URL url = new URL(path);       
        return AudioSystem.getAudioInputStream(url);        
    }
    
}
