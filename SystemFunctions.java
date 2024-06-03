import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemFunctions {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Video> videoList = new ArrayList<>();
    ArrayList<Video> borrowedVideoList = new ArrayList<>();
    
    public SystemFunctions(Scanner scanner, ArrayList<Video> videoList, ArrayList<Video> borrowedVideoList) {
        this.scanner = scanner;
        this.videoList = videoList;
        this.borrowedVideoList = borrowedVideoList;
    }

    public void addVideo(){
        String videoId;
        while (true) {
            System.out.print("Enter video ID: ");
            videoId = scanner.next();
            scanner.nextLine();

            // Check if the video ID already exists
            boolean exist = false;
            for (Video video : videoList) {
                if (video.getId().equals(videoId)) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                break;
            } else {
                System.out.println("A video with this ID already exists. Enter a different ID.");
            }
        }
        System.out.print("Enter video name: ");
        String name = scanner.nextLine();
        System.out.print("Enter video path: ");
        String path = scanner.nextLine();
        String modifiedDate = getNow();
        
        Video video = new Video(videoId, name, modifiedDate, path, null);
        videoList.add(video);
        System.out.println("\nVideo added successfully at " + video.getModifiedDate());
    }

    public void borrowVideo(){
        System.out.print("Enter video ID: ");
        String videoID = scanner.next();
        scanner.nextLine();
        System.out.print("Enter borrower name: ");
        String borrowerName = scanner.nextLine();

        Video videoToBorrow = null;
        for (Video video : videoList) {
            if (video.getId().equals(videoID)) {
                videoToBorrow = video;
                video.setBorrowerName(borrowerName);
                break;
            }
        }
        if (videoToBorrow != null) {
            videoList.remove(videoToBorrow);
            borrowedVideoList.add(videoToBorrow);
            System.out.println("\nSuccessfully borrowed the video: " + videoToBorrow.getName());
        } else {
            System.out.println("\nVideo not found!");
        }
    }

    public void returnVideo(){
        System.out.print("Enter the id of video which you want to return: ");
        String videoID = scanner.next();
        scanner.nextLine();
        
        Video videoToReturn = null;
        for (Video video : borrowedVideoList) {
            if (video.getId().equals(videoID)) {
                videoToReturn = video;
                video.setBorrowerName(null);
                break;
            }
        }
        if (videoToReturn != null) {
            borrowedVideoList.remove(videoToReturn);
            videoList.add(videoToReturn);
            System.out.println("\nSuccessfully returned the video: " + videoToReturn.getName());
        } else {
            System.out.println("\nVideo not found!");
        }
        
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
        Video video = new Video();
        System.out.println("List of videos: ");
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

    public void reportBorrowedVideo() {
        Video video = new Video();
        System.out.println("List of borrowed videos: ");
        for (int i = 0; i < borrowedVideoList.size(); i++) {
            video = borrowedVideoList.get(i);
            System.out.println("-------------------");
            System.out.println("ID: " + video.getId());
            System.out.println("Name: " + video.getName());
            System.out.println("Borrowed Date: " + video.getModifiedDate());
            System.out.println("Path: " + video.getVideoPath());
            System.out.println("Borrower name: " + video.getBorrowerName());
            System.out.println();
        }
    }

    public String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
