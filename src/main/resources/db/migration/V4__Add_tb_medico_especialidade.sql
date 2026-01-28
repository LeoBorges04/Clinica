CREATE TABLE tb_medico_especialidade (
     medico_id BIGINT NOT NULL,
     especialidade_id BIGINT NOT NULL,

     PRIMARY KEY (medico_id, especialidade_id),

     CONSTRAINT fk_medico_especialidade_medico
         FOREIGN KEY (medico_id)
             REFERENCES tb_medico (id),

     CONSTRAINT fk_medico_especialidade_especialidade
         FOREIGN KEY (especialidade_id)
             REFERENCES tb_especialidade (id)
);