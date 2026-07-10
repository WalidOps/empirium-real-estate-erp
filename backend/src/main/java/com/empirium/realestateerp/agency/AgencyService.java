package com.empirium.realestateerp.agency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository){
        this.agencyRepository = agencyRepository;
    }

    private AgencyResponseDTO toResponseDTO(Agency agency){
        AgencyResponseDTO responseDTO = new AgencyResponseDTO();
        responseDTO.setId(agency.getId());
        responseDTO.setName(agency.getName());
        responseDTO.setEmail(agency.getEmail());
        responseDTO.setPhone(agency.getPhone());
        responseDTO.setAddress(agency.getAddress());
        responseDTO.setCity(agency.getCity());
        responseDTO.setCountry(agency.getCountry());
        responseDTO.setWebsite(agency.getWebsite());
        responseDTO.setActive(agency.getActive());
        responseDTO.setCreatedAt(agency.getCreatedAt());
        return responseDTO;
    }

    public AgencyResponseDTO createAgency(AgencyRequestDTO request){
        Agency agency = new Agency();
        agency.setName(request.getName());
        agency.setEmail(request.getEmail());
        agency.setPhone(request.getPhone());
        agency.setAddress(request.getAddress());
        agency.setCity(request.getCity());
        agency.setCountry(request.getCountry());
        agency.setWebsite(request.getWebsite());
        Agency saved = agencyRepository.save(agency);
        return toResponseDTO(saved);
    }

    public List<AgencyResponseDTO> getAllAgencies(){
        return agencyRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public AgencyResponseDTO getAgencyById(Long id){
        Agency agency = agencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Agency not found with id: " + id));
        return toResponseDTO(agency);
    }
}
