package com.example.Clinica.medico;

public enum EspecialidadeMedica {
    CARDIOLOGIA("Cardiologia"),
    ORTOPEDIA("Ortopedia"),
    DERMATOLOGIA("Dermatologia"),
    PEDIATRIA("Pediatria"),
    GINECOLOGIA("Ginecologia"),
    CLINICA_GERAL("Clínica Geral");

    private final String descricao;

    EspecialidadeMedica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}