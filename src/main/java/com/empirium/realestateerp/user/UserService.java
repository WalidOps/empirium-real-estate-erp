package com.empirium.realestateerp.user;

import com.empirium.realestateerp.agency.Agency;
import com.empirium.realestateerp.agency.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final AgencyRepository agencyRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, AgencyRepository agencyRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.agencyRepository = agencyRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO createUser(UserRequestDTO requestDTO){
        // Convert the request DTO to an entity, agency will be null at this point - will fix later @TodO
        User user = userMapper.toEntity(requestDTO);

        // Finding agency
        Agency agency = agencyRepository.findById(requestDTO.getAgencyId()).orElseThrow(() -> new RuntimeException("Agency not found with id: " + requestDTO.getAgencyId()));


        // Setting the agency to the user
        user.setAgency(agency);

        // Save and convert back to response DTO
        User saved = userRepository.save(user);
        return userMapper.toResponseDTO(saved);
    }

    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toResponseDTO).toList();
    }
    
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with Id: " + id + " not found"));
        return userMapper.toResponseDTO(user);
    }
}
