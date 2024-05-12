package com.icloset.demo.controller;

import com.icloset.demo.dto.LoginDTO;
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

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Usuarios usuario) {
        return new ResponseEntity(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity findByEmailAndPassword(@RequestBody LoginDTO loginDTO) {
        return new ResponseEntity(usuarioService.findByEmailAndPassword(loginDTO), HttpStatus.OK);
    }
}
