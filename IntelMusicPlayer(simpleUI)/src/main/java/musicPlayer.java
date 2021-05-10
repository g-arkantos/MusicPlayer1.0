import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class musicPlayer {
    static musicPlayer player=new musicPlayer();
    static Clip clip;


    public musicPlayer get()
    {
     return player;
    }
    public static void LoadMusic(String filePath)
    {
        try
        {
         File musicPath= new File(filePath);
         if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip=AudioSystem.getClip();
                clip.open(audioInput);
                JOptionPane.showMessageDialog(null,"initiallized");
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
