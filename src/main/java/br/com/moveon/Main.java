package br.com.moveon;

import br.com.moveon.entites.Log;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = new Logger();
        System.out.println(logger.title);
        List<Log> logs = logger.getLogDao().getAll();
        logger.info("henry franz ramos");

        for (Log log : logs) {
            System.out.println(log);
        }
    }

}




