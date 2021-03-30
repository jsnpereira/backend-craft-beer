package com.craft.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.beer.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

}
