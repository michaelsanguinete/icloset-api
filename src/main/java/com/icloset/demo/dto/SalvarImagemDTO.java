package com.icloset.demo.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.Map;

@Data
public class SalvarImagemDTO {

    private String email;
    private Map<String, String> imagem;
}
