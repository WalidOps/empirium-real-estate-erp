package com.empirium.realestateerp.auth;

import com.empirium.realestateerp.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private Role role;
    private Long agencyId;
}
