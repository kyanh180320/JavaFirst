package com.example.SpringTut.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // field nào null thì không hiện
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private int statusCode;

    /**
     * Tạo ApiResponse thành công
     * @param message Thông báo thành công
     * @param data Dữ liệu trả về
     * @return ApiResponse với success = true
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    /**
     * Tạo ApiResponse thành công (không có data)
     */
    public static <T> ApiResponse<T> success(String message) {
        return success(message, null);
    }

    /**
     * Tạo ApiResponse lỗi
     * @param message Thông báo lỗi
     * @param statusCode Mã HTTP status (ví dụ: 404, 400)
     * @return ApiResponse với success = false
     */
    public static <T> ApiResponse<T> error(String message, int statusCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setStatusCode(statusCode);
        return response;
    }

    /**
     * Tạo ApiResponse lỗi có kèm data (ví dụ: validation errors)
     * @param message Thông báo lỗi
     * @param statusCode Mã HTTP status
     * @param data Dữ liệu lỗi (ví dụ: Map các lỗi validation)
     */
    public static <T> ApiResponse<T> error(String message, int statusCode, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setStatusCode(statusCode);
        response.setData(data);
        return response;
    }
}
