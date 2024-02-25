package tn.esprit.EldSync.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@Getter
@Setter
public class Attachment {
    @Id
    private String id;
    private String filename;
    private AttachmentType filetype;
    private long filesize;
    private String downloadUrl;
}
