package com.example.SpringTut.exception;

import com.example.SpringTut.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler - Xử lý tất cả các exception trong ứng dụng
 * 
 * @RestControllerAdvice: 
 * - Annotation này cho Spring biết đây là class xử lý exception toàn cục
 * - Tự động bắt tất cả exception từ các @RestController
 * - Tương tự @ControllerAdvice nhưng tự động convert response thành JSON
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Xử lý exception khi không tìm thấy resource (404 Not Found)
     * 
     * @ExceptionHandler: Chỉ định method này sẽ xử lý exception nào
     * Khi có ResourceNotFoundException được ném ra ở bất kỳ đâu trong Controller,
     * Spring sẽ tự động gọi method này
     * 
     * @param ex Exception được ném ra
     * @return ResponseEntity chứa ApiResponse với status 404
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {
        // ResponseEntity: Wrapper của HTTP response, cho phép set status code và body
        // ApiResponse<Void>: Generic type Void nghĩa là không có data, chỉ có message
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // HTTP 404
                .body(ApiResponse.error(ex.getMessage(), 404));
    }

    /**
     * Xử lý exception khi validation thất bại (400 Bad Request)
     * 
     * MethodArgumentNotValidException được Spring tự động ném ra khi:
     * - Request body không hợp lệ (thiếu @Valid trong Controller)
     * - Các field không thỏa mãn validation annotations (@NotNull, @Size, etc.)
     * 
     * @param ex Exception chứa thông tin các lỗi validation
     * @return ResponseEntity chứa ApiResponse với Map các lỗi validation
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(
            MethodArgumentNotValidException ex) {
        
        // Tạo Map để lưu các lỗi validation
        // Key: tên field bị lỗi (ví dụ: "email", "username")
        // Value: thông báo lỗi (ví dụ: "Email không được để trống")
        Map<String, String> errors = new HashMap<>();
        
        // Duyệt qua tất cả các field bị lỗi và thêm vào Map
        // forEach với lambda expression: cách viết ngắn gọn của vòng lặp
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField(); // Tên field bị lỗi
            String errorMessage = error.getDefaultMessage(); // Thông báo lỗi
            errors.put(fieldName, errorMessage);
        });
        
        // Trả về response với status 400 và Map các lỗi
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // HTTP 400
                .body(ApiResponse.error("Dữ liệu không hợp lệ", 400, errors));
    }

    /**
     * Xử lý tất cả các exception khác chưa được xử lý (500 Internal Server Error)
     * 
     * Exception.class là parent của tất cả exception, nên sẽ bắt mọi exception
     * chưa được xử lý bởi các handler trên
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        // Log exception để debug (nên dùng logger thay vì printStackTrace)
        ex.printStackTrace();
        
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 500
                .body(ApiResponse.error("Đã xảy ra lỗi hệ thống", 500));
    }
}
