package com.Clinica.Cliniica.medico;

import com.Clinica.Cliniica.medico.dto.MedicoPatchDto;
import com.Clinica.Cliniica.medico.dto.MedicoRequestDto;
import com.Clinica.Cliniica.medico.dto.MedicoResponseDto;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MedicoController {
    private MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @PostMapping("/medicos")
    public ResponseEntity<MedicoResponseDto> cadastrar(@Valid @RequestBody MedicoRequestDto dto){
        MedicoResponseDto medico = medicoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medico);
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<MedicoResponseDto>> listarTodos(){
        List<MedicoResponseDto> medico = medicoService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK)
                .body(medico);
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<MedicoResponseDto> listarPorId(@PathVariable Long id){
        MedicoResponseDto medico = medicoService.listar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(medico);
    }

    @PatchMapping("/medicos/{id}")
    public ResponseEntity<MedicoResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody MedicoPatchDto dto){
        MedicoResponseDto medico = medicoService.atualizar(id, dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(medico);
    }

    @PatchMapping("/medicos/{id}/reativar")
    public ResponseEntity<MedicoResponseDto> reativar(@PathVariable Long id){
        MedicoResponseDto medico = medicoService.reativar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(medico);
    }
    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
