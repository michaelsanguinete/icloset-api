package com.icloset.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;


@Document(collection = "imagemUsuario")
@Data
public class ImagemUsuario {

    @Id
    private String id;
    private Map<String, String> imagemBase64;
    private Date dataCadastro = new Date();

    @DBRef
    private Usuarios usuario;
}
