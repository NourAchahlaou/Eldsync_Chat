package tn.esprit.EldSync.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.EldSync.model.ChatRoom;
import tn.esprit.EldSync.repository.ChatRoomRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }

                    return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
