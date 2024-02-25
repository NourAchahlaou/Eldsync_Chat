package tn.esprit.EldSync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.EldSync.model.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}
