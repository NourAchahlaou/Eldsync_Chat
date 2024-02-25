package tn.esprit.EldSync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.EldSync.model.ChatRoom;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

    void deleteBySenderIdAndRecipientId(String senderId, String recipientId);
}
