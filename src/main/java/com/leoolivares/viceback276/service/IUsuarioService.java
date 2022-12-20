package com.leoolivares.viceback276.service;

import com.leoolivares.viceback276.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IUsuarioService {

    List<Usuario> getAll();
    Optional<Usuario> getById(Long aLong);
    Usuario save(Usuario usuario);
    Boolean delete(Long aLong);
    List<Usuario> getAllActivos();

}
