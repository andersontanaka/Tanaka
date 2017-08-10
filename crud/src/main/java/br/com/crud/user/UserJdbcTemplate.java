package br.com.crud.user;

import java.util.List;

import br.com.crud.db.DBUtils;


public class UserJdbcTemplate extends DBUtils {
	public void insertUser(User user){
		String sql = "INSERT INTO USERS VALUES(?, ?, ?)";
		jdbcTemplate.update(sql,
		new Object[] { user.getNome(), user.getNascimento(), user.getCpf()});
		
	}
	
	public void updateUser(int cpf, User user){
		String sql = "UPDATE USERS SET nome = ?, nascimento = ?, WHERE CPF = ?";
		jdbcTemplate.update(sql, new Object[]{user.getNome(), user.getNascimento(),cpf });
	}
	public void deleteUser(String cpf){
		try {
			String sql = "DELETE FROM USERS WHERE CPF = ?";
			jdbcTemplate.update(sql, new Object[] { cpf });
			
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
		

	}
	public List<User> getUsers(){
		String sql = "SELECT * FROM USERS ";
		List<User> user = jdbcTemplate.query(sql, new UserMapper());
		return user;
		
	}
	public List<User> getSingleUser(int cpf){
		String sql = "SELECT * FROM USERS WHERE CPF = ?";
		List<User> users = jdbcTemplate.query(sql, new Object[] {cpf }, new UserMapper());
		return users;
		
	}
};
