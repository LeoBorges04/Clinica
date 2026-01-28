package com.Clinica.Cliniica.especialidade;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_especialidade")
@Data
public class EspecialidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = false)
    private Boolean ativo = true;
}
