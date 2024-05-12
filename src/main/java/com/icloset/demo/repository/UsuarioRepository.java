package com.icloset.demo.repository;

import com.icloset.demo.entity.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuarios, String> {

    Usuarios findByEmailAndPassword(String email, String password);
}
