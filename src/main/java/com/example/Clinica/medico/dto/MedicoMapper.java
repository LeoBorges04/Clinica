package com.example.Clinica.medico.dto;

import com.example.Clinica.medico.MedicoEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {
    public MedicoEntity toEntity(MedicoRequestDTO dto){
        MedicoEntity medico = new MedicoEntity();
        medico.setCpf(dto.getCpf());
        medico.setEmail(dto.getEmail());
        medico.setCrm(dto.getCrm());
        medico.setUfCrm(dto.getUfCrm());
        medico.setTelefone(dto.getTelefone());
        medico.setNome(dto.getNome());
        medico.setEspecialidades(dto.getEspecialidades());

        return medico;
    }

    public MedicoResponseDTO toResponse(MedicoEntity medico){
        MedicoResponseDTO dto = new MedicoResponseDTO();
        dto.setCrm(medico.getCrm());
        dto.setId(medico.getId());
        dto.setEspecialidades(medico.getEspecialidades());
        dto.setUfCrm(medico.getUfCrm());
        dto.setEmail(medico.getEmail());
        dto.setTelefone(medico.getTelefone());
        return dto;
    }
}
