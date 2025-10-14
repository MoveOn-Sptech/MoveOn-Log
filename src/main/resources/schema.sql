CREATE DATABASE moveon;

USER moveon;

CREATE TABLE log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    descricao TEXT,
    dataCriacao TIMESTAMP(6)
);

select * from logs;

INSERT INTO logs (tipo, descricao, dataCriacao)
VALUES ('INFO', 'O serviço de processamento de pedidos foi inicializado.', NOW(6));

INSERT INTO logs (tipo, descricao, dataCriacao)
VALUES ('WARN', 'A conexão com o cache externo atingiu o tempo limite.', NOW(6));

INSERT INTO logs (tipo, descricao, dataCriacao)
VALUES ('ERROR', 'Exceção não tratada ao tentar calcular o frete.', NOW(6));

SELECT
    id,
    tipo,
    descricao,
    dataCriacao
FROM logs
ORDER BY id DESC;