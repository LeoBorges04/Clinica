package com.example.Clinica.medico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="tb_medico")
@Data
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    @Column(name = "uf_crm", length = 2)
    private UF ufCrm;
    private String telefone;
    private boolean ativo;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private Set<EspecialidadeMedica> especialidades;

}
