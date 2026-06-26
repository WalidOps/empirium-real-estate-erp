package com.empirium.realestateerp.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Method 1: User -> UserResponseDTO
    UserResponseDTO toResponseDTO(User user);

    // Method 2: UserRequestDTO -> User
    @Mapping(target = "agency", ignore = true)
    User toEntity(UserRequestDTO requestDTO);
}
