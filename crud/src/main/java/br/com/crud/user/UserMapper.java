package br.com.crud.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setNome(rs.getString("NOME"));
		user.setNascimento(rs.getDate("NASCIMENTO"));
		user.setCpf(rs.getString("CPF"));

		return user;
	}

}
