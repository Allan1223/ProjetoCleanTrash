package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import ads.fafica.controlador.IRepositorioSolucao;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Solucao;

public class RepositorioSolucao implements IRepositorioSolucao {

	private Solucao repositorioSolucao;
	private Connection conn = null;

	public RepositorioSolucao() throws Exception {
		this.conn = ConnectionManager.reservaStatement("mysql");
	}

	public void remover(int codigoSolucao) {

	}

	public List<Solucao> procurarSolucao(int codigoSolucao)
			throws RepositorioException, SQLException {

		List<Solucao> solucoes = new ArrayList<Solucao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM SOLUCAO WHERE codigoSolucao = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoSolucao);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Solucao solucao = new Solucao(rs.getInt("codigoSolucao"),
						rs.getInt("codigoUsuario"), rs.getInt("codigoReporte"),
						rs.getString("descricaoSolucao"),
						rs.getTime("horaFechamento"),
						rs.getDate("dataFechamento"));

				solucoes.add(solucao);

			}
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
		return solucoes;
	}

	public void inserirSolucao(Solucao solucao) throws RepositorioException,
			SQLException {

		PreparedStatement stmt = null;
		if (solucao != null) {
			try {
				String sql = "INSERT INTO solucao (codigoReporte, codigoUsuario, descricaoSolucao, dataFechamento, horaFechamento)"
						+ " VALUES (?, ?, ?, ?, ?)";

				stmt = (PreparedStatement) this.conn.prepareStatement(sql);

				stmt.setInt(1, solucao.getcodigoReporte());
				stmt.setInt(2, solucao.getCodigoUsuario());
				stmt.setString(3, solucao.getDescricaoSolucao());
				stmt.setDate(4,
						(java.sql.Date) solucao.getDtFechamentoSolucao());
				stmt.setTime(5, solucao.getHrFechamentoSolucao());

				stmt.execute();

			} catch (SQLException e) {
				throw new RepositorioException(e);
			} finally {
				stmt.close();
			}
		}

	}

	@Override
	public List<Solucao> listarSolucao() throws RepositorioException,
			SQLException {
		List<Solucao> solucoes = new ArrayList<Solucao>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM SOLUCAO";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigoSolucao = rs.getInt("codigoSolucao");
				int codigoUsuario = rs.getInt("codigoUsuario");
				int codigoReporte = rs.getInt("codigoReporte");
				String descricaoSolucao = rs.getString("descricaoSolucao");

				java.sql.Date dtFechamentoSolucao = rs
						.getDate("dataFechamento");

				Time hrFechamentoSolucao = rs.getTime("horaFechamento");

				Solucao solucao = new Solucao(codigoSolucao, codigoUsuario,
						codigoReporte, descricaoSolucao, hrFechamentoSolucao,
						(java.sql.Date) dtFechamentoSolucao);

				solucoes.add(solucao);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return solucoes;
	}
}
