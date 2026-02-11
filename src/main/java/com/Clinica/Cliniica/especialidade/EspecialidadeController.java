package com.Clinica.Cliniica.especialidade;

import com.Clinica.Cliniica.especialidade.dto.EspecialidadeRequestDto;
import com.Clinica.Cliniica.especialidade.dto.EspecialidadeResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EspecialidadeController {
    private EspecialidadeService especialidadeService;
    public EspecialidadeController(EspecialidadeService especialidadeService){
        this.especialidadeService = especialidadeService;
    }
    @PostMapping("/especialidades")
    public ResponseEntity<EspecialidadeResponseDto> cadastrar(@Valid @RequestBody EspecialidadeRequestDto dto){
       EspecialidadeResponseDto especialidade =  especialidadeService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(especialidade);
    }

    @GetMapping("/especialidades/{id}")
    public ResponseEntity<EspecialidadeResponseDto> listarPorId(@PathVariable Long id){
        EspecialidadeResponseDto especialidade = especialidadeService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @GetMapping("/especialidades")
    public ResponseEntity<List<EspecialidadeResponseDto>> listarTodos(){
        List<EspecialidadeResponseDto> especialidade = especialidadeService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @PatchMapping("/especialidades/{id}")
    public ResponseEntity<EspecialidadeResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody EspecialidadeRequestDto dto){
        EspecialidadeResponseDto especialidade = especialidadeService.atualizar(id,dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @PatchMapping("/especialidades/{id}/reativar")
    public ResponseEntity<EspecialidadeResponseDto> reativar(@PathVariable Long id){
        EspecialidadeResponseDto especialidade = especialidadeService.reativar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);    }

    @DeleteMapping("/especialidades/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        especialidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
