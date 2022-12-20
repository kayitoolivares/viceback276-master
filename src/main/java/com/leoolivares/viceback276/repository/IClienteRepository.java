package com.leoolivares.viceback276.repository;

import com.leoolivares.viceback276.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {

    List<Cliente> findAllByEstatus(Boolean aBoolean);
}
