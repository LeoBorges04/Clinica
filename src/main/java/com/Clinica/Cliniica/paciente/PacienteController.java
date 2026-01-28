package com.Clinica.Cliniica.paciente;

import com.Clinica.Cliniica.paciente.dto.PacientePatchDto;
import com.Clinica.Cliniica.paciente.dto.PacienteRequestDto;
import com.Clinica.Cliniica.paciente.dto.PacienteResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    @PostMapping("/paciente/")
    public PacienteResponseDto criarPaciente(@Valid @RequestBody PacienteRequestDto dto){
        return pacienteService.cadastrar(dto);
    }

    @GetMapping("/paciente/")
    public PacienteResponseDto listarPaciente(@PathVariable Long id){
        return pacienteService.listar(id);
    }

    @GetMapping("/paciente/")
    public List<PacienteResponseDto> listarTodos(){
        return pacienteService.listarTodos();
    }

    @PatchMapping("/paciente/")
    public PacienteResponseDto atualizar(@PathVariable Long id, @RequestBody PacientePatchDto paciente){
        return pacienteService.atualizarParcial(id, paciente);
    }

    @DeleteMapping("/paciente/")
    public void deletar(@PathVariable Long id){
        pacienteService.deletar(id);
    }

}
