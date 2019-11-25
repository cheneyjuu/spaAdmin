package com.swiftcode.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chen
 */
@Data
@AllArgsConstructor
public class UploadFileResponse implements Serializable {
    private static final long serialVersionUID = 2607358646209994670L;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    private UploadFileResponse() {
    }
}
