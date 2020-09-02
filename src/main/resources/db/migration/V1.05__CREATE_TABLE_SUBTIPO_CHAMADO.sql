CREATE TABLE IF NOT EXISTS subtipo_chamado(
	id BIGINT AUTO_INCREMENT NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	ativo BIT(1) NOT NULL,
	criado DATETIME NOT NULL,
	modificado DATETIME NOT NULL,
	criado_por VARCHAR(255) NOT NULL,
	modificado_por VARCHAR(255) NOT NULL,
	id_tipo_chamado BIGINT NOT NULL,
	CONSTRAINT PK_subtipo_chamado_id PRIMARY KEY (id),
	CONSTRAINT FK_subtipo_chamado_id_tipo_chamado FOREIGN KEY (id_tipo_chamado) REFERENCES tipo_chamado (id)
);