package ads.fafica.modelo;

import java.sql.Date;
import java.sql.Time;

public class Reporte {

	private int codigoReporte;
	private int codigoUsuario;
	private String tipoReporte;
	private String descricaoReporte;
	private int statusReporte;
	private Date dtAberturaReporte;
	private Time hrAberturaReporte;
	private String latitude;
	private String longitude;
	private String cidade;
	private String bairro;
	private String rua;

	public Reporte(int codigoReporte, int codigoUsuario, String tipoReporte,
			String descricaoReporte, int statusReporte, Date dtAberturaReporte,
			Time hrAberturaReporte, String latitude, String longitude,
			String cidade, String bairro, String rua) {

		this.codigoReporte = codigoReporte;
		this.codigoUsuario = codigoUsuario;
		this.tipoReporte = tipoReporte;
		this.descricaoReporte = descricaoReporte;
		this.statusReporte = statusReporte;
		this.dtAberturaReporte = dtAberturaReporte;
		this.hrAberturaReporte = hrAberturaReporte;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}

	public int getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(int codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public String getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	public String getDescricaoReporte() {
		return descricaoReporte;
	}

	public void setDescricaoReporte(String descricaoReporte) {
		this.descricaoReporte = descricaoReporte;
	}

	public int getStatusReporte() {
		return statusReporte;
	}

	public void setStatusReporte(int statusReporte) {
		this.statusReporte = statusReporte;
	}

	public Date getDtAberturaReporte() {
		return dtAberturaReporte;
	}

	public void setDtAberturaReporte(Date dtAberturaReporte) {
		this.dtAberturaReporte = dtAberturaReporte;
	}

	public Time getHrAberturaReporte() {
		return hrAberturaReporte;
	}

	public void setHrAberturaReporte(Time hrAberturaReporte) {
		this.hrAberturaReporte = hrAberturaReporte;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
