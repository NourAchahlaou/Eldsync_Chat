package tn.esprit.EldSync.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.EldSync.model.Attachment;
import tn.esprit.EldSync.repository.AttachmentRepository;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public Attachment saveAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public Attachment getAttachmentById(String attachmentId) {
        return attachmentRepository.findById(attachmentId).orElse(null);
    }

    public void deleteAttachment(String attachmentId) {
        attachmentRepository.deleteById(attachmentId);
    }
}
