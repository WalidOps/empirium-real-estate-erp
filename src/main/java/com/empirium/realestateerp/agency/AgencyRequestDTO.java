package com.empirium.realestateerp.agency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AgencyRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String website;
}
