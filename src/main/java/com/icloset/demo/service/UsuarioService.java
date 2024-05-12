package com.icloset.demo.service;

import com.icloset.demo.entity.Usuarios;
import com.icloset.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuarios save(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }
}
