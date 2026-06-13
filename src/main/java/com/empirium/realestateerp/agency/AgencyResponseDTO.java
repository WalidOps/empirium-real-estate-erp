package com.empirium.realestateerp.agency;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class AgencyResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String website;
    private Boolean active;
    private LocalDateTime createdAt;
}
