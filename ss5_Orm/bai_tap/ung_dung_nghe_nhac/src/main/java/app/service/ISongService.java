package app.service;

import app.model.Song;

import java.util.List;

public interface ISongService {
    Song findById(Long id);

    void delete(Long id);

    void save(Song song);

    void update(Long id);

    List<Song> showALL();
}
