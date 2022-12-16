package poudlard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poudlard.model.Sort;

public interface ISortRepository extends JpaRepository<Sort, Integer> {

}
