package com.icloset.demo.service;

import com.icloset.demo.dto.LoginDTO;
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

    public Usuarios findByEmailAndPassword(LoginDTO loginDTO) {
        Usuarios usuarios = usuarioRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (usuarios == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuarios;
    }
}
