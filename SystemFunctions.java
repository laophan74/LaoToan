import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemFunctions {
    public void addVideo(Scanner scanner, Video video, List<Video> videoList){
        System.out.print("Enter video id: ");
        String id = scanner.next();
        scanner.nextLine();
        System.out.print("Enter video name: ");
        String name = scanner.nextLine();
        System.out.print("Enter video path: ");
        String path = scanner.nextLine();

        video.setId(id);
        video.setName(name);
        video.setVideoPath(path);
        videoList.add(video);

    }

    public void borrowVideo(){

        System.out.println("Video borrowed!");
    }

    public void modifyVideo(){

        System.out.println("Video modified!");
    }

    public void deleteVideo(){

        System.out.println("Video deleted!");
    }

    public void searchVideo(){

        System.out.println("List of video");
    }

    public void reportVideo(){

        System.out.println("List of video");
    }
}
