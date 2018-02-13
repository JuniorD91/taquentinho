CREATE TABLE ingrediente (
  codigo BIGINT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NULL,
  valor DECIMAL(10,2) NULL,
  url VARCHAR(300) NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ingrediente(descricao, valor,url) values('Alface',0.40,'http://bigbom.com.br/wp-content/uploads/2017/05/alface.png');
INSERT INTO ingrediente(descricao, valor,url) values('Bacon',2.00,'http://bigbom.com.br/wp-content/uploads/2017/01/bacon_rezende.png');
INSERT INTO ingrediente(descricao, valor,url) values('Hambúrguer de carne',3.00,'https://brasilburguers.com.br/wp-content/uploads/2015/05/hamburguer-carne-150x150.jpg');
INSERT INTO ingrediente(descricao, valor,url) values('Ovo',0.80,'http://www.seucorpoperfeito.com.br/wp-content/uploads/2017/02/ovo-frito-maxima-setembro-150x150.png');
INSERT INTO ingrediente(descricao, valor,url) values('Queijo',1.50,'http://mercadopoa.com.br/wp-content/uploads/2017/12/queijo_cheddar_fatiado_68_1_20170523152621.png'); 