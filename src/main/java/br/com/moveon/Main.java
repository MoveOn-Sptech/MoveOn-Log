package br.com.moveon;

import br.com.moveon.entites.Log;

import java.sql.Timestamp;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = new Logger();

        System.out.println(new Timestamp(System.currentTimeMillis()));
        logger.info("henry");
//        System.out.println(logger.title);
        List<Log> logs = logger.getLogDao().getAll();


        for (Log log : logs) {
            System.out.println(log);
        }


//
//        // Usuário "Joao" acessa a aplicação
//        logger.info("Usuário 'Joao' acessou a aplicação.");
//
//        logger.info("Página inicial carregada para o usuário 'Joao'.");
//
//        logger.warn("Usuário 'Joao' tentou acessar a página de administração sem permissão.");
//
//        // Tentativas de login inválidas com o usuário "admin"
//        logger.warn("Tentativa invalida, usuario: joão não autorizado.");
//
//        logger.warn("Tentativa invalida, usuario: joão não autorizado.");
//
//        logger.warn("Tentativa invalida, usuario: joão não autorizado.");
//
//        // Bloqueio após múltiplas falhas
//        logger.fatal("Usuário 'Joao' bloqueado após múltiplas tentativas inválidas de acesso.");
//
//        logger.info("Usuário 'Joao' foi desconectado da aplicação.");
////



        }

}




