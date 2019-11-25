package com.swiftcode.web.rest.errors;

/**
 * @author chen
 */
public class FileException extends RuntimeException {
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
