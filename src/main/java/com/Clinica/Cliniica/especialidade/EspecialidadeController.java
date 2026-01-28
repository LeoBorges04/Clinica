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
    @PostMapping("/especialidade")
    public ResponseEntity<EspecialidadeResponseDto> cadastrar(@Valid @RequestBody EspecialidadeRequestDto dto){
       EspecialidadeResponseDto especialidade =  especialidadeService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(especialidade);
    }

    @GetMapping("/especialidade/{id}")
    public ResponseEntity<EspecialidadeResponseDto> listarPorId(@PathVariable Long id){
        EspecialidadeResponseDto especialidade = especialidadeService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @GetMapping("/especialidade")
    public ResponseEntity<List<EspecialidadeResponseDto>> listarTodos(){
        List<EspecialidadeResponseDto> especialidade = especialidadeService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @PatchMapping("/especialidade/{id}")
    public ResponseEntity<EspecialidadeResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody EspecialidadeRequestDto dto){
        EspecialidadeResponseDto especialidade = especialidadeService.atualizar(id,dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);
    }

    @PatchMapping("/especialidade/reativar/{id}")
    public ResponseEntity<EspecialidadeResponseDto> reativar(@PathVariable Long id){
        EspecialidadeResponseDto especialidade = especialidadeService.reativar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(especialidade);    }

    @DeleteMapping("/especialidade/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        especialidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
