package br.com.listemlaura.entities;

public class Musica {
	private String nome;
	private String genero;
	private String cantor;
	private String compositor;
	private int duracaoEmSegundos;
	private String anoDeLancamento;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	public int getDuracaoEmSegundos() {
		return duracaoEmSegundos;
	}

	public void setDuracaoEmSegundos(int duracaoEmSegundos) {
		this.duracaoEmSegundos = duracaoEmSegundos;
	}

	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(String anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	

	public Musica(String nome, String genero, String cantor, String compositor, int duracaoEmSegundos,
			String anoDeLancamento) {
		this.nome = nome;
		this.genero = genero;
		this.cantor = cantor;
		this.compositor = compositor;
		this.duracaoEmSegundos = duracaoEmSegundos;
		this.anoDeLancamento = anoDeLancamento;
	}

	public Musica() {
		
	}

}
