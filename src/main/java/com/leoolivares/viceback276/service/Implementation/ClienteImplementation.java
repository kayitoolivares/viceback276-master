package com.leoolivares.viceback276.service.Implementation;

import com.leoolivares.viceback276.entity.Cliente;
import com.leoolivares.viceback276.repository.IClienteRepository;
import com.leoolivares.viceback276.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteImplementation implements IClienteService {

    @Autowired
    IClienteRepository repository;
    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> getById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente delete(Long aLong) {
        Optional<Cliente> cliente=repository.findById(aLong);
        if (cliente.isPresent()){
            Cliente cliente1=cliente.get();
            cliente1.setEstatus(false);
            repository.save(cliente1);
            return cliente1;
        }
        return null;
    }

    @Override
    public List<Cliente> getAllActivos() {
        return repository.findAllByEstatus(true);
    }
}
