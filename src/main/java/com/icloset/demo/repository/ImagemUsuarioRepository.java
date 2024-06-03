package com.icloset.demo.repository;

import com.icloset.demo.entity.ImagemUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ImagemUsuarioRepository extends MongoRepository<ImagemUsuario, String> {

    @Query(value = "{ 'usuario.$id' : { $oid: ?0 } }", sort = "{ 'dataCadastro' : -1 }")
    List<ImagemUsuario> findTopByUsuarioIdOrderByDataCadastroDesc(String usuarioId);
}
