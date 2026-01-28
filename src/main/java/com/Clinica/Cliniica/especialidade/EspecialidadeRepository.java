package com.Clinica.Cliniica.especialidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EspecialidadeRepository extends JpaRepository<EspecialidadeEntity, Long> {
    List<EspecialidadeEntity> findAllByAtivoTrue();
}
