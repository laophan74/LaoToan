import javax.swing.*;
import java.util.ArrayList;

public class PlayVideo {
    private int currentIndex;
    private ArrayList<Video> videoList;

    public PlayVideo(int currentIndex, ArrayList<Video> videoList) {
        this.currentIndex = currentIndex;
        this.videoList = videoList;
    }

    public void playVideo(){
        try {
            Video video = new Video();
            video = videoList.get(currentIndex);
            String path = convertVideoPath(video.getVideoPath());

            JFrame frame = new JFrame("Playing " + video.getName());
            ImageIcon gifIcon = new ImageIcon(path);
            JLabel label = new JLabel(gifIcon);
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Cannot play!!!");
        }
    }

    public void currentVideo(){
        playVideo();
    }

    public void previousVideo(){
        if (currentIndex == 0) {    
            System.out.println("There is no previous video!");
        } else {
            currentIndex -= 1;
            playVideo();
        }
    }

    public void nextVideo(){
        if (currentIndex == videoList.size() - 1 ) {
            System.out.println("There is no next video!");
        } else {
            currentIndex += 1;
            playVideo();
        }
    }
    
    public String convertVideoPath(String path){
        return path.replace("\\", "\\\\");
    }
}
