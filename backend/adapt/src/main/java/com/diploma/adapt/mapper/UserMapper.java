package com.diploma.adapt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.diploma.adapt.model.User;
import com.diploma.adapt.dto.UserProfileDTO;
import com.diploma.adapt.dto.UserRegistrationDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRegistrationDTO dto);

    UserProfileDTO toProfileDTO(User user);

    @Mapping(target = "id", ignore = true)
    User toEntityProfileDTO(UserProfileDTO userProfileDTO);
}