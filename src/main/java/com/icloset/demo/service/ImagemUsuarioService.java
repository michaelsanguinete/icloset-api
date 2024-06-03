package com.icloset.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.icloset.demo.dto.SalvarImagemDTO;
import com.icloset.demo.entity.ImagemUsuario;
import com.icloset.demo.entity.Usuarios;
import com.icloset.demo.repository.ImagemUsuarioRepository;
import com.icloset.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImagemUsuarioService {

    private final ImagemUsuarioRepository imagemUsuarioRepository;
    private final UsuarioRepository usuarioRepository;

    public ImagemUsuario save(SalvarImagemDTO salvarImagemDTO) {
        Usuarios usuarios = usuarioRepository.findByEmail(salvarImagemDTO.getEmail());
        if (usuarios == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        ImagemUsuario imagemUsuario = new ImagemUsuario();
        imagemUsuario.setUsuario(usuarios);
        imagemUsuario.setImagemBase64(salvarImagemDTO.getImagem());
        return imagemUsuarioRepository.save(imagemUsuario);
    }

    public Map<String, String> findByUsuarioEmail(String usuarioEmail) {
        Usuarios usuario = usuarioRepository.findByEmail(usuarioEmail);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        ImagemUsuario imagemUsuario = imagemUsuarioRepository.findTopByUsuarioIdOrderByDataCadastroDesc(usuario.getId()).get(0);
        return imagemUsuario.getImagemBase64();
    }
}
