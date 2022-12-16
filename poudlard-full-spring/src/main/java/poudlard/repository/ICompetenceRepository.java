package poudlard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poudlard.model.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence, Integer> {

}
