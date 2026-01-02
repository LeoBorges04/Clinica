package com.example.Clinica.paciente.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data1
public class PacienteResponseDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private String email;

    private String sexo;

    private String endereco;
    private LocalDateTime dataCadastro;
    private Long id;
    private LocalDate dataNascimento;


}
