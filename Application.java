import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Application
 */
public class Application {
    private static int choice = 0;
    private static int choice1 = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Video> videoList = new ArrayList<>();
        ArrayList<Video> borrowedVideoList = new ArrayList<>();
        SystemFunctions systemFunctions = new SystemFunctions(scanner, videoList, borrowedVideoList);

        boolean closeMenu = false;
        while (!closeMenu) {
            createMenu();
            int choice = -1;

            /*
             * Input validation for choice
             * Source: https://stackoverflow.com/questions/43418994/java-util-inputmismatchexception-in-my-integer-validation-method
             */
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input!!!");
                scanner.next();
                continue; // Skip the rest of the loop and start again
            }
            switch (choice) {
                case 1:
                    systemFunctions.addVideo();
                    break;
                case 2:
                    systemFunctions.borrowVideo();
                    break;
                case 3:
                    systemFunctions.returnVideo();
                    break;
                case 4:
                    systemFunctions.modifyVideo();
                    break;
                case 5:
                    systemFunctions.deleteVideo();
                    break;
                case 6:
                    systemFunctions.searchVideo();
                    break;
                case 7:
                    systemFunctions.reportVideo();
                    break;
                case 8:
                    systemFunctions.reportBorrowedVideo();
                    break;
                case 9:
                    createSubMenu(scanner, videoList);
                    break;
                case 0:
                    closeMenu = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input, try again!");
            }
        }
        scanner.close();
    }

    private static void createMenu(){
        System.out.println("--------------------------------------");
        System.out.println("1. Add new video to the system");
        System.out.println("2. Borrow video");
        System.out.println("3. Return video");
        System.out.println("4. Modify video record");
        System.out.println("5. Delete video record");
        System.out.println("6. Search video");
        System.out.println("7. Report of available videos");
        System.out.println("8. Report of borrowed videos");
        System.out.println("9. Play video");
        System.out.println("0. Exit");
        System.out.print("Your choice --> ");
    }

    private static void createSubMenu(Scanner scanner, ArrayList<Video> videoList){
        PlayVideo playVideo = new PlayVideo(0, videoList);
        boolean back = false;
        while (!back) {
            createPlayingVideoMenu();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    playVideo.currentVideo();
                    break;
                case 2:
                    playVideo.nextVideo();
                    break;       
                case 3:
                    playVideo.previousVideo();
                    break;
                case 0:
                    back = true;
                    break;     
                default:
                    System.out.println("\nInvalid input, try again!");
            }
        }
    }

    private static void createPlayingVideoMenu(){ 
        System.out.println("--------------------------------------");
        System.out.println("Play video");
        System.out.println("1. Current video");
        System.out.println("2. Next video");
        System.out.println("3. Previous video");
        System.out.println("0. Back <--");
        System.out.print("Your choice --> ");
    }
}