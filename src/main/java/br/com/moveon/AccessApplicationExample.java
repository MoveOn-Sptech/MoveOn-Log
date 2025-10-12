package br.com.moveon;

import br.com.moveon.connection.DatabaseConnection;

public class AccessApplicationExample {

    public static void main(String[] args) throws InterruptedException {
        DatabaseConnection connection = new DatabaseConnection();
        Logger logger = new Logger(connection.getJdbcTemplate());

        logger.info("Usuário 'Joao' acessou a aplicação.");

        logger.info("Página inicial carregada para o usuário 'Joao'.");

        logger.warn("Usuário 'Joao' tentou acessar a página de administração sem permissão.");

        logger.warn("Tentativa invalida, usuario: joão não autorizado.");

        logger.warn("Tentativa invalida, usuario: joão não autorizado.");

        logger.warn("Tentativa invalida, usuario: joão não autorizado.");

        logger.fatal("Usuário 'Joao' bloqueado após múltiplas tentativas inválidas de acesso.");

        logger.info("Usuário 'Joao' foi desconectado da aplicação.");
    }
}
