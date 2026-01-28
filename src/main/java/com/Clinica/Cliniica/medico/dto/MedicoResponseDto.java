package com.Clinica.Cliniica.medico.dto;

import com.Clinica.Cliniica.especialidade.EspecialidadeEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class MedicoResponseDto {

    private Long id;
    private String nome;
    private String telefone;
    private String crm;
    private String cpf;
    private String email;
    private Boolean ativo;
    private LocalDate data_nascimento;
    private LocalDateTime data_cadastro;


}
