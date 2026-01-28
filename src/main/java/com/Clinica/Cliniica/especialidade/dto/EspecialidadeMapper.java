package com.Clinica.Cliniica.especialidade.dto;

import com.Clinica.Cliniica.especialidade.EspecialidadeEntity;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadeMapper {
    public EspecialidadeEntity map(EspecialidadeRequestDto dto){
        EspecialidadeEntity especialidade = new EspecialidadeEntity();
        especialidade.setNome(dto.getNome());
        return especialidade;
    }


    public EspecialidadeResponseDto map(EspecialidadeEntity especialidade){
        EspecialidadeResponseDto dto = new EspecialidadeResponseDto();
        dto.setNome(especialidade.getNome());
        dto.setAtivo(especialidade.getAtivo());
        dto.setId(especialidade.getId());
        return dto;
    }
}
