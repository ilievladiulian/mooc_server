package ilievlad.mooc.users.service.impl;

import ilievlad.mooc.users.model.User;
import ilievlad.mooc.users.repository.UserRepository;
import ilievlad.mooc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vlad on 22/06/2017.
 */
@Service
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveUser(User user) {
        if (this.userRepository.save(user) != null) return true;
        else return false;
    }

    @Override
    public boolean deleteUser(long id) {
        if (this.userRepository.findByUserIdIn(id) != null) {
            this.userRepository.deleteByUserId(id);
            return true;
        }
        return false;
    }

}
