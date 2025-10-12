package br.com.moveon;

import br.com.moveon.connection.DatabaseConnection;
import br.com.moveon.entites.Log;

import java.time.Instant;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        DatabaseConnection connection = new DatabaseConnection();
        Logger logger = new Logger(connection.getJdbcTemplate());
        for (Log log : logger.getLogDao().getAll()) {
            System.out.println(log);
        }
    }

}




