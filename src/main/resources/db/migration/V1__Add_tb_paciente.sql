CREATE TABLE tb_paciente(
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            cpf VARCHAR(14) NOT NULL UNIQUE,
                            email VARCHAR(255) NOT NULL UNIQUE,
                            telefone VARCHAR(20) NOT NULL,
                            data_nascimento DATE NOT NULL,
                            data_cadastro DATETIME,
                            endereco VARCHAR(255) NOT NULL,
                            ativo BOOLEAN NOT NULL DEFAULT TRUE
);