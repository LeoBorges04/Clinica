package com.example.Clinica.paciente.dto;

import com.example.Clinica.paciente.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {
    public PacienteEntity map(PacienteRequestDTO dto){
        PacienteEntity paciente = new PacienteEntity();
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        paciente.setEndereco(dto.getEndereco());
        paciente.setNome(dto.getNome());
        paciente.setTelefone(dto.getTelefone());
        paciente.setSexo(dto.getSexo());
        paciente.setDataNascimento(dto.getDataNascimento());
        return paciente;

    }

    public  PacienteResponseDTO map(PacienteEntity paciente){
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setCpf(paciente.getCpf());
        dto.setEmail(paciente.getEmail());
        dto.setEndereco(paciente.getEndereco());
        dto.setNome(paciente.getNome());
        dto.setTelefone(paciente.getTelefone());
        dto.setSexo(paciente.getSexo());
        dto.setId(paciente.getId());
        dto.setDataCadastro(paciente.getDataCadastro());
        return dto;
    }

}
