INSERT INTO pagina
    (id, link, icon, label, short_label, ativo, criado, modificado, criado_por, modificado_por, parent)
VALUES
    (1, '/cadastros', 'po-icon po-icon-document-filled', 'Cadastros', 'Cadastros', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 0), 
    (2, '/chamados', 'po-icon po-icon-touch', 'chamados', 'chamados', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 0), 
    (3, '/dashboard', 'po-icon po-icon-home', 'Home', 'Home', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 0), 
    (4, '/empresa', 'po-icon po-icon-handshake', 'Empresa', 'Empresa', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (5, '/usuario', 'po-icon po-icon-handshake', 'Usuário', 'Usuário', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (6, '/tipo-chamado', 'po-icon po-icon-handshake', 'Tipo Chamado', 'Tipo Chamado', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (7, '/subtipo-chamado', 'po-icon po-icon-handshake', 'Subtipo Chamado', 'Subtipo Chamado', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (8, '/tecnico', 'po-icon po-icon-handshake', 'Técnico', 'Técnico', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (9, '/regra', 'po-icon po-icon-handshake', 'Regra', 'Regra', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 1),
    (10, '/acompanhar-usuario', 'po-icon po-icon-handshake', 'Acompanhar Técnico', 'Acompanhar Técnico', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 2),
    (11, '/acompanhar-tecnico', 'po-icon po-icon-handshake', 'Acompanhar Usuário', 'Acompanhar Usuário', 1, now(), now(), 'FLYWAY SYSTEM', 'FLYWAY SYSTEM', 2);