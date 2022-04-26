INSERT INTO ENDERECO(PAIS, ESTADO, CEP, BAIRRO, LOGRADOURO, NUMERO)
VALUES
('Brasil', 'BA', '00000000', 'Bairro Tal', 'Rua Tal', 'Numero 0'),
('Brasil', 'RJ', '11111111', 'Bairro Tal', 'Rua Tal', 'Numero 1'),
('Estados Unidos', 'NY', '22222222', 'Bairro Tal', 'Rua Tal', 'Numero 2');

INSERT INTO CONTATO(NOME, EMAIL, ENDERECO_ID)
VALUES
('Jack', 'jack@gmail.com', 1),
('Abigail', 'abigail@hotmail.com', 2),
('John', 'john@outlook.com', 3);

INSERT INTO NUMERO(CATEGORIA, NUMERO, CONTATO_ID)
VALUES
('OUTRO', '(00) 00000-0000', 1),
('TELEGRAM', '(11) 11111-1111', 1),
('WHATSAPP', '(22) 22222-2222', 1),
('COMERCIAL', '(33) 33333-3333', 2),
('PESSOAL', '(44) 44444-4444', 2),
('OUTRO', '(55) 55555-5555', 3),
('COMERCIAL', '(66) 66666-66666', 3);
