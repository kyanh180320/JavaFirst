package com.example.SpringTut.service;

import com.example.SpringTut.dto.request.UserRequestDTO;
import com.example.SpringTut.dto.response.PageResponse;
import com.example.SpringTut.dto.response.UserDetailResponse;
import com.example.SpringTut.util.UserStatus;

public interface UserService {
    
   long saveUser(UserRequestDTO request);
   void updateUser(long userId, UserRequestDTO request);
   void changeStatus(long userId, UserStatus status);
   void deleteUser(long userId);
   UserDetailResponse getUser(long userId);
//   PageResponse getAllUser(int pageNo, int pageSize);
}
