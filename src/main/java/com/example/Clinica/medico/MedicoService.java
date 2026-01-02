package com.example.Clinica.medico;

import com.example.Clinica.medico.dto.MedicoMapper;
import com.example.Clinica.medico.dto.MedicoRequestDTO;
import com.example.Clinica.medico.dto.MedicoResponseDTO;
import com.example.Clinica.paciente.PacienteEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MedicoService {
    private final MedicoMapper medicoMapper;
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoMapper medicoMapper, MedicoRepository medicoRepository) {
        this.medicoMapper = medicoMapper;
        this.medicoRepository = medicoRepository;
    }
    //Cadastrar medico
    public MedicoResponseDTO cadastrar(MedicoRequestDTO dto){
        MedicoEntity medico = medicoMapper.toEntity(dto);
        medico.setAtivo(true);
        //tem que fazer a data de cadastro do medico nas classes dps
        MedicoEntity medicoSalvo = medicoRepository.save(medico);

        return medicoMapper.toResponse(medicoSalvo);
    }

    //Atualizar


    //Deletar
    @Transactional
    public void deletar(Long id){

        MedicoEntity medico = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        medico.setAtivo(false);
    }

    //Ativar
    @Transactional
    public void ativar(Long id){
        MedicoEntity medico = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        if(medico.getAtivo()){
            throw new IllegalStateException("Médico já está ativo");
        }

        medico.setAtivo(true);

    }

    //Listar todos
    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepository.findAllByAtivoTrue()
                .stream()
                .map(medicoMapper::toResponse)
                .toList();
    }

    //Exibir por id
    public MedicoResponseDTO listar(Long id){
        MedicoEntity medico = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        if(!medico.isAtivo()){
            throw new IllegalStateException("Médico inativo");
        }
        return medicoMapper.toResponse(medico);
    }
}
