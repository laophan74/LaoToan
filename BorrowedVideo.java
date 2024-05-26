import java.sql.Date;

public class BorrowedVideo {
    private String id;
    private String name;
    private Date borrowedDate;
    private String videoPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public BorrowedVideo(){}

    public BorrowedVideo(String id, String name, Date borrowedDate, String videoPath) {
        this.id = id;
        this.name = name;
        this.borrowedDate = borrowedDate;
        this.videoPath = videoPath;
    }
}
