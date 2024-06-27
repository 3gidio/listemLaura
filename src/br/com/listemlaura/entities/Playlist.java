package br.com.listemlaura.entities;

import java.util.ArrayList;

public class Playlist {

	private String nomePlayList;
	private int numeroUsuario;
	private ArrayList<Musica> musicas;
	public String getNomePlayList() {
		return nomePlayList;
	}
	public void setNomePlayList(String nomePlayList) {
		this.nomePlayList = nomePlayList;
	}
	public int getNumeroUsuario() {
		return numeroUsuario;
	}
	public void setNumeroUsuario(int numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}
	public Playlist(String nomePlayList, int numeroUsuario, ArrayList<Musica> musicas) {
		super();
		this.nomePlayList = nomePlayList;
		this.numeroUsuario = numeroUsuario;
		this.musicas = musicas;
	}
	

}
