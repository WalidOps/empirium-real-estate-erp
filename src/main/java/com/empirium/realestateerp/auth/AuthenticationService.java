package com.empirium.realestateerp.auth;

import com.empirium.realestateerp.agency.Agency;
import com.empirium.realestateerp.agency.AgencyRepository;
import com.empirium.realestateerp.config.JwtService;
import com.empirium.realestateerp.user.User;
import com.empirium.realestateerp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AgencyRepository agencyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Register:
    public AuthenticationResponse register(RegisterRequest request){
        Agency agency = agencyRepository.findById(request.getAgencyId())
                .orElseThrow(() -> new RuntimeException("Agency not found with id: " + request.getAgencyId()));
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        user.setAgency(agency);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    // Authenticate:
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
