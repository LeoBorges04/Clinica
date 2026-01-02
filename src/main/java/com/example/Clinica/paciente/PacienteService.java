package com.example.Clinica.paciente;

import com.example.Clinica.paciente.dto.PacienteMapper;
import com.example.Clinica.paciente.dto.PacienteRequestDTO;
import com.example.Clinica.paciente.dto.PacienteResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {

    private final PacienteMapper pacienteMapper;
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteMapper pacienteMapper, PacienteRepository pacienteRepository) {
        this.pacienteMapper = pacienteMapper;
        this.pacienteRepository = pacienteRepository;
    }

    //Cadastro de Paciente pelo DTO
    public PacienteResponseDTO cadastrar(PacienteRequestDTO dto){
        PacienteEntity paciente = pacienteMapper.map(dto);
        PacienteEntity pacSalvo = pacienteRepository.save(paciente);

        return pacienteMapper.map(pacSalvo);
    }
    @Transactional
    //Deletar seguro apenas inativando o paciente
    public void deletar(Long id){

        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        paciente.setAtivo(false);
    }

    //Lista um paciente, somente se estiver ativo
    public PacienteResponseDTO listar(Long id){
       PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
       if(!paciente.getAtivo()){
           throw new IllegalStateException("Paciente inativo");
       }
       return pacienteMapper.map(paciente);
    }

    //Listar todos pacientes ativos
    public List<PacienteResponseDTO> listarTodos(){
        return pacienteRepository.findAllByAtivoTrue().stream().map(pacienteMapper:: map).toList();
    }
    @Transactional
    //Ativar cadastro paciente
    public void ativar(Long id){
        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        if(paciente.getAtivo()){
            throw new IllegalStateException("Paciente já está ativo");
        }

        paciente.setAtivo(true);

    }
    //Atualizar cadastro paciente
    @Transactional
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto ){
        PacienteEntity paciente = pacienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        if(dto.getNome() != null){
            paciente.setNome(dto.getNome());
        }
        if(dto.getCpf() != null){
            paciente.setCpf(dto.getCpf());
        }
        if(dto.getEmail() != null){
            paciente.setEmail(dto.getEmail());
        }
        if(dto.getEndereco() != null){
            paciente.setEndereco(dto.getEndereco());
        }
        if(dto.getTelefone() != null){
            paciente.setTelefone(dto.getTelefone());
        }
        if(dto.getSexo() != null){
            paciente.setSexo(dto.getSexo());
        }

        return pacienteMapper.map(paciente);
    }
}
