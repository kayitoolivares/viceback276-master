package com.leoolivares.viceback276.service;

import com.leoolivares.viceback276.entity.Cliente;
import com.leoolivares.viceback276.entity.Factura;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IFacturaService {

    List<Factura> getAll();
    Optional<Factura> getById(Long aLong);
    Factura save(Factura factura);
    Boolean delete(Long aLong);
    String Afectar(Long aLong);

    List<Factura> getAllByCliente(Long aLong);
    List<Factura> getAllByUsuario(Long aLong);
}
