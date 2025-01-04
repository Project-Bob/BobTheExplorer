package projectbob.bobtheexplorer.UI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayerManager {
    private static MusicPlayerManager instance;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    private MusicPlayerManager() {
        String musicFile = getClass().getResource("/projectbob/bobtheexplorer/test/Im Bob.mp3").toString();
        Media media = new Media(musicFile);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music
        mediaPlayer.setVolume(0.5); // Set volume (optional)
    }

    public static MusicPlayerManager getInstance() {
        if (instance == null) {
            instance = new MusicPlayerManager();
        }
        return instance;
    }

    public void playMusic() {
        if (!isPlaying) {
            mediaPlayer.play();
            isPlaying = true;
        }
    }

    public void stopMusic() {
        if (isPlaying) {
            mediaPlayer.stop();
            isPlaying = false;
        }
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
