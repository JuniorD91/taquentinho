CREATE TABLE ingrediente_lanche (
  ingrediente_codigo BIGINT NOT NULL,
  lanche_codigo BIGINT NOT NULL,
  PRIMARY KEY (ingrediente_codigo, lanche_codigo),
  CONSTRAINT fk_ingrediente_has_lanche_ingrediente
    FOREIGN KEY (ingrediente_codigo)
    REFERENCES ingrediente (codigo)
  ,CONSTRAINT fk_ingrediente_has_lanche_lanche1
    FOREIGN KEY (lanche_codigo)
    REFERENCES lanche (codigo))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (2,1);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (3,1);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (5,1);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (3,2);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (5,2);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (4,3);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (3,3);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (5,3);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (4,4);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (2,4);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (3,4);
INSERT INTO ingrediente_lanche (ingrediente_codigo, lanche_codigo) values (5,4);