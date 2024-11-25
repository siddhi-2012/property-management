package com.project.property.management.service.impl;

import com.project.property.management.converter.UserConverter;
import com.project.property.management.dto.UserDTO;
import com.project.property.management.entity.UserEntity;
import com.project.property.management.exception.BusinessException;
import com.project.property.management.exception.ErrorModel;
import com.project.property.management.repository.UserRepository;
import com.project.property.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> OptUe=userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(OptUe.isPresent())
        {
            List<ErrorModel> errorModelList =new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL ALREADY EXIST");
            errorModel.setMessage("The Email With which you are trying to register already exist ");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity= userRepository.save(userEntity);
        userDTO= userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO=null;
        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent()){
            userDTO=userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList =new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID LOGIN");
            errorModel.setMessage("INCORRECT EMAIL AND PASSWORD ");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
