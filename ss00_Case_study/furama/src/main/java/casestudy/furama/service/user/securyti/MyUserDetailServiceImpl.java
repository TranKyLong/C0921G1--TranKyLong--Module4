//package casestudy.furama.service.user.securyti;
//
//import casestudy.furama.model.MyUserDetail;
//import casestudy.furama.model.User;
//import casestudy.furama.reponsitory.user.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class MyUserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    IUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if(user == null) {
//            throw  new UsernameNotFoundException("User name: " + username + " not found. ");
//        }
//        return new MyUserDetail(user);
//    }
//
//}
