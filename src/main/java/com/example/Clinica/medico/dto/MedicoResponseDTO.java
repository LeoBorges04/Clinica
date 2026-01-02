package com.example.Clinica.medico.dto;

import com.example.Clinica.medico.EspecialidadeMedica;
import com.example.Clinica.medico.UF;
import lombok.Data;

import java.util.Set;
@Data
public class MedicoResponseDTO {

    private String email;
    private String crm;
    private String telefone;
    private String cpf;
    private String nome;
    private UF ufCrm;
    private Set<EspecialidadeMedica> especialidades;
    private Long id;


}
