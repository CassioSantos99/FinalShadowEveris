package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.services.usuarios.UsuarioService;
import com.example.demo.services.usuarios.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    @GetMapping("/usuarios")
    public List<Usuario> usuarios(){
        return usuarioService.getUsuarios();
    }

    @PutMapping("/update_usuarios/{id}")
    public Optional<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @PostMapping("/usuarios")
    public Usuario addUsuario( @RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.addUsuario(usuario);
        return savedUsuario;
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity deleteUsuario(@PathVariable int id) {

        usuarioService.deleteUsuario(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
