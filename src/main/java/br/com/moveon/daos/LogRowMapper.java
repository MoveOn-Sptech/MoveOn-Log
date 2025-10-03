package br.com.moveon.daos;

import br.com.moveon.entites.Log;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LogRowMapper implements RowMapper<Log> {
    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocalDateTime  createdAt = rs.getObject("created_at", LocalDateTime.class);

        return new Log(
                rs.getLong("id"),
                rs.getString("type_log"),
                rs.getString("description"),
                createdAt.toInstant(ZoneOffset.UTC)
        );
    }
}
