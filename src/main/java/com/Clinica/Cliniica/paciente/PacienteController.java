package com.Clinica.Cliniica.paciente;

import com.Clinica.Cliniica.paciente.dto.PacientePatchDto;
import com.Clinica.Cliniica.paciente.dto.PacienteRequestDto;
import com.Clinica.Cliniica.paciente.dto.PacienteResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    @PostMapping("/paciente")
    public ResponseEntity<PacienteResponseDto> criarPaciente(@Valid @RequestBody PacienteRequestDto dto){
        PacienteResponseDto paciente = pacienteService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
     }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponseDto> listarPaciente(@PathVariable Long id){
        PacienteResponseDto paciente =  pacienteService.listar(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(paciente);
    }

    @GetMapping("/paciente/")
    public ResponseEntity<List<PacienteResponseDto>> listarTodos(){
        List<PacienteResponseDto> pacientes = pacienteService.listarTodos();
        return ResponseEntity.ok(pacientes);
    }

    @PatchMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody PacientePatchDto paciente){
        PacienteResponseDto dto = pacienteService.atualizarParcial(id,paciente);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/paciente/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
