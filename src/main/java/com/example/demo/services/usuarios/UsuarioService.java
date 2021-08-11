package com.example.demo.services.usuarios;

import com.example.demo.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario addUsuario(Usuario usuario);
    Optional<Usuario> attUsuario(String nome, String email, int id);
    Optional<Usuario> updateUsuario(Usuario usuario);
    Optional<Usuario> findUsuario(int id);
    void deleteUsuario(int id);
}