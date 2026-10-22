package dev.divyansh.sprintforge.attachment;

import dev.divyansh.sprintforge.common.ApiExceptionHandler.ServiceUnavailableException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        name = "app.storage.s3.enabled",
        havingValue = "false",
        matchIfMissing = true)
public class UnavailableAttachmentStorage implements AttachmentStorage {
    @Override
    public PresignedUpload presignUpload(String objectKey, String contentType, long sizeBytes) {
        throw new ServiceUnavailableException("S3 attachment storage is not configured");
    }
}
