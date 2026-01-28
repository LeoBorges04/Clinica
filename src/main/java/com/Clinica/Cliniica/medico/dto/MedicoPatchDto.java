package com.Clinica.Cliniica.medico.dto;

import com.Clinica.Cliniica.especialidade.EspecialidadeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
public class MedicoPatchDto {
    private Long id;
    private String nome;
    @Pattern(
            regexp = "\\d{10,11}",
            message = "Telefone deve conter 10 ou 11 dígitos numéricos"
    )
    private String telefone;
    @CPF(message = "CPF inválido")
    private String cpf;
    private String crm;
    @Email(message = "Email inválido")
    private String email;
    private Boolean ativo;
    @Past(message = "A data de nascimento deve estar no passado")
    private LocalDate data_nascimento;
    private LocalDateTime data_cadastro;
}
