Create table tb_paciente(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf  VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    sexo VARCHAR(20) NOT NULL,
    endereco VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE,
    data_cadastro DATETIME ,
    data_nascimento DATE NOT NULL
);