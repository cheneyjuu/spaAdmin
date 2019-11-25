package com.swiftcode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chen
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;
}
