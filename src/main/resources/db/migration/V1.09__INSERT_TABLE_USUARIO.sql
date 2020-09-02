INSERT INTO usuario 
	(id, email, senha, nome_completo, avatar, ativo, id_regra, id_empresa, criado, modificado, criado_por, modificado_por, 
		celular, telefone, ddd_celular, ddd_telefone)
VALUES
	(1, 'testeti@gmail.com', '$2a$10$knPE6meJFrTRj6OgHZDc4.kr.WN2ss5yEnhvy1jr2qsJqRovyK1RC', 
	'TesteTI', '', 1, 1, 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM',
	'987654321', '12345678', '11', '11');
