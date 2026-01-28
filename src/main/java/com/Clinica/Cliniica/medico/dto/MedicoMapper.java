package com.Clinica.Cliniica.medico.dto;

import com.Clinica.Cliniica.medico.MedicoEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public MedicoEntity map(MedicoRequestDto dto){
        MedicoEntity medico = new MedicoEntity();
        medico.setEmail(dto.getEmail());
        medico.setCpf(dto.getCpf());
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setTelefone(dto.getTelefone());
        medico.setData_nascimento(dto.getData_nascimento());

        return medico;
    }

    public MedicoResponseDto map(MedicoEntity medico){
        MedicoResponseDto dto = new MedicoResponseDto();
        dto.setId(medico.getId());
        dto.setCrm(medico.getCrm());

        dto.setData_nascimento(medico.getData_nascimento());
        dto.setData_cadastro(medico.getData_cadastro());
        dto.setNome(medico.getNome());
        dto.setTelefone(medico.getTelefone());
        dto.setCpf(medico.getCpf());

        return dto;
    }
}
