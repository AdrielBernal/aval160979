package br.univel.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.db.ConexaoDB;

public class AlunoDAO {
	private static final String SQL_BUSCA_TODOS = "SELECT * FROM Aluno";
	private static final String SQL_INSERE = "INSERT INTO aluno(nome,data_nascimento,ra) VALUES(?,?,?)";
	private static final String SQL_ATUALIZA = "UPDATE aluno WHERE id=? set";
	private static final String SQL_EXCLUI = "DELETE FROM aluno WHERE id=?";

	public List<Aluno> getTodos() {

		Connection con = ConexaoDB.getInstance().getConnection();

		List<Aluno> lista = new ArrayList<>();
		try (PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Aluno c = new Aluno();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setDataNascimento(rs.getString(3));
				c.setRa(rs.getString(4));
				lista.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void insere(Aluno c) {
		Connection con = ConexaoDB.getInstance().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERE);
			ps.setFloat(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getDataNascimento());
			ps.setString(4, c.getRa());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void atualiza(int id, Aluno c) {

	}

	public void exclui(int id) {

	}

}
