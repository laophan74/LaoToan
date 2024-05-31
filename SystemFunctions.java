import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemFunctions {
    public void addVideo(Scanner scanner, ArrayList<Video> videoList){
        System.out.print("Enter video ID: ");
        String id = scanner.next();
        scanner.nextLine();
        System.out.print("Enter video name: ");
        String name = scanner.nextLine();
        System.out.print("Enter video path: ");
        String path = scanner.nextLine();
        String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        Video video = new Video(id, name, modifiedDate, path);
        videoList.add(video);
        System.out.println("\nVideo added successfully at " + video.getModifiedDate());
    }

    public void borrowVideo(){

        System.out.println("Video borrowed!");
    }

    public void returnVideo(){

        System.out.println("Video returned!");
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

    public void reportVideo(List<Video> videoList){
        Video video = new Video();
        System.out.println("List of video: ");
        for (int i = 0; i < videoList.size(); i++) {
            video = videoList.get(i);
            System.out.println("-------------------");
            System.out.println("ID: " + video.getId());
            System.out.println("Name: " + video.getName());
            System.out.println("Modified Date: " + video.getModifiedDate());
            System.out.println("Path: " + video.getVideoPath());
            System.out.println();
        }
    }

}
