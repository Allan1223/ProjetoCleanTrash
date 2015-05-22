package ads.fafica.modelo;

import java.sql.Time;
import java.sql.Date;

public class Solucao {

	private int codigoSolucao;
	private int codigoUsuario;
	private int codigoReporte;
	private String descricaoSolucao;
	private Time hrFechamentoSolucao;
	private Date dtFechamentoSolucao;

	public Solucao(int codigoSolucao, int codigoUsuario, int codigoReporte,
			String descricaoSolucao, Time hrFechamentoSolucao,
			Date dtFechamentoSolucao) {
		this.codigoSolucao = codigoSolucao;
		this.codigoUsuario = codigoUsuario;
		this.codigoReporte = codigoReporte;
		this.descricaoSolucao = descricaoSolucao;
		this.hrFechamentoSolucao = hrFechamentoSolucao;
		this.dtFechamentoSolucao = dtFechamentoSolucao;
	}

	public int getcodigoReporte() {
		return codigoReporte;
	}

	public void setcodigoReporte(int codigoReporte) {
		this.codigoReporte = codigoReporte;
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

	public java.sql.Time getHrFechamentoSolucao() {
		return hrFechamentoSolucao;
	}

	public void setHrFechamentoSolucao(java.sql.Time hrFechamentoSolucao) {
		this.hrFechamentoSolucao = hrFechamentoSolucao;
	}

	public Date getDtFechamentoSolucao() {
		return dtFechamentoSolucao;
	}

	public void setDtFechamentoSolucao(Date dtFechamentoSolucao) {
		this.dtFechamentoSolucao = dtFechamentoSolucao;
	}
}
