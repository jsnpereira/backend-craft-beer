package com.craft.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.beer.model.entity.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String> {

}
