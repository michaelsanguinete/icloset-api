package com.icloset.demo;

import com.icloset.demo.entity.Usuarios;
import com.icloset.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity save(@RequestBody Usuarios usuario) {
        return new ResponseEntity(usuarioService.save(usuario), HttpStatus.CREATED);
    }
}
