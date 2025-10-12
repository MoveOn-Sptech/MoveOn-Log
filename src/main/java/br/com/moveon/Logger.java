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
            String typeLog,
            String description
    ) {
        Instant createdAtFormated = Instant.now().truncatedTo(ChronoUnit.MICROS); // 6 nano segundos
        Log log = new Log(
                typeLog, description, createdAtFormated
        );
        this.logDao.save(log);
        return log.toString();
    }

    void info(String description) {
        System.out.println(create("INFO", description));
    }

    void warn(String description) {
        System.out.println(create("WARN", description));
    }

    void error(String description) {
        System.err.println(create("ERROR", description));
    }

    void fatal(String description) {
        System.err.println(create("FATAL", description));
    }

    void init() {
        System.out.println(title);
    }

    public LogDao getLogDao() {
        return logDao;
    }
}
