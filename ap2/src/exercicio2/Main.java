package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Bem-vindo ao seu Gerenciador de Músicas!");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> playlist.proximaMusica();
                case 2 -> playlist.musicaAnterior();
                case 3 -> {
                    System.out.println("Ordenar por: 1-Título, 2-Artista");
                    int criterio = sc.nextInt();
                    if (criterio == 1) playlist.ordenarPorTitulo();
                    else if (criterio == 2) playlist.ordenarPorArtista();
                    else System.out.println("Opção inválida.");
                }
                case 4 -> playlist.tocarMusica();
                case 5 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Álbum: ");
                    String album = sc.nextLine();
                    System.out.print("Duração:");
                    int duracao = sc.nextInt();
                    sc.nextLine();
                    Musica m = new Musica(titulo, artista, album, duracao);
                    playlist.adicionarMusica(m);
                }
                case 6 -> {
                    System.out.print("Musica que deseja remover: ");
                    String titulo = sc.nextLine();
                    playlist.removerMusica(titulo);
                }
                case 7 -> playlist.listarMusicas();
                case 8 -> System.out.println("Saindo...");
            }
        } while (opcao != 8);

        sc.close();
    }
}

