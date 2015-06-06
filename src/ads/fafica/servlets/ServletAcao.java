package ads.fafica.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import ads.fafica.acao.reporte.AcaoCadastrarReporte;
import ads.fafica.acao.reporte.AcaoDetalhaReporte;
import ads.fafica.acao.reporte.AcaoEditarReporte;
import ads.fafica.acao.reporte.AcaoExcluirReporte;
import ads.fafica.acao.reporte.AcaoExcluirReporteOperador;
import ads.fafica.acao.reporte.AcaoFormularioEditarReporte;
import ads.fafica.acao.reporte.AcaoListarReporte;
import ads.fafica.acao.reporte.AcaoListarReporteOperador;
import ads.fafica.acao.reporte.AcaoPesquisarReporte;
import ads.fafica.acao.reporte.AcaoPesquisarReporteOperador;
import ads.fafica.acao.reporte.AcaoReporte;
import ads.fafica.acao.reporte.AcaoSolucionarReporte;

public abstract class ServletAcao  extends HttpServlet {
	
	protected Map<String, AcaoReporte> acoes = new HashMap<String, AcaoReporte>();
		
	protected void iniciarMapaReporte() {
		
		acoes.put("cadastrar", new AcaoCadastrarReporte());
		acoes.put("listar", new AcaoListarReporte());
		acoes.put("formularioEditarReporte", new AcaoFormularioEditarReporte());
		acoes.put("detalheReporte", new AcaoDetalhaReporte());
		acoes.put("editar", new AcaoEditarReporte());
		acoes.put("excluir", new AcaoExcluirReporte());
		acoes.put("excluirReporteOperador", new AcaoExcluirReporteOperador());
		acoes.put("pesquisar", new AcaoPesquisarReporte());
		acoes.put("listarReporteOperador", new AcaoListarReporteOperador());
		acoes.put("solucionarReporte", new AcaoSolucionarReporte());
		acoes.put("pesquisarReporteOperador",new AcaoPesquisarReporteOperador());
		
	}

}
