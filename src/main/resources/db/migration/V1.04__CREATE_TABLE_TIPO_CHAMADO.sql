CREATE TABLE IF NOT EXISTS tipo_chamado (
	id BIGINT AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	ativo BIT(1) NOT NULL,
	criado DATETIME NOT NULL,
	modificado DATETIME NOT NULL,
	criado_por VARCHAR(255) NOT NULL,
	modificado_por VARCHAR(255) NOT NULL,
	CONSTRAINT PK_tipo_chamado_id PRIMARY KEY (id),
	CONSTRAINT UC_tipo_chamado_descricao UNIQUE (descricao)
);