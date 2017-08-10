package br.com.crud.servlet;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.user.User;
import br.com.crud.user.UserJdbcTemplate;


@MultipartConfig
@RestController
public class UserServlet {
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/user/prefetch")
	public List<User> prefetch() {
		return new UserJdbcTemplate().getUsers();
	}

	@RequestMapping("/user/typeahead")
	public List<User> typeahead(@RequestParam(value = "cpf") int cpf) {
		return new UserJdbcTemplate().getSingleUser(cpf);
	}
	@RequestMapping("/user/insert")
	public RestResponse insertUser(@RequestBody User user) {

		RestResponse rr = new RestResponse();
		try {
			new UserJdbcTemplate().insertUser(user);
			rr.setTitle("Sucesso!");
			rr.setMessage("User insert!");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setTitle("Erro");
			rr.setMessage(e.getMessage());
		}
		return rr;
	};
	@RequestMapping("/user/update/{cpf}")
	public RestResponse updateUser(@RequestBody User user, @PathVariable("cpf") int cpf) {

		RestResponse rr = new RestResponse();
		try {
			new UserJdbcTemplate().updateUser(cpf, user);
			rr.setTitle("Sucesso!");
			rr.setMessage("User update!");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setTitle("Erro");
			rr.setMessage(e.getMessage());
		}
		return rr;
	};
	@RequestMapping("/user/delete/{cpf}")
	public RestResponse deleteUser(@PathVariable("cpf") String cpf) {

		RestResponse rr = new RestResponse();
		try {
			new UserJdbcTemplate().deleteUser(cpf);
			rr.setTitle("Sucesso!");
			rr.setMessage("User delete!");
		} catch (Exception e) {
			e.printStackTrace();
			rr.setTitle("Erro");
			rr.setMessage(e.getMessage());
		}
		return rr;
	};

	

};
