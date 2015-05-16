package ads.fafica.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ads.fafica.controlador.IRepositorioReporte;
import ads.fafica.controlador.ProblemaNaoEncontradoException;
import ads.fafica.controlador.RepositorioException;
import ads.fafica.controlador.UsuarioNaoEncontradoException;
import ads.fafica.modelo.Reporte;
import ads.fafica.modelo.Usuario;


public class RepositorioReporte implements IRepositorioReporte{

	private Reporte repositorioProblema;

	private Connection conn = null;

	public RepositorioReporte() throws Exception{
		this.conn = ConnectionManager.reservaStatement("mysql"); 	

	}

	public void inserir(Reporte reporte) throws RepositorioException, SQLException{
		PreparedStatement stmt=null;
		if (reporte != null) {
			try {


				String sql = "INSERT INTO REPORTE (tipoReporte, descricaoReporte, statusReporte, dtAberturaReporte, hrAberturaReporte, latitude, longitude, cidade, bairro, rua )"
						+ " VALUES (?, ?, ?, ?)";


				stmt = (PreparedStatement) this.conn.prepareStatement(sql);

				//stmt.setInt(1, usuario.getCodigoUsuario());
				stmt.setString(1, reporte.getTipoReporte());
				stmt.setString(2, reporte.getDescricaoReporte());
				stmt.setString(3, reporte.getStatusReporte());
				stmt.setString(4, reporte.getDtAberturaReporte());
				stmt.setString(5, reporte.getHrAberturaReporte());
				stmt.setString(6, reporte.getLatitude());
				stmt.setString(7, reporte.getLongitude());
				stmt.setString(8, reporte.getCidade());
				stmt.setString(9, reporte.getBairro());
				stmt.setString(10, reporte.getRua());



				stmt.execute();



			}
			catch (SQLException e) {
				throw new RepositorioException(e);
			}
			finally {
				stmt.close();
			}
		}    




	}

	public void remover(int codigoReporte) throws RepositorioException /*throws UsurioNaoEncontradoException */, SQLException{ //Deixar espaço entre a chave  e o parentes.
		PreparedStatement stmt=null;
		try{
			String sql = "DELETE FROM REPORTE WHERE codigoReporte = ?"; 
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			stmt.execute();
		} catch(SQLException e){
			throw new RepositorioException(e);
		} finally {
			stmt.close();
		}

	}

	public Reporte procurar(int codigoProblema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.
		return repositorioProblema;
	}


	public void atualizar(Reporte problema) /*throws PessoaFisicaNaoEncontradaException*/{ //Deixar espaço entre a chave  e o parentes.

	}

	@Override
	public List<Reporte> procurarReporte(int codigoReporte)
			throws ProblemaNaoEncontradoException, UsuarioNaoEncontradoException, RepositorioException, SQLException {
		List<Reporte> reportes = new ArrayList<Reporte>();
		Reporte reporte = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE codigoReporte = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			rs = stmt.executeQuery();


			if (!rs.next()) throw new UsuarioNaoEncontradoException(codigoReporte);
			reporte = new Reporte(rs.getInt("codigoReporte"), rs.getInt("codigoUsuario"), rs.getString("tipoReporte"), rs.getString("descricaoReporte"),rs.getString("statusReporte"), rs.getString("dtAberturaReporte"),rs.getString("hrAberturaReporte"),rs.getString("latitude"),rs.getString("longitude"),rs.getString("cidade"),rs.getString("bairro"),rs.getString("rua"));
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
	public List<Reporte> listarReportes() {
		List<Reporte> reportes = new ArrayList<Reporte>();

		PreparedStatement stmt=null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM REPORTE";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			rs = stmt.executeQuery();


			while (rs.next()) {
				int codigoReporte = 0;
				int codigoUsuario = rs.getInt("codigoUsuario");
				String tipoReporte = rs.getString("tipoReporte");
				String descricaoReporte = rs.getString("descricaoReporte");
				String statusReporte = rs.getString("statusReporte");
				String dtAberturaReporte = rs.getString("dtAberturaReporte");
				String hrAberturaReporte = rs.getString("hrAberturaReporte");
				String latitude = rs.getString("latitude");
				String longitude = rs.getString("longitude");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");



				Reporte reporte = new Reporte(codigoReporte, codigoUsuario,tipoReporte,descricaoReporte,statusReporte,dtAberturaReporte,hrAberturaReporte,latitude, longitude, cidade, bairro, rua);

				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportes;

	}

	@Override
	public Reporte procurarReporteId(int codigoReporte)
			throws ProblemaNaoEncontradoException, RepositorioException,
			SQLException, UsuarioNaoEncontradoException {

		Reporte reporte = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM REPORTE WHERE codigoUsuario = ?";
			stmt = (PreparedStatement) this.conn.prepareStatement(sql);
			stmt.setInt(1, codigoReporte);
			rs = stmt.executeQuery();


			if (!rs.next()) throw new UsuarioNaoEncontradoException(codigoReporte);
			reporte = new Reporte(rs.getInt("codigoReporte"), rs.getInt("codigoUsuario"), rs.getString("tipoReporte"), rs.getString("descricaoReporte"),rs.getString("statusReporte"), rs.getString("dtAberturaReporte"),rs.getString("hrAberturaReporte"),rs.getString("latitude"),rs.getString("longitude"),rs.getString("cidade"),rs.getString("bairro"),rs.getString("rua"));


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


		PreparedStatement stmt=null;
		try {

			try {
				String sql = "UPDATE Reporte SET statusReporte = ?"
						+ " where codigoReporte = ?  ";


				stmt = this.conn.prepareStatement(sql);


				stmt.setInt(1, 1);
				stmt.setInt(2,codigoProblema);


				Integer resultado = stmt.executeUpdate();

			}
			catch (SQLException e) {
				throw new RepositorioException(e);
			}

		} finally {
			stmt.close();
		}

	}


}
