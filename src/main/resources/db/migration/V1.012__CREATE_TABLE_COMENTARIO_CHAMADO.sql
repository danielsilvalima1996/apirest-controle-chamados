CREATE TABLE IF NOT EXISTS comentario_chamado(
    id BIGINT AUTO_INCREMENT NOT NULL,
    comentario VARCHAR(255) NOT NULL,
    id_chamado BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    criado DATETIME NOT NULL,
    modificado DATETIME NOT NULL,
    criado_por VARCHAR(255) NOT NULL,
    modificado_por VARCHAR(255) NOT NULL,
    CONSTRAINT PK_comentario_chamado_id PRIMARY KEY (id),
    CONSTRAINT FK_comentario_chamado_id_chamado FOREIGN KEY (id_chamado) REFERENCES chamado(id),
    CONSTRAINT FK_comentario_chamado_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);