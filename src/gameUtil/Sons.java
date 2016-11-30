
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
    
    private Clip clip;
    
    public Clip Tiro() {
        try {
            clip = AudioSystem.getClip();
            clip.open(execute(getClass().getResource("/shipShot.wav").toString()));
            clip.loop(0);
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return clip;
    }
    
    public Clip Game(){
         try {
            clip = AudioSystem.getClip();
            clip.open(execute(getClass().getResource("/gameSong.wav").toString()));
            clip.loop(Clip.LOOP_CONTINUOUSLY);                        
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return clip;
    }
    
    public Clip Menu(){
         try {
            clip = AudioSystem.getClip();
            clip.open(execute(getClass().getResource("/menuSong.wav").toString()));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return clip;
    }
    
    public Clip AlienKill(){
        try{
            clip = AudioSystem.getClip();
            clip.open(execute(getClass().getResource("/alienKill.wav").toString()));
            clip.loop(0);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clip;
    }
    
    public void Close(){
        clip.stop();
    }
    
    private AudioInputStream execute(String path) throws  IOException, LineUnavailableException, 
            UnsupportedAudioFileException{
        URL url = new URL(path);       
        return AudioSystem.getAudioInputStream(url);        
    }
    
}
