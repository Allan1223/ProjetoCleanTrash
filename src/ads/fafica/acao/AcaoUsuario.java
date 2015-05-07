package ads.fafica.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcaoUsuario {

	public void executarUsuario(HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException, SQLException;
	//public void executarUsuarioComum(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException, SQLException;
}
