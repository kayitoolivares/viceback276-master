package com.leoolivares.viceback276.service.Implementation;

import com.leoolivares.viceback276.entity.Producto;
import com.leoolivares.viceback276.repository.IProductoRepository;
import com.leoolivares.viceback276.service.IProductoService;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductoImplementation implements IProductoService {
    @Autowired
    IProductoRepository repository;
    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> getById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Producto> producto =getById(aLong);
        if (producto.isPresent()){
            Producto producto1=producto.get();
            producto1.setEstatus(false);
            repository.save(producto1);
            return true;
        }

        return false;
    }

    @Override
    public List<Producto> getAllActivos() {
        return repository.findAllByEstatus(true);
    }
}
