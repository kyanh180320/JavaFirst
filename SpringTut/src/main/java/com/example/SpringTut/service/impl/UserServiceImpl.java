package com.example.SpringTut.service.impl;

import com.example.SpringTut.dto.request.UserRequestDTO;
import com.example.SpringTut.dto.response.PageResponse;
import com.example.SpringTut.dto.response.UserDetailResponse;
import com.example.SpringTut.service.UserService;
import com.example.SpringTut.util.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {


    @Override
    public long saveUser(UserRequestDTO request) {
        return 0;
    }

    @Override
    public void updateUser(long userId, UserRequestDTO request) {

    }

    @Override
    public void changeStatus(long userId, UserStatus status) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        return null;
    }

//    @Override
//    public PageResponse getAllUser(int pageNo, int pageSize) {
//        return null;
//    }
}

