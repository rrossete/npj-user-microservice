package br.ufjf.microservice.service;

import br.ufjf.microservice.domain.Usuario;
import br.ufjf.microservice.repository.UsuarioRepository;
import br.ufjf.microservice.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public Usuario find(Integer id) {

        Optional<Usuario> usuario = repository.findById(id);


        return usuario.orElseThrow(() -> new ObjectNotFoundException(
                "Usuário com Id: " + id + " não encontrado, Tipo: " + Usuario.class.getName()
        ));
    }

    public Usuario insert(Usuario usuario) {
        usuario.setId(null);
        return repository.save(usuario);
    }

    public Usuario update(Usuario usuario) {

        find(usuario.getId());

        return repository.save(usuario);
    }

    public void delete(Integer id) {

        find(id);
        repository.deleteById(id);
    }

    public List<Usuario> findAll() {

        return repository.findAll();
    }


}
