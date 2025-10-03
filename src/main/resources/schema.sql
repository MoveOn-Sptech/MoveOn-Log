CREATE DATABASE moveon;

USER moveon;

CREATE TABLE logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_log VARCHAR(50),
    description TEXT,
    created_at TIMESTAMP(6)
);

INSERT INTO logs (type_log, description, created_at)
VALUES ('INFO', 'O serviço de processamento de pedidos foi inicializado.', NOW(6));

INSERT INTO logs (type_log, description, created_at)
VALUES ('WARN', 'A conexão com o cache externo atingiu o tempo limite.', NOW(6));

INSERT INTO logs (type_log, description, created_at)
VALUES ('ERROR', 'Exceção não tratada ao tentar calcular o frete.', NOW(6));

SELECT
    id,
    type_log,
    description,
    created_at
FROM logs
ORDER BY id DESC;