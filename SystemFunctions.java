import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        System.out.println("\nAdd a new video");
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
        System.out.println("\nBorrow a video");
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
            videoToBorrow.setModifiedDate(getNow());
            borrowedVideoList.add(videoToBorrow);
            System.out.println("\nSuccessfully borrowed the video: " + videoToBorrow.getName());
        } else {
            System.out.println("\nVideo not found!");
        }
    }

    public void returnVideo(){
        System.out.println("\nReturn a video");
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
            videoToReturn.setModifiedDate(getNow());
            videoList.add(videoToReturn);
            System.out.println("\nSuccessfully returned the video: " + videoToReturn.getName());
        } else {
            System.out.println("\nVideo not found!");
        }
        
    }

    // Minh Toan start: modify video
    public void modifyVideo(){
        if (checkListVideo(videoList))
        {
            System.out.println("\nModify video");
            boolean checkCont = false;
            do {
                // Search video by ID
                System.out.println("Enter the ID of the video you want to modify: ");
                String id = scanner.nextLine();
                int x = 0;
                boolean checkFind = false;
                for (int i = 0; i < videoList.size(); i++) {
                    if (videoList.get(i).getId().equals(id))
                    {
                        System.out.println("The video needs to be modified");
                        printVideo(videoList.get(i));
                        System.out.println("----------------------------");
                        checkFind = true;
                        x = i;
                    }
                }
                if (checkFind) 
                {
                    // Input new information
                    System.out.println("Enter new information for video.");
                    String name1, path1;
                    System.out.print("Enter new video name: ");
                    name1 = scanner.nextLine();
                    System.out.print("Enter new video path: ");
                    path1 = scanner.nextLine();
                    videoList.get(x).setName(name1);
                    videoList.get(x).setVideoPath(path1);   
                    videoList.get(x).setModifiedDate(getNow());

                    // Show result
                    System.out.println("Video after modify");
                    printVideo(videoList.get(x));
                    System.out.println("-------------------");
                }
                else {
                    System.out.println("No matching results were found. Please double check your information!");
                }
                checkCont = checkContinue(scanner);
            } while (checkCont);
        }
    }

    // Minh Toan start: delete video by ID
    public void deleteVideo(){
        if (checkListVideo(videoList))
        {
            boolean checkCont = false;
            do {
                // Search video by ID
                System.out.println("Enter the ID of the video you want to delete: ");
                String id = scanner.nextLine();
                int x = 0;
                boolean checkFind = false;
                for (int i = 0; i < videoList.size(); i++) {
                    if (videoList.get(i).getId().equals(id))
                    {
                        System.out.println("The video needs to be delete");
                        printVideo(videoList.get(i));
                        System.out.println("----------------------------");
                        checkFind = true;
                        x = i;
                    }
                }
                if (checkFind) 
                {
                    System.out.println("Are you sure you want to delete this video? (Y/N)");
                    String delete = scanner.nextLine();
                    if (delete.equals("Y") || (delete.equals("y"))) 
                    {
                        videoList.remove(x);
                        System.out.println(" Deleted successfully.");
                    }
                    else 
                        System.out.println(" Deleted failed.");  
                }
                else {
                    System.out.println("No matching results were found. Please double check your information!");
                }
                checkCont = checkContinue(scanner);
            } while (checkCont);
        }
    }

    // Minh Toan start: new search video
    public void searchVideo(){
        if (checkListVideo(videoList))
        {
            System.out.println("Search video");
            boolean checkCont = false;
            do {
                int choice = -1;
                // Search video by Id, name, path, modify date
                System.out.println("Search: ");
                System.out.println("1. By Id");
                System.out.println("2. By name");
                System.out.println("3. By date");
                System.out.print("Your choice --> ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input!!!");
                    scanner.next();
                    continue; // Skip the rest of the loop and start again
                }
                switch (choice) {
                    case 1:
                        searchId(scanner, videoList);
                        break;
                    case 2:
                        searchName(scanner, videoList);
                        break;
                    case 3:
                        searchDate(scanner, videoList);
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                }
                checkCont = checkContinue(scanner);
            } while (checkCont);
        }
    }

    // Minh Toan: search by ID
    public void searchId(Scanner scanner, List<Video> videoList)
    {
        System.out.println("Enter the Id of the video you want to search: ");
        String id = scanner.nextLine();
        boolean resultSearch = true;
        for (int i = 0; i < videoList.size(); i++) {
            if (videoList.get(i).getId().contains(id))
            {
                if (resultSearch) System.out.println("Search Results:");
                printVideo(videoList.get(i));
                System.out.println("----------------------------");
                resultSearch = false;
            }
        }
        if (resultSearch) 
            System.out.println("No matching results were found. Please double check your information!");
    }

    // Minh Toan: search by name
    public void searchName(Scanner scanner, List<Video> videoList)
    {
        System.out.println("Enter the name of the video you want to search: ");
        String name = scanner.nextLine();
        boolean resultSearch = true;
        for (int i = 0; i < videoList.size(); i++) {
            if (videoList.get(i).getName().contains(name))
            {
                if (resultSearch) System.out.println("Search Results:");
                printVideo(videoList.get(i));
                System.out.println("----------------------------");
                resultSearch = false;
            }
        }
        if (resultSearch) 
            System.out.println("No matching results were found. Please double check your information!");
    }

    // Minh Toan: search by Modify date
    public void searchDate(Scanner scanner, List<Video> videoList)
    {
        System.out.println("Enter the modify date of the video you want to search: ");
        String date = scanner.nextLine();
        boolean resultSearch = true;
        for (int i = 0; i < videoList.size(); i++) {
            if (videoList.get(i).getModifiedDate().contains(date))
            {
                if (resultSearch) System.out.println("Search Results:");
                printVideo(videoList.get(i));
                System.out.println("----------------------------");
                resultSearch = false;
            }
        }
        if (resultSearch) 
            System.out.println("No matching results were found. Please double check your information!");
    }

    // Minh Toan start : print video
    public void printVideo(Video video) {
        System.out.println("ID: " + video.getId());
        System.out.println("Name: " + video.getName());
        System.out.println("Modified Date: " + video.getModifiedDate());
        System.out.println("Path: " + video.getVideoPath());
    }

    // Minh Toan start: check continue
    public boolean checkContinue(Scanner scanner)
    {
        System.out.println("Do you want to continue? (Y/N) ");
        String cont = scanner.nextLine();
        return cont.equals("Y") || (cont.equals("y"));
    }

    // Minh Toan start: check list video
    public boolean checkListVideo(List<Video> videoList)
    {
        if (videoList.size() > 0)
            return true;
        else
        {
            System.out.println("There are no videos in the system.");
            return false;
        }
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
