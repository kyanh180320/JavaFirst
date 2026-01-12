package com.example.SpringTut.service;

import com.example.SpringTut.model.Test;
import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.TestRepository;
import com.example.SpringTut.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TestRepository testRepository;


    @Override
    @Transactional
    public void save(User user){
        Test test = new Test();
        Random random = new Random();
        test.setNumber(random.nextInt());
        testRepository.save(test);
        userRepository.save(user);
    }
}
