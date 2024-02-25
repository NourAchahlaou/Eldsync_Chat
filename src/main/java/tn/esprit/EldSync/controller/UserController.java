package tn.esprit.EldSync.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.EldSync.model.UserTest;
import tn.esprit.EldSync.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MessageMapping("/addUser")
    @SendTo("/user/topic")
    public UserTest addUser(@Payload UserTest user) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/disconnectUser")
    @SendTo("/user/topic")//notify to the same queue that someone has disconnected
    public UserTest disconnectUser(@Payload UserTest user) {
        userService.disconnectUser(user);
        return user;
    }

    @GetMapping("/connectedUsers")
    public List<UserTest> findConnectedUser() {
        return userService.findConnectedUser();
    }


}
