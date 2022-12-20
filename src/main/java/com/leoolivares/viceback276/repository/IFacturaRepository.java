package com.leoolivares.viceback276.repository;

import com.leoolivares.viceback276.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacturaRepository extends JpaRepository<Factura,Long> {

    List<Factura> findAllByIdcliente(Long aLong);
    List<Factura> findAllByIdusuario(Long aLong);
}
