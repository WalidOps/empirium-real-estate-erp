package com.empirium.realestateerp.agency;
// This is the Agency Entity - it represents
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agency {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)  // Database constraint - Not NULL
    private String name;

    @Column(nullable = false)
    private String email;

    private String phone;
    private String address;
    private String city;
    private String country;
    private String website;

    private Boolean active;
    private LocalDateTime createdAt;

    @PrePersist            // A JPA hook that set variables right after save() is called - before the entity is first saved to the database to create a value for the variables
    protected void onCreate(){
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }


}
