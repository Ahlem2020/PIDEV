package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Donationuser;

@Repository
public interface DonationuserRepository extends CrudRepository <Donationuser , Integer> {

}
