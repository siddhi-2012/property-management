package com.project.property.management.service;

import com.project.property.management.dto.UserDTO;

public interface UserService {

   UserDTO register(UserDTO userDTO);
   UserDTO login(String email,String password);
}
