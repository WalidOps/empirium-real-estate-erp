package com.empirium.realestateerp.agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface AgencyRepository extends JpaRepository<Agency, Long> {
}
