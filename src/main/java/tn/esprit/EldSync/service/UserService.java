package tn.esprit.EldSync.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.EldSync.model.Status;
import tn.esprit.EldSync.model.UserTest;
import tn.esprit.EldSync.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(UserTest user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }
    public void disconnectUser(UserTest user){
        var storedUser = userRepository.findById(user.getNickName())
        .orElseThrow(() -> new RuntimeException("User not found"));
        if (storedUser.getStatus() == Status.ONLINE) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }
    public List<UserTest> findConnectedUser() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
