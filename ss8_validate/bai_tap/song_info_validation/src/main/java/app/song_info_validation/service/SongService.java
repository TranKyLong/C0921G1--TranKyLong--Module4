package app.song_info_validation.service;

import app.song_info_validation.model.Song;
import app.song_info_validation.reponsitory.ISongReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    ISongReponsitory iSongReponsitory;


    @Override
    public Optional<Song> findById(Integer id) {
        return iSongReponsitory.findById(id);
    }

    @Override
    public void saveSong(Song song) {
        iSongReponsitory.save(song);
    }

    @Override
    public List<Song> findAll() {
        return iSongReponsitory.findAll();
    }
}
