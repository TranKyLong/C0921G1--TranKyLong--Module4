package app.reponsitory.impl;

import app.model.Song;
import app.reponsitory.ISongReponsitory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongReponsitoryImpl implements ISongReponsitory {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> showAll() {

        TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM Song AS s", Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Long id) {
        TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM Song AS s WHERE s.id = :id", Song.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }
    @Override
    public void delete(Long id) {
//        String delete = "delete FROM Song AS s WHERE s.id = :id";\
        Song deleteSong = findById(id);
        if (deleteSong != null) {
            entityManager.remove(deleteSong);
        }
    }

    @Override
    public void save(Song song) {
        if (song.getId() != null) {
            entityManager.merge(song);
        } else {
            entityManager.persist(song);
        }
    }

    @Override
    public void update(int id) {

    }

}
