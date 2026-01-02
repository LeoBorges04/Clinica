package com.example.Clinica.paciente;

import com.example.Clinica.paciente.dto.PacienteRequestDTO;
import com.example.Clinica.paciente.dto.PacienteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    //Criar Cadastro
    @PostMapping("/")
    public ResponseEntity<PacienteResponseDTO> criarCadastro(@Valid @RequestBody PacienteRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastrar(dto));
    }
    //Listar todos os pacientes ativos
    @GetMapping("/")
    public ResponseEntity<List<PacienteResponseDTO>> listarTodos(){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }
    //Listar paciente
    @GetMapping("/{id}")
    public ResponseEntity <PacienteResponseDTO> listar(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.listar(id));
    }

    //Deletar cadastro (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //Ativar cadastro do paciente
    @PatchMapping("/{id}/ativar")
    public ResponseEntity<Void> ativar(@PathVariable  Long id){
        pacienteService.ativar(id);
        return ResponseEntity.noContent().build();
    }

    //Atualizar cadastro do paciente
    @PatchMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO dto){
        return ResponseEntity.ok(pacienteService.atualizar( id, dto));
    }
}
