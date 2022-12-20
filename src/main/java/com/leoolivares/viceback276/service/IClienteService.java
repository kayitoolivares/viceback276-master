package com.leoolivares.viceback276.service;

import com.leoolivares.viceback276.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IClienteService {
    List<Cliente> getAll();
    Optional<Cliente> getById(Long aLong);
    Cliente save(Cliente cliente);
    Cliente delete(Long aLong);

    List<Cliente> getAllActivos();

}
