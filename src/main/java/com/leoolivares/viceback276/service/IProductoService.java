package com.leoolivares.viceback276.service;


import com.leoolivares.viceback276.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IProductoService {
    List<Producto> getAll();
    Optional<Producto> getById(Long aLong);
    Producto save(Producto producto);
    Boolean delete(Long aLong);

    List<Producto> getAllActivos();
}
