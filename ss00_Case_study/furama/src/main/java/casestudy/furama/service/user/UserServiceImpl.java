package casestudy.furama.service.user;

import casestudy.furama.model.User;
import casestudy.furama.reponsitory.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<User> findALl() {
        return iUserRepository.findAll();
    }
}
