package com.example.Clinica.medico.dto;

import com.example.Clinica.medico.EspecialidadeMedica;
import com.example.Clinica.medico.UF;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;
@Data
public class MedicoRequestDTO {
    @NotBlank
    @Email(message = "Email é obrigatório")
    private String email;

    @NotBlank
    @Size(max = 20, message = "O CRM deve ter no máximo 20 caracteres")
    private String crm;

    @NotBlank
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve ter 10 ou 11 dígitos, apenas números")
    private String telefone;

    @NotBlank
    @CPF(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "A UF do CRM é obrigatória")
    private UF ufCrm;

    @NotEmpty(message = "O médico deve ter pelo menos uma especialidade")
    private Set<EspecialidadeMedica> especialidades;

}
