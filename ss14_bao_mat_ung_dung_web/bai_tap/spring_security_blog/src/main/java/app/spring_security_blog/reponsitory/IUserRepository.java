package app.spring_security_blog.reponsitory;

import app.spring_security_blog.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findByUserName(String userName);

}
