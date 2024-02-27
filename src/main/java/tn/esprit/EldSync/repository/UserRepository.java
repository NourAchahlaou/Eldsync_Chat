package tn.esprit.EldSync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.EldSync.model.Status;
import tn.esprit.EldSync.model.User;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
