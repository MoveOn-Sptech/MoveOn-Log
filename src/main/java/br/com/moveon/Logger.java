package br.com.moveon;

import br.com.moveon.daos.LogDao;
import br.com.moveon.entites.Log;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Logger {
    String version = "2.0.0";
    String title = """
             __  __  _____     _______ ___  _   _        _     ___   ____\s
            |  \\/  |/ _ \\ \\   / / ____/ _ \\| \\ | |      | |   / _ \\ / ___|
            | |\\/| | | | \\ \\ / /|  _|| | | |  \\| |      | |  | | | | |  _\s
            | |  | | |_| |\\ V / | |__| |_| | |\\  |      | |__| |_| | |_| |
            |_|  |_|\\___/  \\_/  |_____\\___/|_| \\_|      |_____\\___/ \\____|
            
            :: MoveOn Log ::                                      (%s)
            """.formatted(version);

    private LogDao logDao;

    public Logger(JdbcTemplate jdbcTemplate) {
        this.init();
        this.logDao = new LogDao(jdbcTemplate);
    }

    String create(
            String tipo,
            String descricao
    ) {
        Instant dataCriacao = Instant.now().truncatedTo(ChronoUnit.MICROS); // 6 nano segundos
        Log log = new Log(
                tipo, descricao, dataCriacao
        );
        this.logDao.save(log);
        return log.toString();
    }

    void info(String descricao) {
        System.out.println(create("INFO", descricao));
    }

    void warn(String descricao) {
        System.out.println(create("WARN", descricao));
    }

    void error(String descricao) {
        System.err.println(create("ERROR", descricao));
    }

    void fatal(String descricao) {
        System.err.println(create("FATAL", descricao));
    }

    void init() {
        System.out.println(title);
    }

    public LogDao getLogDao() {
        return logDao;
    }
}
