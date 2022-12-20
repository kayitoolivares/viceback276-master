package com.leoolivares.viceback276.service.Implementation;

import com.leoolivares.viceback276.entity.Usuario;
import com.leoolivares.viceback276.repository.IUsuarioRepository;
import com.leoolivares.viceback276.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UsuarioImplementation implements IUsuarioService {
    @Autowired
    IUsuarioRepository repository;
    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> getById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Boolean delete(Long aLong) {
        Optional<Usuario> usuario=getById(aLong);
        if (usuario.isPresent()){
            Usuario usuario1=usuario.get();
            usuario1.setEstatus(false);
            repository.delete(usuario1);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> getAllActivos() {
        return repository.findAllByEstatus(true);
    }
}
