package app.reponsitory;

import app.model.Song;

import java.util.List;

public interface ISongReponsitory {
    Song findById(Long id);

    void delete(Long id);

    void save(Song song);

    void update(int id);

    List<Song> showAll();
}
