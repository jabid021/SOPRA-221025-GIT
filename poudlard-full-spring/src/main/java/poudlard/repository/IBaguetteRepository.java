package poudlard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poudlard.model.Baguette;

public interface IBaguetteRepository extends JpaRepository<Baguette, Integer>{

}
