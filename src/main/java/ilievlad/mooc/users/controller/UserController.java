package ilievlad.mooc.users.controller;

import ilievlad.mooc.users.model.User;
import ilievlad.mooc.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vlad on 22/06/2017.
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8888")
    @RequestMapping(value = "/users/disconnect", method = RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user) {
        return this.userService.deleteUser(user.getUserId());
    }
}
