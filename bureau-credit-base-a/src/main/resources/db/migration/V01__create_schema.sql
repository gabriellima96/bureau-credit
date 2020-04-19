CREATE TABLE pessoa  (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE endereco  (
	pessoa_id BIGINT(20) UNIQUE,
	logradouro VARCHAR(255),
	bairro VARCHAR(255),
	localidade VARCHAR(255),
	uf CHAR(2),
	complemento VARCHAR(255),
	cep VARCHAR(9),
	numero VARCHAR(100),
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE divida  (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	pessoa_id BIGINT(20),
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(11, 2) NOT NULL,
    data_vencimento DATE,
    status ENUM('PENDENTE', 'NEGOCIACAO') NOT NULL DEFAULT 'PENDENTE',
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
