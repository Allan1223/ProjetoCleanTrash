package ads.fafica.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletMap
 */
@WebServlet("/servletMap")
public class servletMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoReporte      = request.getParameter("tipo");
		String descricaoReporte = request.getParameter("descricao");
		String enderenco        = request.getParameter("txtEndereco");
		String lat              = request.getParameter("txtLatitude");
		String lon              = request.getParameter("txtLongitude");
		
		PrintWriter out = response.getWriter();

        // escreve o texto
        out.println("<html>");
        out.println("<body>");
        out.println("Tipo: " + tipoReporte);
        out.println("Descricao: " + descricaoReporte);
        out.println("Endereco: " + enderenco);
        out.println("Latitude: " + lat);
        out.println("Longitude: " + lon);
        out.println("</body>");
        out.println("</html>");
		
	}

}
