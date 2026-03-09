package com.example.SpringTut.exception;

/**
 * Exception được ném ra khi không tìm thấy resource (ví dụ: User, Post không tồn tại)
 * Kế thừa từ RuntimeException nên không cần khai báo throws
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s không tìm thấy với %s: '%s'", resourceName, fieldName, fieldValue));
    }
}
