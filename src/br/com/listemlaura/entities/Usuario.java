package br.com.listemlaura.entities;

public class Usuario {
	private String userName;
	private String senha;
	private boolean mensalidadeEmDia;
	private Plano tipoDoPlano; // gratis com anuncio ou solo ou familiar
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isMensalidadeEmDia() {
		return mensalidadeEmDia;
	}
	public void setMensalidadeEmDia(boolean mensalidadeEmDia) {
		this.mensalidadeEmDia = mensalidadeEmDia;
	}
	public Plano getTipoDoPlano() {
		return tipoDoPlano;
	}
	public void setTipoDoPlano(Plano tipoDoPlano) {
		this.tipoDoPlano = tipoDoPlano;
	}
	public Usuario(String userName, String senha, boolean mensalidadeEmDia, Plano tipoDoPlano) {
		this.userName = userName;
		this.senha = senha;
		this.mensalidadeEmDia = mensalidadeEmDia;
		this.tipoDoPlano = tipoDoPlano;
	}

	
}
