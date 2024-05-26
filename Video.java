public class Video {
    private String id;
    private String name;
    private String modifiedDate;
    private String videoPath;

    public Video(){}

    public Video (String id, String name, String modifiedDate, String videoPath){
        this.id = id;
        this.name = name;
        this.modifiedDate = modifiedDate;
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

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
