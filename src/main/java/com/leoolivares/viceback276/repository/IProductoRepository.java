package com.leoolivares.viceback276.repository;

import com.leoolivares.viceback276.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto,Long> {

    List<Producto> findAllByEstatus(Boolean aBoolean);
}
