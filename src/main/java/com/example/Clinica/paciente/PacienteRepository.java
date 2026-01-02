package com.example.Clinica.paciente;

import com.example.Clinica.medico.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
    List<PacienteEntity> findAllByAtivoTrue();
}
