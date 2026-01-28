package com.Clinica.Cliniica.medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    List<MedicoEntity> findAllByAtivoTrue();
}
