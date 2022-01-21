package app.song_info_validation.dto;

import app.song_info_validation.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Annotation;

public class SongDto implements Validator {
    private Integer id;

    @NotBlank(message = "Can not blank")
    private String songName;

    @NotBlank(message = "Can not blank")
    private String singer;

    @NotBlank(message = "Can not blank")
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (!songDto.getSongName().matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("songName", "songName.wrongChar", "Can not contain special characters");
        }

        if (songDto.getSongName().length() > 800){
            errors.rejectValue("songName", "songName.wrongLength", "must not exceed 800 characters");
        }
        if (!songDto.getSinger().matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("singer", "singer.wrongChar", "Can not contain special characters");
        }

        if (songDto.getSinger().length() > 300){
            errors.rejectValue("singer", "singer.wrongLength", "must not exceed 300 characters");
        }

        if (!songDto.getCategory().matches("^([\\p{Lu}\\p{Ll}\\s0-9](,)?)*$")) {
            errors.rejectValue("category", "category.wrongChar", "Can not contain special characters");
        }

        if (songDto.getCategory().length() > 1000){
            errors.rejectValue("category", "category.wrongLength", "must not exceed 1000 characters");
        }
    }
}
