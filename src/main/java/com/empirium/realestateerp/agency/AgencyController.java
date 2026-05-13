package com.empirium.realestateerp.agency;

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
    public List<Agency> getAllAgencies(){
        return agencyService.getAllAgencies();
    }

    @PostMapping
    public Agency createAgency(@RequestBody Agency agency){
        return agencyService.createAgency(agency);
    }
}
