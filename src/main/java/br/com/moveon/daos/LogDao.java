package br.com.moveon.daos;

import br.com.moveon.Logger;
import br.com.moveon.entites.Log;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LogDao {

    private JdbcTemplate jdbcTemplate;

    public LogDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Log log) {
        if (log.getId() == null) {
            this.jdbcTemplate.update(
                    """
                            INSERT INTO logs(type_log, description, created_at)
                                VALUES (?, ?, ?);
                            """,
                    log.getTypeLog(),
                    log.getDescription(),
                    log.getCreatedAt()
            );
            return;
        }

        this.jdbcTemplate.update(
                """
                        UPDATE logs SET
                            type_log =?
                            description = ?
                            created_at =?
                        WHERE id = ?
                        """,
                log.getTypeLog(),
                log.getDescription(),
                log.getCreatedAt(),
                log.getId()
        );
    }

    public List<Log> getAll(){
        return this.jdbcTemplate.query("SELECT * FROM logs ORDER BY id DESC", new LogRowMapper());
    }

}
