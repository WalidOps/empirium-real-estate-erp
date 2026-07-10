package com.empirium.realestateerp.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Role role;
    private Long agencyId;
}
