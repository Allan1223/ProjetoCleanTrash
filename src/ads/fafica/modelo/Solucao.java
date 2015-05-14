package ads.fafica.modelo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Solucao{
	
	private int codigoSolucao;
	private int codigoUsuario;
	private int codigoProblema;	
	private String descricaoSolucao;
	private Time hrFechamentoSolucao;
	private Date dtFechamentoSolucao;
	
	Date dtFechamento = new Date(System.currentTimeMillis());    
	SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");   	
	
	public Solucao(int codigoSolucao, int codigoUsuario, int codigoProblema,
			String descricaoSolucao, Time hrFechamentoSolucao,
			Date dtFechamentoSolucao) {
		this.codigoSolucao = codigoSolucao;
		this.codigoUsuario = codigoUsuario;
		this.codigoProblema = codigoProblema;
		this.descricaoSolucao = descricaoSolucao;
		this.hrFechamentoSolucao = hrFechamentoSolucao;
		this.dtFechamentoSolucao = dtFechamentoSolucao;
	}
	
	public int getCodigoProblema() {
		return codigoProblema;
	}
	public void setCodigoProblema(int codigoProblema) {
		this.codigoProblema = codigoProblema;
	}
	public int getCodigoSolucao() {
		return codigoSolucao;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public void setCodigoSolucao(int codigoSolucao) {
		this.codigoSolucao = codigoSolucao;
	}
	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}
	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}
	public Time getHrFechamentoSolucao() {
		return hrFechamentoSolucao;
	}
	public void setHrFechamentoSolucao(Time hrFechamentoSolucao) {
		this.hrFechamentoSolucao = hrFechamentoSolucao;
	}
	public Date getDtFechamentoSolucao() {
		return dtFechamentoSolucao;
	}
	public void setDtFechamentoSolucao(Date dtFechamentoSolucao) {
		this.dtFechamentoSolucao = dtFechamentoSolucao;
	}


}
