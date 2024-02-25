package tn.esprit.EldSync.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.EldSync.service.ChatRoomService;

@Service
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @DeleteMapping("/chat/{senderId}/{recipientId}")
    public void deleteChatRoom(
            @PathVariable String senderId,
            @PathVariable String recipientId
    ) {
        chatRoomService.deleteChatRoom(senderId, recipientId);
    }
}
