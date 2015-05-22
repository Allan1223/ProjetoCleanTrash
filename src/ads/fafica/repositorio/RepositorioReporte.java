package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import ads.fafica.controlador.IRepositorioReporte;
import ads.fafica.controlador.ProblemaNaoEncontradoException;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.modelo.Reporte;

public class RepositorioReporte implements IRepositorioReporte {

	private Reporte repositorioProblema;

	private Connection conn = null;

	public RepositorioReporte() throws Exception {
		this.conn = ConnectionManager.reservaStatement("mysql");

	}

	public void inserir(Reporte reporte) throws RepositorioException,
			SQLException {
		PreparedStatement stmt = null;
		if (reporte != null) {
			try {

				String sql = "INSERT INTO REPORTE (codigoUsuario, tipoReporte, descricaoReporte, statusReporte, dataAbertura, horaAbertura, latitude, longitude, cidade, bairro, rua )"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				stmt = (PreparedStatement) this.conn.prepareStatement(sql);

				stmt.setInt(1, reporte.getCodigoUsuario());
				stmt.setString(2, reporte.getTipoReporte());
				stmt.setString(3, reporte.getDescricaoReporte());
				stmt.setInt(4, reporte.getStatusReporte());
				stmt.setDate(5, reporte.getDtAberturaReporte());
				stmt.setTime(6, reporte.getHrAberturaReporte());
				stmt.setString(7, reporte.getLatitude());
				stmt.setString(8, reporte.getLongitude());
				stmt.setString(9, reporte.getCidade());
				stmt.setString(10, reporte.getBairro());
				stmt.setString(11, reporte.getRua());

				stmt.execute();

			} catch (SQLException e) {
				throw new RepositorioException(e);
			} finally {
				stmt.close();
			}
		}

	}

	public void remover(int codigoReporte) throws RepositorioException,
			SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM REPORTE WHERE codigoReporte = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			stmt.execute();
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
		}

	}

	public void atualizar(Reporte reporte) throws RepositorioException,
			SQLException {

		PreparedStatement stmt = null;
		try {
			if (reporte != null) {
				try {
					String sql = "UPDATE REPORTE SET tipoReporte = ?, descricaoReporte = ?, latitude = ?, longitude = ?, rua = ?, bairro = ?, cidade = ?"
							+ " where codigoReporte = ?  ";

					stmt = this.conn.prepareStatement(sql);

					stmt.setString(1, reporte.getTipoReporte());
					stmt.setString(2, reporte.getDescricaoReporte());
					stmt.setString(3, reporte.getLatitude());
					stmt.setString(4, reporte.getLongitude());
					stmt.setString(5, reporte.getRua());
					stmt.setString(6, reporte.getBairro());
					stmt.setString(7, reporte.getCidade());
					stmt.setInt(8, reporte.getCodigoReporte());

					stmt.executeUpdate();

				} catch (SQLException e) {
					throw new RepositorioException(e);
				}
			}
		} finally {
			stmt.close();
		}

	}

	@Override
	public List<Reporte> procurarReporte(int codigoReporte, int codigoUsuario)
			throws ProblemaNaoEncontradoException, RepositorioException,
			SQLException {
		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE codigoReporte = ? and codigoUsuario = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			stmt.setInt(2, codigoUsuario);
			rs = stmt.executeQuery();

			if (!rs.next())
				throw new ProblemaNaoEncontradoException(codigoReporte);

			reporte = new Reporte(rs.getInt("codigoReporte"),
					rs.getInt("codigoUsuario"), rs.getString("tipoReporte"),
					rs.getString("descricaoReporte"),
					rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
					rs.getTime("horaAbertura"), rs.getString("latitude"),
					rs.getString("longitude"), rs.getString("cidade"),
					rs.getString("bairro"), rs.getString("rua"));
			reportes.add(reporte);

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {

			stmt.close();
			rs.close();

		}

		return reportes;

	}

	@Override
	public List<Reporte> listarReportes(int user) {
		List<Reporte> reportes = new ArrayList<Reporte>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM REPORTE where codigoUsuario = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, user);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigoReporte = rs.getInt("codigoReporte");
				int codigoUsuario = rs.getInt("codigoUsuario");
				String tipoReporte = rs.getString("tipoReporte");
				String descricaoReporte = rs.getString("descricaoReporte");
				int statusReporte = rs.getInt("statusReporte");
				Date dtAberturaReporte = rs.getDate("dataAbertura");
				Time hrAberturaReporte = rs.getTime("horaAbertura");
				String latitude = rs.getString("latitude");
				String longitude = rs.getString("longitude");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");

				Reporte reporte = new Reporte(codigoReporte, codigoUsuario,
						tipoReporte, descricaoReporte, statusReporte,
						dtAberturaReporte, hrAberturaReporte, latitude,
						longitude, cidade, bairro, rua);

				reportes.add(reporte);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportes;

	}

	@Override
	public List<Reporte> listarReportesOperador() throws RepositorioException,
			SQLException, ProblemaNaoEncontradoException {

		List<Reporte> reportes = new ArrayList<Reporte>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM REPORTE";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigoReporte = rs.getInt("codigoReporte");
				int codigoUsuario = rs.getInt("codigoUsuario");
				String tipoReporte = rs.getString("tipoReporte");
				String descricaoReporte = rs.getString("descricaoReporte");
				int statusReporte = rs.getInt("statusReporte");
				Date dtAberturaReporte = rs.getDate("dataAbertura");
				Time hrAberturaReporte = rs.getTime("horaAbertura");
				String latitude = rs.getString("latitude");
				String longitude = rs.getString("longitude");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");

				Reporte reporte = new Reporte(codigoReporte, codigoUsuario,
						tipoReporte, descricaoReporte, statusReporte,
						dtAberturaReporte, hrAberturaReporte, latitude,
						longitude, cidade, bairro, rua);

				reportes.add(reporte);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportes;
	}

	@Override
	public Reporte procurarReporteId(int codigoReporte)
			throws RepositorioException, SQLException {

		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM REPORTE WHERE codigoReporte = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			rs = stmt.executeQuery();

			if (rs.next()) {
				reporte = new Reporte(rs.getInt("codigoReporte"),
						rs.getInt("codigoUsuario"),
						rs.getString("tipoReporte"),
						rs.getString("descricaoReporte"),
						rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
						rs.getTime("horaAbertura"), rs.getString("latitude"),
						rs.getString("longitude"), rs.getString("cidade"),
						rs.getString("bairro"), rs.getString("rua"));
			}

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {

			stmt.close();
			rs.close();

		}

		return reporte;
	}

	@Override
	public void atualizarStatus(int codigoProblema)
			throws RepositorioException, SQLException {

		PreparedStatement stmt = null;
		try {

			try {
				String sql = "UPDATE Reporte SET statusReporte = ?"
						+ " where codigoReporte = ?  ";

				stmt = this.conn.prepareStatement(sql);

				stmt.setInt(1, 1);
				stmt.setInt(2, codigoProblema);

				Integer resultado = stmt.executeUpdate();

			} catch (SQLException e) {
				throw new RepositorioException(e);
			}

		} finally {
			stmt.close();
		}

	}

	@Override
	public List<Reporte> procurarReporteOperadorPorCodigo(int codigoReporte)
			throws RepositorioException, SQLException,
			ProblemaNaoEncontradoException {

		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE codigoReporte = ? ";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);

			rs = stmt.executeQuery();

			if (!rs.next())
				throw new ProblemaNaoEncontradoException(codigoReporte);

			reporte = new Reporte(rs.getInt("codigoReporte"),
					rs.getInt("codigoUsuario"), rs.getString("tipoReporte"),
					rs.getString("descricaoReporte"),
					rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
					rs.getTime("horaAbertura"), rs.getString("latitude"),
					rs.getString("longitude"), rs.getString("cidade"),
					rs.getString("bairro"), rs.getString("rua"));
			reportes.add(reporte);

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {

			stmt.close();
			rs.close();

		}

		return reportes;
	}

	@Override
	public List<Reporte> procurarReporteOperadorPorStatus(String statusReporte)
			throws RepositorioException, SQLException,
			ProblemaNaoEncontradoException {

		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE statusReporte = ? ";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (!rs.next())
				throw new ProblemaNaoEncontradoException(statusReporte);

			reporte = new Reporte(rs.getInt("codigoReporte"),
					rs.getInt("codigoUsuario"), rs.getString("tipoReporte"),
					rs.getString("descricaoReporte"),
					rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
					rs.getTime("horaAbertura"), rs.getString("latitude"),
					rs.getString("longitude"), rs.getString("cidade"),
					rs.getString("bairro"), rs.getString("rua"));
			reportes.add(reporte);

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
		return reportes;
	}

	@Override
	public List<Reporte> procurarReporteOperadorPorTipo(String tipoReporte)
			throws RepositorioException, SQLException,
			ProblemaNaoEncontradoException {

		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE tipoReporte = ? ";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (!rs.next())
				throw new ProblemaNaoEncontradoException(tipoReporte);

			reporte = new Reporte(rs.getInt("codigoReporte"),
					rs.getInt("codigoUsuario"), rs.getString("tipoReporte"),
					rs.getString("descricaoReporte"),
					rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
					rs.getTime("horaAbertura"), rs.getString("latitude"),
					rs.getString("longitude"), rs.getString("cidade"),
					rs.getString("bairro"), rs.getString("rua"));
			reportes.add(reporte);

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
		return reportes;
	}

	public List<Reporte> procurarReporteOperadorPorDescricao(
			String descricaoReporte) throws RepositorioException, SQLException,
			ProblemaNaoEncontradoException {

		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM USUARIO WHERE descricaoReporte like  '%" + descricaoReporte
					+ "%'";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			if (!rs.next())
				throw new ProblemaNaoEncontradoException(descricaoReporte);

			reporte = new Reporte(rs.getInt("codigoReporte"),
					rs.getInt("codigoUsuario"), rs.getString("tipoReporte"),
					rs.getString("descricaoReporte"),
					rs.getInt("statusReporte"), rs.getDate("dataAbertura"),
					rs.getTime("horaAbertura"), rs.getString("latitude"),
					rs.getString("longitude"), rs.getString("cidade"),
					rs.getString("bairro"), rs.getString("rua"));
			reportes.add(reporte);

		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			stmt.close();
			rs.close();
		}
		return reportes;
	}

}
