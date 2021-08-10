package pojoBindings;

public class Track {
    private String artist;
    private String album;
    private String track;
    private Integer trackNo;
    private Rating rating;
    private Boolean downloaded;

    public Track(String artist, String album, String track, int trackNo, Rating rating, boolean downloaded) {
        this.artist = artist;
        this.album = album;
        this.track = track;
        this.trackNo = trackNo;
        this.rating = rating;
        this.downloaded = downloaded;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Integer getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(Integer trackNo) {
        this.trackNo = trackNo;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }
}
