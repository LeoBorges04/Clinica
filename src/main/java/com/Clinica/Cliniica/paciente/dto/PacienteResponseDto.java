package com.Clinica.Cliniica.paciente.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PacienteResponseDto {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private LocalDate data_nascimento;
    private LocalDateTime data_cadastro;
    private String email;
    private String cpf;

}
