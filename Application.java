import java.util.Scanner;

/**
 * Application
 */
public class Application {
    private static int choice = 0;
    private static int choice1 = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemFunctions systemFunctions = new SystemFunctions();

        boolean closeMenu = false;
        while (!closeMenu) {
            createSelectionMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    systemFunctions.addVideo();
                    break;
                case 2:
                    systemFunctions.borrowVideo();
                    break;
                case 3:
                    systemFunctions.modifyVideo();
                    break;
                case 4:
                    systemFunctions.deleteVideo();
                    break;
                case 5:
                    systemFunctions.searchVideo();
                    break;
                case 6:
                    systemFunctions.reportVideo();
                    break;
                case 7:
                    playVideoSelections(scanner);
                    break;
                case 0:
                    closeMenu = true;
                    break;
                default:
                    System.out.println("\nInvalid input, try again!");
            }
        }

    }

    private static void createSelectionMenu(){
        System.out.println("--------------------------------------");
        System.out.println("1. Add new video to the system");
        System.out.println("2. Borrow video");
        System.out.println("3. Modify video record");
        System.out.println("4. Delete video record");
        System.out.println("5. Search video");
        System.out.println("6. Report of available videos");
        System.out.println("7. Play video");
        System.out.println("0. Exit");
        System.out.print("Your choice --> ");
    }

    private static void playVideoSelections(Scanner scanner){
        PlayVideo playVideo = new PlayVideo();
        boolean back = false;
        while (!back) {
            createPlayingVideoSelectionMenu();
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

    private static void createPlayingVideoSelectionMenu(){ 
        System.out.println("--------------------------------------");
        System.out.println("Play video");
        System.out.println("1. Current video");
        System.out.println("2. Next video");
        System.out.println("3. Previous video");
        System.out.println("0. Back <--");
        System.out.print("Your choice --> ");
    }
}