package com.idat.pe.ec3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.pe.ec3.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
