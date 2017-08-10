package br.com.crud.db;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBUtils {
    public static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
	jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
}
