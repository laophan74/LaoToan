import java.sql.Date;

public class Video {
    private String id;
    private String name;
    private Date addedDate;
    private String videoPath;

    public Video(){}

    public Video (String id, String name, Date addedDate, String videoPath){
        this.id = id;
        this.name = name;
        this.addedDate = addedDate;
        this.videoPath = videoPath;
    }

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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
