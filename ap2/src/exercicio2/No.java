package exercicio2;

public class No {
    public Musica musica;
    public No proximo;
    public No anterior;

    public No(Musica musica) {
        this.musica = musica;
        this.proximo = null;
        this.anterior = null;
    }
}
