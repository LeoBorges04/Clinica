package com.Clinica.Cliniica.especialidade;

import com.Clinica.Cliniica.especialidade.dto.EspecialidadeMapper;
import com.Clinica.Cliniica.especialidade.dto.EspecialidadeRequestDto;
import com.Clinica.Cliniica.especialidade.dto.EspecialidadeResponseDto;
import com.Clinica.Cliniica.medico.MedicoEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EspecialidadeService {
    EspecialidadeRepository especialidadeRepository;
    EspecialidadeMapper especialidadeMapper;
    public EspecialidadeService(EspecialidadeRepository especialidadeRepository, EspecialidadeMapper especialidadeMapper){
        this.especialidadeMapper = especialidadeMapper;
        this.especialidadeRepository = especialidadeRepository;
    }
    public EspecialidadeResponseDto cadastrar(EspecialidadeRequestDto dto){
        EspecialidadeEntity especialidade = new EspecialidadeEntity();
        especialidade.setNome(dto.getNome());

        EspecialidadeEntity salvo = especialidadeRepository.save(especialidade);

        return especialidadeMapper.map(salvo);
    }
    public EspecialidadeEntity buscarEspecialidadeAtiva(Long id){
        EspecialidadeEntity especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada"));
        if(!especialidade.getAtivo()){
            throw new IllegalStateException("Especialidade inativa");

        }
        return especialidade;
    }



    public List<EspecialidadeResponseDto> listarTodos(){
        return especialidadeRepository.findAllByAtivoTrue().stream().map(especialidadeMapper:: map).toList();
    }

    public EspecialidadeResponseDto buscarPorId(Long id){
        EspecialidadeEntity especialidade = buscarEspecialidadeAtiva(id);
        return especialidadeMapper.map(especialidade);
    }

    @Transactional
    public EspecialidadeResponseDto atualizar(Long id, EspecialidadeRequestDto dto){
        EspecialidadeEntity especialidade = buscarEspecialidadeAtiva(id);

        if(dto.getNome() != null){
            especialidade.setNome(dto.getNome());
        }

        return especialidadeMapper.map(especialidade);

    }

    @Transactional
    public void deletar(Long id){
        EspecialidadeEntity especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada"));
        if(!especialidade.getAtivo()){
            new IllegalStateException("Especialidade já está inativa");
        }

        especialidade.setAtivo(false);
    }

    @Transactional
    public EspecialidadeResponseDto reativar(Long id){
        EspecialidadeEntity especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada"));
        if(especialidade.getAtivo()){
            new IllegalStateException("Especialidade já está ativa");
        }

        especialidade.setAtivo(true);
        return especialidadeMapper.map(especialidade);
    }
}
