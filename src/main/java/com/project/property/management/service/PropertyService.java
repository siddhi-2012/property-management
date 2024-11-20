package com.project.property.management.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.project.property.management.dto.PropertyDTO;

public interface PropertyService{

     PropertyDTO saveProperty(PropertyDTO propertyDTO);
     List<PropertyDTO> getAllProperties();
     PropertyDTO updateProperty(PropertyDTO propertyDTO,Long PropertyId);
     PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyId);
     PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, Long propertyId);
     
     void deleteProperty(Long propertyId);
}