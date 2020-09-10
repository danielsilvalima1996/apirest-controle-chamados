INSERT INTO usuario 
	(id, email, senha, nome_completo, avatar, ativo, id_regra, id_empresa, criado, modificado, criado_por, modificado_por, 
		celular, telefone, ddd_celular, ddd_telefone, is_tecnico)
VALUES
	(1, 'alison.keuver@gmail.com', '$2a$10$knPE6meJFrTRj6OgHZDc4.kr.WN2ss5yEnhvy1jr2qsJqRovyK1RC', 
	'Alison Keuver da Silva', '', 1, 1, 1, now(), now(), 'SISTEMA', 'SISTEMA',
	'987654321', '12345678', '11', '11', 0),
	(2, 'dsl15021996@gmail.com', '$2a$10$knPE6meJFrTRj6OgHZDc4.kr.WN2ss5yEnhvy1jr2qsJqRovyK1RC', 
	'Daniel da Silva de Lima', '', 1, 1, 1, now(), now(), 'SISTEMA', 'SISTEMA',
	'986284900', '12345678', '11', '11', 0);