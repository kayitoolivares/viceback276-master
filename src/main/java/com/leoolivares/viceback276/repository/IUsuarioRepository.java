package com.leoolivares.viceback276.repository;

import com.leoolivares.viceback276.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    List<Usuario> findAllByEstatus(Boolean aBoolean);
}
