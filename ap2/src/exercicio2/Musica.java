package exercicio2;

public class Musica {
    public String titulo;
    public String artista;
    public String album;
    public int duracao;

    public Musica(String titulo, String artista, String album, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Artista: " + artista +
                ", Álbum: " + album + ", Duração: " + duracao;
    }
}
