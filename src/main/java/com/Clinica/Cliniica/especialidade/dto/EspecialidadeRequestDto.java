package com.Clinica.Cliniica.especialidade.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EspecialidadeRequestDto {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
}
