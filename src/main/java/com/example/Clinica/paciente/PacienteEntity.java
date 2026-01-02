package com.example.Clinica.paciente;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_paciente")
@Data
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    @Column(unique = true)
    private String email;
    private String sexo;
    private String endereco;
    private Boolean ativo;
    private LocalDateTime dataCadastro;


}
