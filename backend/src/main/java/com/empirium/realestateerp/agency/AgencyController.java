package com.empirium.realestateerp.agency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/agencies")
public class AgencyController {
    private final AgencyService agencyService;
    public AgencyController(AgencyService agencyService){
        this.agencyService = agencyService;
    }

    @GetMapping
    public List<AgencyResponseDTO> getAllAgencies(){
        return agencyService.getAllAgencies();
    }

    @GetMapping("/{id}")
    public AgencyResponseDTO getAgency(@PathVariable Long id){
        return agencyService.getAgencyById(id);
    }

    @PostMapping
    public ResponseEntity<AgencyResponseDTO> createAgency(@RequestBody AgencyRequestDTO request){
        AgencyResponseDTO created = agencyService.createAgency(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


}
