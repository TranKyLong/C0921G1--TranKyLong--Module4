package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String songName;
    private String artistName;
    private String category;
    private String songLink;

    public Song() {
    }

    public Song(String songName, String artistName, String category, String songLink) {
        this.songName = songName;
        this.artistName = artistName;
        this.category = category;
        this.songLink = songLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLlink) {
        this.songLink = songLlink;
    }
}
