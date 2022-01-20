package app.song_info_validation.service;

import app.song_info_validation.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {

    Optional<Song> findById(Integer id);

    void saveSong(Song song);

    List<Song>findAll();
}
