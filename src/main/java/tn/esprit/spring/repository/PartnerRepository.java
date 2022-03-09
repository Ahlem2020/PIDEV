package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
	public Optional<Partner> findByEmail(String email);
	Boolean existsByEmail(String email);
	Partner findById(long id);
}
