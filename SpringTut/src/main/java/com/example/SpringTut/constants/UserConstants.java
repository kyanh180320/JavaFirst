package com.example.SpringTut.constants;

public class UserConstants {
    
    private UserConstants() {
        // Utility class
    }
    
    // Error messages
    public static final String USER_NOT_FOUND = "User not found with id: %s";
    public static final String USER_NOT_FOUND_BY_EMAIL = "User not found with email: %s";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists: %s";
    public static final String PHONE_ALREADY_EXISTS = "Phone number already exists: %s";
    public static final String USER_ALREADY_DELETED = "User with id %s has already been deleted";
    public static final String INVALID_USER_STATUS = "Invalid user status";
    
    // Validation messages
    public static final String FIRST_NAME_REQUIRED = "First name is required";
    public static final String LAST_NAME_REQUIRED = "Last name is required";
    public static final String EMAIL_REQUIRED = "Email is required";
    public static final String PHONE_REQUIRED = "Phone is required";
    
    // Default values
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String DEFAULT_SORT_BY = "createdAt";
    public static final String DEFAULT_SORT_DIRECTION = "DESC";
}

