package ads.fafica.acao.reporte;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcaoReporte {

	public void executarReporte(HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException, SQLException;
}
