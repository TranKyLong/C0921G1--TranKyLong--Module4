package app.song_info_validation.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.lang.annotation.Annotation;

public class SongDto  {
    private Integer id;

//    @NotBlank
    private String songName;

//    @NotBlank
    private String singer;

    @NotBlank
    private String category;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
