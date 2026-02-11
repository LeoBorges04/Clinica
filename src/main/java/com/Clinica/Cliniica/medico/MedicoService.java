package com.Clinica.Cliniica.medico;

import com.Clinica.Cliniica.medico.dto.MedicoMapper;
import com.Clinica.Cliniica.medico.dto.MedicoPatchDto;
import com.Clinica.Cliniica.medico.dto.MedicoRequestDto;
import com.Clinica.Cliniica.medico.dto.MedicoResponseDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MedicoService {
    private final MedicoMapper medicoMapper;
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoMapper medicoMapper, MedicoRepository medicoRepository){
        this.medicoMapper = medicoMapper;
        this.medicoRepository = medicoRepository;
    }

    public MedicoEntity buscarMedicoAtivo(Long id){
        MedicoEntity medico = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        if(!medico.getAtivo()){
            throw new IllegalStateException("Médico inativo");

        }
        return medico;
    }

    //Cadastra
    @Transactional
    public MedicoResponseDto cadastrar(MedicoRequestDto dto){
        MedicoEntity medico = medicoMapper.map(dto);
        medico.setAtivo(true);
        medico.setData_cadastro(LocalDateTime.now());
        MedicoEntity salvo = medicoRepository.save(medico);
        return medicoMapper.map(salvo);
    }
    //Lista todas
    public List<MedicoResponseDto> listarTodos(){
        return medicoRepository.findAllByAtivoTrue().stream().map(medicoMapper:: map).toList();
    }
    //Lista por id
    public MedicoResponseDto listar(Long id){
       MedicoEntity medico = buscarMedicoAtivo(id);
       return medicoMapper.map(medico);
    }
    //Soft delete
    @Transactional
    public void deletar(Long id){
        MedicoEntity medico = buscarMedicoAtivo(id);
        medico.setAtivo(false);
    }
    //Reativar
    @Transactional
    public MedicoResponseDto reativar(Long id){
        MedicoEntity medico = medicoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Médico não encontrado"));
        if(medico.getAtivo()){
           throw  new IllegalStateException("Médico já está ativo");
        }
        medico.setAtivo(true);
        return medicoMapper.map(medico);
    }
    //Atualizar parcial
    @Transactional
    public MedicoResponseDto atualizar(Long id, MedicoPatchDto dto){
        MedicoEntity medico = buscarMedicoAtivo(id);
        if(dto.getCrm() != null){
            medico.setCrm(dto.getCrm());
        }

        if(dto.getEmail() != null){
            medico.setEmail(dto.getEmail());
        }

        if(dto.getCpf()!= null){
            medico.setCpf(dto.getCpf());
        }

        if(dto.getNome()!= null){
            medico.setNome(dto.getNome());
        }

        if(dto.getData_nascimento()!= null){
            medico.setData_nascimento(dto.getData_nascimento());
        }


        if(dto.getTelefone()!=null){
            medico.setTelefone(dto.getTelefone());
        }

        return medicoMapper.map(medico);
    }
}
