package ads.fafica.acao.solucao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.fafica.controlador.RepositorioException;

public interface AcaoSolucao {

	public void executarSolucao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException, RepositorioException;
}
