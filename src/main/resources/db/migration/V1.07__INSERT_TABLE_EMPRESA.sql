INSERT INTO empresa 
	(id, cnpj, razao_social, nome_fantasia, criado, modificado, criado_por, modificado_por, ativo, 
		cep, logradouro, complemento, bairro, localidade, uf, numero)
VALUES
	(1, '12345678901234', 'Empresa Teste S.A', 'Fantasia Teste', now(), now(), 'SISTEMA', 'SISTEMA', 1,
		'07142290', 'Rua Força Pública', 'Faculdade', 'Centro', 'Guarulhos', 'SP', 89);