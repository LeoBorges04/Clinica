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
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String endereco;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean ativo;
    @Column(nullable = false)
    private String telefone;
    private LocalDateTime data_cadastro;
    @Column(nullable = false)
    private LocalDate data_nascimento;

}
