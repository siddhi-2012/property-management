package com.project.property.management.service.impl;

import com.project.property.management.entity.PropertyEntity;
import com.project.property.management.dto.PropertyDTO;
import com.project.property.management.repository.PropertyRepository;
import com.project.property.management.service.PropertyService;


import com.project.property.management.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropertyServiceImpl implements PropertyService{


  @Autowired
  private PropertyRepository propertyRepository;

  @Autowired
  private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

      
      PropertyEntity pe= propertyConverter.convertDTOtoEntity( propertyDTO);
      pe= propertyRepository.save(pe);

      PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
      return dto;

    }

    @Override
    public List<PropertyDTO> getAllProperties() {
      List<PropertyEntity> listOfProps=(List<PropertyEntity>)propertyRepository.findAll();
      List<PropertyDTO> proplList=new ArrayList<>();


      for(PropertyEntity pe:listOfProps){
        PropertyDTO dto= propertyConverter.convertEntityToDTO(pe);
        proplList.add(dto);
      }
       return proplList ;
  }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
       
      Optional<PropertyEntity> optEn =propertyRepository.findById(propertyID);
      PropertyDTO dto = null;
      if(optEn.isPresent()){
        PropertyEntity pe= optEn.get(); //data from the database 
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());
        pe.setDescription(propertyDTO.getDescription());
        dto=propertyConverter.convertEntityToDTO(pe);
        propertyRepository.save(pe);


      
     }
     return dto;
          
}

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
      
      Optional<PropertyEntity> optEn =propertyRepository.findById(propertyId);
      PropertyDTO dto = null;
      if(optEn.isPresent()){
        PropertyEntity pe= optEn.get(); //data from the database 
        pe.setDescription(propertyDTO.getDescription());
        dto=propertyConverter.convertEntityToDTO(pe);
        propertyRepository.save(pe);
      }
      return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
      
      Optional<PropertyEntity> optEn =propertyRepository.findById(propertyId);
      PropertyDTO dto = null;
      if(optEn.isPresent()){
        PropertyEntity pe= optEn.get(); //data from the database 
        
        pe.setPrice(propertyDTO.getPrice());
        
        dto=propertyConverter.convertEntityToDTO(pe);
        propertyRepository.save(pe);

     
    }
    return dto;
}

    @Override
    public void deleteProperty(Long propertyId) {
     
      propertyRepository.deleteById(propertyId);
    }
}
