package com.icloset.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
@Data
public class Usuarios {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
