package tn.esprit.EldSync.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.EldSync.model.Attachment;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
}
