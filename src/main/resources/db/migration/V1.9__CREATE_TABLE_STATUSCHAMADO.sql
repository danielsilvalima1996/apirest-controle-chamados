CREATE TABLE IF NOT EXISTS statusChamado(
	id BIGINT AUTO_INCREMENT NOT NULL,
	ativo BIT(1) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	cor VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
);