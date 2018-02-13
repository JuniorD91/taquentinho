CREATE TABLE lanche (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NULL,
  url VARCHAR(300) NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB DEFAULT CHARSET=utf8;


INSERT INTO lanche(descricao,url) values('X-Bacon','http://www.natuslanches.com.br/wp-content/uploads/2014/12/natus-lanches-passo-fundo-45-x-bacon-161x144.png');
INSERT INTO lanche(descricao,url) values('X-Burger','http://www.natuslanches.com.br/wp-content/uploads/2014/12/natus-lanches-passo-fundo-44-x-burgao-161x144.png');
INSERT INTO lanche(descricao,url) values('X-Egg','http://www.natuslanches.com.br/wp-content/uploads/2014/12/natus-lanches-passo-fundo-43-x-especial-161x144.png');
INSERT INTO lanche(descricao,url) values('X-Egg Bacon','http://www.natuslanches.com.br/wp-content/uploads/2014/12/natus-lanches-passo-fundo-54-x-super-161x144.png');