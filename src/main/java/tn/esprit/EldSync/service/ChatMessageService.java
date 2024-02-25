package tn.esprit.EldSync.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.EldSync.model.ChatMessage;
import tn.esprit.EldSync.repository.ChatMessageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    private final AttachmentService attachmentService;

    public ChatMessage save(ChatMessage chatMessage) {
        if (chatMessage.isFile() && chatMessage.getAttachments() != null) {
            // Save attachments first
            chatMessage.getAttachments().forEach(attachmentService::saveAttachment);
        }

        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(); // You can create your own dedicated exception
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}