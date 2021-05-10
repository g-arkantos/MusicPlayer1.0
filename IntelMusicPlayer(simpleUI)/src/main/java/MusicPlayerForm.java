import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicPlayerForm {
    static  musicPlayer player= musicPlayer();
    static String filePath="";
    static long clipTimePostion;
    static boolean isPlaying=true;
    static boolean isLooping = false;


    private JTextField FilePathTextField;
    private JButton LoadButton;
    private JLabel filePathLabel;
    private JButton PlayButton;
    private JButton PauseButton;
    private JButton LoopButton;

    public MusicPlayerForm() {
        LoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            filePath = FilePathTextField.getText();
            player.clip.stop();
            player.clip.setMicrosecondPosition(0);
            clipTimePostion=0;
            player.LoadMusic(filePath);

            }
        });
        PlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.clip.setMicrosecondPosition(0);
                clipTimePostion=0;
                player.clip.start();
            }
        });
        PauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying)
                {
                    clipTimePostion= player.clip.getMicrosecondPosition();
                    player.clip.stop();
                    PauseButton.setText("Resume");
                }
                else
                {
                    player.clip.setMicrosecondPosition(clipTimePostion);
                    player.clip.start();
                    PauseButton.setText("Pause");
                }
                isPlaying=!isPlaying;
            }
        });
        LoopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isLooping)
                {
                    player.clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                else
                {
                    player.clip.loop(0);
                }
                isLooping=!isLooping;
            }
        });
    }
}
