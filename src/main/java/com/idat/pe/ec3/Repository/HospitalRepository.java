package com.idat.pe.ec3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.ec3.Model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
