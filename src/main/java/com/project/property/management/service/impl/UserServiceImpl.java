package com.project.property.management.service.impl;

import com.project.property.management.converter.UserConverter;
import com.project.property.management.dto.UserDTO;
import com.project.property.management.entity.UserEntity;
import com.project.property.management.repository.UserRepository;
import com.project.property.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity= userRepository.save(userEntity);
        userDTO= userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
