package com.icloset.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.icloset.demo.dto.SalvarImagemDTO;
import com.icloset.demo.entity.ImagemUsuario;
import com.icloset.demo.service.ImagemUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/imagemUsuario")
@RequiredArgsConstructor
public class ImagemUsuarioController {

    private final ImagemUsuarioService imagemUsuarioService;

    @PostMapping
    public ResponseEntity<ImagemUsuario> save(@RequestBody SalvarImagemDTO salvarImagemDTO) {
        return ResponseEntity.ok(imagemUsuarioService.save(salvarImagemDTO));
    }

    @GetMapping("/{usuarioEmail}")
    public ResponseEntity<Map<String, String>> findByUsuarioEmail(@PathVariable String usuarioEmail) {
        Map<String, String> imagemUsuario = imagemUsuarioService.findByUsuarioEmail(usuarioEmail);
        if (imagemUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imagemUsuario);
    }
}
