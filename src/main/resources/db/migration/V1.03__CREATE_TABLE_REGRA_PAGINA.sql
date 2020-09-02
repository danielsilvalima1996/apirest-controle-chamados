CREATE TABLE IF NOT EXISTS regra_pagina(
	id BIGINT AUTO_INCREMENT NOT NULL,
	id_pagina BIGINT NOT NULL,
	id_regra BIGINT NOT NULL,
	criado DATETIME NOT NULL,
	modificado DATETIME NOT NULL,
	criado_por VARCHAR(255) NOT NULL,
	modificado_por VARCHAR(255) NOT NULL,
	CONSTRAINT PK_regra_pagina_id PRIMARY KEY (id),
	CONSTRAINT FK_regra_pagina_id_pagina FOREIGN KEY (id_pagina) REFERENCES pagina (id),
	CONSTRAINT FK_regra_pagina_id_regra FOREIGN KEY (id_regra) REFERENCES regra (id)
);
