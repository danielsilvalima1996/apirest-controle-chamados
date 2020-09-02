CREATE TABLE IF NOT EXISTS status_chamado(
	id BIGINT AUTO_INCREMENT NOT NULL,
	ativo BIT(1) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	cor VARCHAR(25) NOT NULL,
	criado DATETIME NOT NULL,
	modificado DATETIME NOT NULL,
	criado_por VARCHAR(255) NOT NULL,
	modificado_por VARCHAR(255) NOT NULL,
	CONSTRAINT PK_status_chamado_id PRIMARY KEY (id),
	CONSTRAINT UC_status_chamado_descricao UNIQUE (descricao)
);