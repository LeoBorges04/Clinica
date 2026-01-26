package com.Clinica.Cliniica.paciente;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_paciente")
@Data
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String endereco;
    @Column(unique = true)
    private String email;
    private Boolean ativo;
    private String telefone;
    private LocalDateTime dataCadastro;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

}
