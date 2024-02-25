package tn.esprit.EldSync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.EldSync.model.Status;
import tn.esprit.EldSync.model.UserTest;

import java.util.List;

public interface UserRepository extends MongoRepository<UserTest, String> {
    List<UserTest> findAllBYStatus(Status status);
}
