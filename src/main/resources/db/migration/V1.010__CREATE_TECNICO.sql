CREATE TABLE IF NOT EXISTS tecnico (
	id BIGINT AUTO_INCREMENT NOT NULL,
	ativo BIT(1) NOT NULL,
	id_usuario BIGINT NOT NULL,
	criado DATETIME NOT NULL,
	modificado DATETIME NOT NULL,
	criado_por VARCHAR(255) NOT NULL,
	modificado_por VARCHAR(255) NOT NULL,
	CONSTRAINT PK_tecnico_id PRIMARY KEY (id),
	CONSTRAINT FK_tecnico_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id),
	CONSTRAINT UC_tecnico_id_usuario UNIQUE (id_usuario)
);