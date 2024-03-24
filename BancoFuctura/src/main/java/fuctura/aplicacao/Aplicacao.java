package fuctura.aplicacao;

import java.sql.DriverManager;
import java.sql.SQLException;

import fuctura.dao.UsuarioDao;
import fuctura.model.Usuario;

public class Aplicacao {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/FucturaSalaDeAula";
		String username = "postgres";
		String password = "toor";

		var conexao = DriverManager.getConnection(url, username, password);

		// scanner
		String nome = "Lucas Cajueiro";
		String email = "lucas@localhost";
		int idade = 7;

		Usuario u = new Usuario();

		u.setNome(nome);
		u.setEmail(email);
		u.setIdade(idade);

		UsuarioDao userDao = new UsuarioDao();
		userDao.inserir(conexao, u);

		System.out.println("finalizou inserir");

	}

}
