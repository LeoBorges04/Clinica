package com.example.Clinica.paciente.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class PacienteRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotBlank(message = "Telefone é obrigatório")

    @Pattern(
            regexp = "\\d{10,11}",
            message = "Telefone deve conter 10 ou 11 dígitos numéricos"
    )

    private String telefone;
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    @NotBlank(message = "Sexo é obrigatório")
    private String sexo;
    @NotBlank(message = "Endereço é obrigátorio")
    private String endereco;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;
}
