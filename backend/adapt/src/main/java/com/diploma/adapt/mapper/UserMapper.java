package com.diploma.adapt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.diploma.adapt.model.User;
import com.diploma.adapt.dto.UserRegistrationDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRegistrationDTO dto);
    
}