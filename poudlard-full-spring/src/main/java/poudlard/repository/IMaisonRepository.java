package poudlard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poudlard.model.Maison;

public interface IMaisonRepository extends JpaRepository<Maison, Integer>{

}
