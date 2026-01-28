package com.Clinica.Cliniica.medico;

import com.Clinica.Cliniica.especialidade.EspecialidadeEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_medico")
@Data
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(unique = true, nullable = false)
    private String crm;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean ativo = true;
    @Column(nullable = false)
    private LocalDate data_nascimento;
    @Column(nullable = false)
    private LocalDateTime data_cadastro;
    @ManyToMany
    @JoinTable(
            name = "tb_medico_especialidade",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private Set<EspecialidadeEntity> especialidades = new HashSet<>();
}
