package com.Clinica.Cliniica.medico.dto;

import com.Clinica.Cliniica.especialidade.EspecialidadeEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Set;

@Data
public class MedicoRequestDto {
    @NotNull(message = "Nome é obrigatório")
    private String nome;
    @NotNull(message = "CRM é obrigatório")
    private String crm;
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotNull(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    @NotNull(message = "Telefone é obrigatório")
    @Pattern(
            regexp = "\\d{10,11}",
            message = "Telefone deve conter 10 ou 11 dígitos numéricos"
    )
    private String telefone;
    @NotNull(message = "Data de nascimento é obrigatório")
    @Past(message = "A data de nascimento deve estar no passado")

    private LocalDate data_nascimento;


}
