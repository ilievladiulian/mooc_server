package ilievlad.mooc.users.service;

import ilievlad.mooc.users.model.User;

/**
 * Created by Vlad on 22/06/2017.
 */
public interface UserService {
    boolean saveUser(User user);
    boolean deleteUser(long id);
}
