package fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fuctura.model.Usuario;

public class UsuarioDao {
	
	public static void inserir(Connection conexao, Usuario usuario) throws SQLException {
		
		// inserir usuarios
		String sqlInsert = "INSERT INTO usuario (nome, email, idade) values (?, ?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(sqlInsert);
		
		pstm.setString(1, usuario.getNome());
		pstm.setString(2, usuario.getEmail());
		pstm.setInt(3, usuario.getIdade());
		
		pstm.execute();
		
		System.out.println("Registro inserido!");
	}
	
	
	public static void consultar(Connection conexao, Usuario u) throws SQLException {
		// Vamos consultar todos os usuarios

		String comandoDeConsulta = "select * from usuario where codigo = ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDeConsulta);

		ResultSet resultadoConsulta = pstm.executeQuery();
		
		Usuario resultadoObjeto = new Usuario();

		while (resultadoConsulta.next()) {
			// vai entrar no loop se tiver dados
			//
			int codigoUsuario = resultadoConsulta.getInt("codigo");
			String nomeUsuario = resultadoConsulta.getString("nome");

			System.out.println("Cod. Usuário: " + codigoUsuario);
			System.out.println("Nome Usuário: " + nomeUsuario);
			
			resultadoObjeto.setCodigo(codigoUsuario);
			resultadoObjeto.setNome(nomeUsuario);

		}
	}

}
