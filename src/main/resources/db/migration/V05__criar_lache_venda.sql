CREATE TABLE lanche_venda (
  lanche_codigo BIGINT NOT NULL,
  venda_codigo BIGINT NOT NULL,
  PRIMARY KEY (lanche_codigo, venda_codigo),
  INDEX fk_lanche_has_venda_venda1_idx (venda_codigo ASC),
  INDEX fk_lanche_has_venda_lanche1_idx (lanche_codigo ASC),
  CONSTRAINT fk_lanche_has_venda_lanche1
    FOREIGN KEY (lanche_codigo)
    REFERENCES lanche (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_lanche_has_venda_venda1
    FOREIGN KEY (venda_codigo)
    REFERENCES venda (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB DEFAULT CHARSET=utf8;