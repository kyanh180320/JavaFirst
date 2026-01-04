package com.example.SpringTut.service;

import com.example.SpringTut.dto.request.request.UserCreationRequest;
import com.example.SpringTut.dto.request.request.UserUpdateRequest;
import com.example.SpringTut.model.User;
import com.example.SpringTut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;

   public User createUser(UserCreationRequest request){
      User user = new User();
      
      user.setFullname(request.getFullname());
      user.setPhoneNumber(request.getPhoneNumber());
      user.setAddress(request.getAddress() != null ? request.getAddress() : "");
      user.setPassword(request.getPassword());
      user.setDateOfBirth(request.getDateOfBirth());
      user.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
      user.setFacebookAccountId(request.getFacebookAccountId() != null ? request.getFacebookAccountId() : 0);
      user.setGoogleAccountId(request.getGoogleAccountId() != null ? request.getGoogleAccountId() : 0);

      return userRepository.save(user);
   }

   public User updateUser(Integer userId, UserUpdateRequest request) {
      User user = getUser(userId);

      if (request.getFullname() != null) {
          user.setFullname(request.getFullname());
      }
      if (request.getPhoneNumber() != null) {
          user.setPhoneNumber(request.getPhoneNumber());
      }
      if (request.getAddress() != null) {
          user.setAddress(request.getAddress());
      }
      if (request.getPassword() != null) {
          user.setPassword(request.getPassword());
      }
      if (request.getDateOfBirth() != null) {
          user.setDateOfBirth(request.getDateOfBirth());
      }
      if (request.getIsActive() != null) {
          user.setIsActive(request.getIsActive());
      }
      if (request.getFacebookAccountId() != null) {
          user.setFacebookAccountId(request.getFacebookAccountId());
      }
      if (request.getGoogleAccountId() != null) {
          user.setGoogleAccountId(request.getGoogleAccountId());
      }

      return userRepository.save(user);
   }

   public void deleteUser(Integer userId){
      userRepository.deleteById(userId);
   }

   public List<User> getUsers(){
      return userRepository.findAll();
   }

   public User getUser(Integer id){
      return userRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("User not found"));
   }
}
