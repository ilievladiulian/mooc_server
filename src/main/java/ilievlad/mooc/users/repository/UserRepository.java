package ilievlad.mooc.users.repository;

import ilievlad.mooc.users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Vlad on 22/06/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional
    void deleteByUserId(long id);
    User findByUserIdIn(long id);
}
