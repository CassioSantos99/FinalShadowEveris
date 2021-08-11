package com.example.demo.services.usuarios;

import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private List<Usuario> usuarios = new ArrayList();

    @Override
    public List<Usuario> getUsuarios() { return usuarios; }

    @Override
    public Usuario addUsuario(Usuario usuario) {
        usuario.setId((int) (usuarios.stream().count() + 1));
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> attUsuario(String nome, String email, int id) {
        Optional<Usuario> existingUsuario = usuarios.stream().filter(f -> f.getId() == id)
                .collect(Collectors.toList()).stream().findFirst();
        if (existingUsuario.isPresent()) {
            existingUsuario.get().setNome(nome);
            existingUsuario.get().setEmail(email);
        }
        return existingUsuario;
    }

    @Override
    public Optional<Usuario> updateUsuario(Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarios.stream().filter(f -> f.getId() == usuario.getId())
                .collect(Collectors.toList()).stream().findFirst();

        if(existingUsuario.isPresent()){
            int index = usuarios.indexOf(existingUsuario.get());
            usuarios.set(index, usuario);
            existingUsuario = Optional.of(usuario);
        }
        return existingUsuario;
    }

    @Override
    public Optional<Usuario> findUsuario(int id) {
        Optional<Usuario> existingUsuario = usuarios.stream().filter(f -> f.getId() == id)
                .collect(Collectors.toList()).stream().findFirst();
        return existingUsuario;
    }

    @Override
    public void deleteUsuario(int id) {
            usuarios = usuarios.stream().filter(f -> f.getId() != id)
                .collect(Collectors.toList());
    }
}