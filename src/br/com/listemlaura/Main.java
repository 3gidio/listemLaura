package br.com.listemlaura;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.listemlaura.entities.Musica;
import br.com.listemlaura.entities.Plano;
import br.com.listemlaura.entities.Playlist;
import br.com.listemlaura.entities.Usuario;

public class Main {

	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Musica> musicas  = new ArrayList<Musica>();// Arraylist Global (Instancia de arraylist)
	static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	static int usuarioLogado = 0;
	
	public static void main(String[] args) {
		cadastroMusica();
		System.out.println("Bem vindo ao Listem Laura!!!\n");
		System.out.println("Escolha uma Opcao:\n\n[1]Faca seu Login\n[2]Cadastre-se para iniciar\n");
		Scanner scan = new Scanner(System.in);
		int opcao = scan.nextInt();
		switch (opcao) {
		case 1:
			login();
			break;
		case 2:
			cadastro();
			break;

		}
		scan.close();
	}
	
	public static void menu() {
		System.out.println("Escolha uma Opcao!!!\n" +
	"[1] Exibir Musica \n [2] Tocar Musica \n [3] Criar Playlist \n [4] Mostrar Playlists\n [5] Mostrar Conteudo de uma Playlist \n[6] Sair");
		Scanner scan = new Scanner(System.in);
		int opcao = scan.nextInt();
		switch (opcao) {
		case 1:
			exibirMusicas();
			menu();
			break;
		case 2:
			reprodutorDeMusica();
			break;
		case 3:
			criarPlayList();
			break;
		case 4:
			mostrarPlayLists();
			menu();
			break;
		case 5:
			mostrarUmaPlaylist();
			break;
		case 6:
			break;

		}
		scan.close();
		
		
	}

	public static void cadastroMusica() {
		Musica musica1 = new Musica();
		musica1.setNome("Espatodia");
		musica1.setCantor("Nando Reis");
		musica1.setGenero("MBP");
		musica1.setDuracaoEmSegundos(180);
		musica1.setCompositor("Nando Reis");
		musicas.add(musica1); // o add inclui na Arraylist global o instancia "musica1" 

		Musica musica2 = new Musica();
		musica2.setNome("Teatro de Vanpiros");
		musica2.setCantor("Legiao Urbana");
		musica2.setGenero("Rock");
		musica2.setDuracaoEmSegundos(220);
		musica2.setCompositor("Renato Russo");
		musicas.add(musica2);
		
		Musica musica3 = new Musica();
		musica3.setNome("Luz que me traz paz");
		musica3.setCantor("Maneva");
		musica3.setGenero("Regggae");
		musica3.setDuracaoEmSegundos(220);
		musica3.setCompositor("Thales de Mileto");
		musicas.add(musica3);
	}

	public static void exibirMusicas() {
		for (int i = 0; i < musicas.size(); i++) {
			Musica musica = musicas.get(i);
			System.out.println(i + "- Nome: " + musica.getNome() + "Cantor: " + musica.getCantor() + "Genero: " +
			musica.getGenero() + "Duracao em Segundos: " + musica.getDuracaoEmSegundos() + "Compositor: " + musica.getCompositor());
			
		}
	
	}


	public static void reprodutorDeMusica() {
		exibirMusicas();
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual numero de Musica vc quer dar Play?\n");
		int i = scan.nextInt();
		System.out.println("Musica em execucao: " + musicas.get(i).getNome());
		System.out.println("\n [1] Proxima musica  [2] Pause [3] Musica Anterior [4]Retornar ao Menu Principal");
		int opcao = scan.nextInt();
		if (opcao == 1) {
			System.out.println("\nMusica em execucao: " + musicas.get(i+1).getNome() );
			reprodutorDeMusica();
		} else if (opcao == 2) {
			System.out.println("\nMusica Pausada: " ); 
			reprodutorDeMusica();
		} else if (opcao == 3) {
			System.out.println("\nMusica em execucao: " + musicas.get(i-1) );
			reprodutorDeMusica();
		} else if (opcao ==4) {
			menu();
		}
	}

	public static void criarPlayList() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Nome da sua nova Playlist\n");
		String nomePlaylist = scan.nextLine();
		System.out.println("Selecione o numero corrrespondente a musica que voce gostaria de adicionar a sua playList + "
				+ "Separado por virgula\n");
		exibirMusicas();
		String numeroMusicas = scan.nextLine();
		String[] numeroMusicasSplit = numeroMusicas.split(","); // metodo split separa os itens por "virgula" ou por qlq outro caracter que vc deseja
		ArrayList<Musica> musicasDaPlaylist = new ArrayList();
		for (int i = 0; i < numeroMusicasSplit.length; i++ ) {
			int numeroDaMusica = Integer.parseInt(numeroMusicasSplit[i]);
			Musica musica = musicas.get(numeroDaMusica);
			musicasDaPlaylist.add(musica);
			
		}
		Playlist playList = new Playlist(nomePlaylist, usuarioLogado, musicasDaPlaylist);
		playlists.add(playList);
		System.out.println("\nPlaylist criada com Sucesso!\n");
		menu();
	}

	public static void mostrarPlayLists() {
		for (int i = 0; i < playlists.size(); i++) {
			Playlist playlist = playlists.get(i);
			String nomePlaylist = playlist.getNomePlayList();
			System.out.println("\n" + i + " - " + nomePlaylist);
			
		}
		

	}

	public static void login() {
		System.out.println("Digite seu USERNAME\n");
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
		System.out.println("Digite sua Senha\n");
		String senha = scan.nextLine();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUserName().equals(userName) && usuarios.get(i).getSenha().equals(senha)) {
				usuarioLogado = i;
				System.out.println("Login e Senha Corretos\n");
				menu();
			} else {
				System.out.println("Login e Senha Incorretos\n");
				login();
			}

		}

	}

	public static void cadastro() {
		System.out.println("Digite o seu USERNAME \n");
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
		System.out.println("Cadastre a sua senha\n");
		String senha = scan.nextLine();
		System.out.println("Escolha o seu Plano\n\n[1]GRATIS\n[2]SOLO\n[3]FAMILIA\n");
		String plano = scan.nextLine();
		String planoConvertido = "";
		if (plano.equals("1")) {     
			planoConvertido = "GRATIS";
		} else if  (plano.equals("2")) {
			planoConvertido = "SOLO";
		} else if (plano.equals("3")) {
			planoConvertido = "FAMILIA";
		}
		
		
		Usuario usuario = new Usuario(userName, senha, true, Plano.valueOf(planoConvertido)); // Convertendo uma String para um
																					// Objeto ENUM "Plano"
		 
		System.out.println("Usuario Cadastrado com Sucesso!!!\n");
		login();
	}
	
	public static void mostrarUmaPlaylist() {
		mostrarPlayLists();
		System.out.println("\nQual o numero da Play list que vc quer ver ?\n");
		Scanner scan = new Scanner (System.in);
		int numeroDaPlaylist = scan.nextInt();
		Playlist playlist = playlists.get(numeroDaPlaylist);
		String nomePlayList = playlist.getNomePlayList();
		int numeroUsuario = playlist.getNumeroUsuario();
		ArrayList<Musica> musicasDaPlayList = playlist.getMusicas();
		System.out.println("\n" + "Playlist de nome: "+  nomePlayList + "\n Usuario N˚" + numeroUsuario);
		for (int i = 0; i < musicasDaPlayList.size(); i++) {
			Musica musica = musicasDaPlayList.get(i);
			System.out.println(i + "- Nome: " + musica.getNome() + "Cantor: " + musica.getCantor() + "Genero: " +
			musica.getGenero() + "Duracao em Segundos: " + musica.getDuracaoEmSegundos() + "Compositor: " + musica.getCompositor());
			
		}
	menu();
	
		
	}

}

// editar o menu com os atributos das musicas
//Estudar o codigo, quais duvidas, revisar metods classes e obejtos
//

