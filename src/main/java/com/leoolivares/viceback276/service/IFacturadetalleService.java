package com.leoolivares.viceback276.service;


import com.leoolivares.viceback276.entity.Facturadetalle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IFacturadetalleService {
    List<Facturadetalle> getAll();
    List<Facturadetalle> getAllByIdFactura(Long aLong);
    Optional<Facturadetalle> getById(Long aLong);
    Facturadetalle save(Facturadetalle  facturadetalle);
    Boolean delete(Long aLong);
}
