package com.Clinica.Cliniica.paciente.dto;

import com.Clinica.Cliniica.paciente.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    public PacienteEntity map(PacienteRequestDto pacienteDto){
        PacienteEntity paciente = new PacienteEntity();
        paciente.setCpf(pacienteDto.getCpf());
        paciente.setData_nascimento(pacienteDto.getData_nascimento());
        paciente.setEmail(pacienteDto.getEmail());
        paciente.setEndereco(pacienteDto.getEndereco());
        paciente.setNome(pacienteDto.getNome());
        paciente.setTelefone(pacienteDto.getTelefone());
        return paciente;
    }

    public  PacienteResponseDto map(PacienteEntity paciente){
        PacienteResponseDto dto = new PacienteResponseDto();
        dto.setCpf(paciente.getCpf());
        dto.setData_cadastro(paciente.getData_cadastro());
        dto.setData_nascimento(paciente.getData_nascimento());
        dto.setNome(paciente.getNome());
        dto.setTelefone(paciente.getTelefone());
        dto.setEmail(paciente.getEmail());
        dto.setEndereco(paciente.getEndereco());
        return dto;
    }
}
