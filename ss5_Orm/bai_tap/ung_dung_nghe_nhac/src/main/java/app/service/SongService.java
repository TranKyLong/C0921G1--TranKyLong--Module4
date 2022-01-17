package app.service;

import app.model.Song;
import app.reponsitory.ISongReponsitory;
import app.reponsitory.impl.SongReponsitoryImpl;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SongService implements ISongService {


    @Autowired
    ISongReponsitory songReponsitory;

    @Override
    public List<Song> showALL() {
        return songReponsitory.showAll();
    }

    @Override
    public Song findById(Long id) {
        return songReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
        songReponsitory.delete(id);
    }

    @Override
    public void save(Song song) {
        songReponsitory.save(song);
    }

    @Override
    public void update(Long id) {

    }


}
