package com.Clinica.Cliniica.paciente;

import com.Clinica.Cliniica.paciente.dto.PacienteMapper;
import com.Clinica.Cliniica.paciente.dto.PacientePatchDto;
import com.Clinica.Cliniica.paciente.dto.PacienteRequestDto;
import com.Clinica.Cliniica.paciente.dto.PacienteResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper){
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }
    //Cadastra paciente
    @Transactional
    public PacienteResponseDto cadastrar(PacienteRequestDto dto){
        PacienteEntity paciente = pacienteMapper.map(dto);
        paciente.setData_cadastro(LocalDateTime.now());
        paciente.setAtivo(true);
        PacienteEntity pacSalvo = pacienteRepository.save(paciente);
        return pacienteMapper.map(pacSalvo);
    }

    //Retorna paciente
    public PacienteResponseDto listar(Long id){
         PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        if(!paciente.getAtivo()){
            throw new IllegalStateException("Paciente está inativo");
        }
        return pacienteMapper.map(paciente);
    }
    //Retorna lista de pacientes
    public List<PacienteResponseDto> listarTodos(){
        return pacienteRepository.findAllByAtivoTrue().stream().map(pacienteMapper::map).toList();
    }

    //Atualiza paciente
    @Transactional
    public PacienteResponseDto atualizarParcial(Long id, PacientePatchDto dto){
        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        if(!paciente.getAtivo()){
            throw new IllegalStateException("Paciente está inativo");
        }

        if(dto.getCpf() != null){
            paciente.setCpf(dto.getCpf());
        }

        if(dto.getData_nascimento() != null){
            paciente.setData_nascimento(dto.getData_nascimento());
        }

        if(dto.getEmail() != null){
            paciente.setEmail(dto.getEmail());
        }
        if(dto.getEndereco() != null){
            paciente.setEndereco(dto.getEndereco());
        }

        if(dto.getNome() != null){
            paciente.setNome(dto.getNome());
        }

        if(dto.getTelefone() != null){
            paciente.setTelefone(dto.getTelefone());
        }

        return pacienteMapper.map(paciente);

    }

    //Reativa paciente
    @Transactional
    public PacienteResponseDto reativar(Long id){
        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        if(paciente.getAtivo()){
            throw new IllegalStateException("Paciente já está ativo");
        }
        paciente.setAtivo(true);
        return pacienteMapper.map(paciente);

    }
    //Desativa paciente (soft delete)
    @Transactional
    public void deletar(Long id){
        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        if(!paciente.getAtivo()){
            throw new IllegalStateException("Paciente já está inativo");
        }
        paciente.setAtivo(false);
    }
}
