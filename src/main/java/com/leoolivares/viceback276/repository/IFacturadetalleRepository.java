package com.leoolivares.viceback276.repository;

import com.leoolivares.viceback276.entity.Facturadetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacturadetalleRepository extends JpaRepository<Facturadetalle,Long> {

    List<Facturadetalle> findAllByIdfactura(Long aLong);
}
