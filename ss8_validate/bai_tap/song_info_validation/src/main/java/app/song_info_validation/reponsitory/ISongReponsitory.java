package app.song_info_validation.reponsitory;

import app.song_info_validation.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongReponsitory extends JpaRepository<Song, Integer> {
}
