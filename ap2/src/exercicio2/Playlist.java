package exercicio2;

public class Playlist {
    private No inicio;
    private No fim;
    private No atual;

    public Playlist() {
        this.inicio = null;
        this.fim = null;
        this.atual = null;
    }

    public void adicionarMusica(Musica musica) {
        No novo = new No(musica);
        if (inicio == null) {
            inicio = fim = atual = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void proximaMusica() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            System.out.println("Atual: " + atual.musica);
        } else {
            System.out.println("Sem mais musicas");
        }
    }

    public void musicaAnterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            System.out.println("Atual: " + atual.musica);
        } else {
            System.out.println("Sem musica anterior");
        }
    }

    public void tocarMusica() {
        if (atual != null) {
            System.out.println("Atual" + atual.musica);
        } else {
            System.out.println("Playlist vazia.");
        }
    }

    public void listarMusicas() {
        if (inicio == null) {
            System.out.println("Sem musicas");
            return;
        }
        No aux = inicio;
        while (aux != null) {
            System.out.println(aux.musica);
            aux = aux.proximo;
        }
    }

    public void removerMusica(String titulo) {
        No aux = inicio;
        while (aux != null) {
            if (aux.musica.titulo.equalsIgnoreCase(titulo)) {
                if (aux == inicio) {
                    inicio = aux.proximo;
                    if (inicio != null) inicio.anterior = null;
                } else if (aux == fim) {
                    fim = aux.anterior;
                    fim.proximo = null;
                } else {
                    aux.anterior.proximo = aux.proximo;
                    aux.proximo.anterior = aux.anterior;
                }
                if (atual == aux) atual = inicio;
                System.out.println("Música removida: " + titulo);
                return;
            }
            aux = aux.proximo;
        }
        System.out.println("Musica nao achada");
    }

    public void ordenarPorTitulo() {
        if (inicio == null) return;
        boolean trocado;
        do {
            trocado = false;
            No atual = inicio;
            while (atual.proximo != null) {
                if (atual.musica.titulo.compareToIgnoreCase(atual.proximo.musica.titulo) > 0) {
                    Musica temp = atual.musica;
                    atual.musica = atual.proximo.musica;
                    atual.proximo.musica = temp;
                    trocado = true;
                }
                atual = atual.proximo;
            }
        } while (trocado);
        System.out.println("Playlist ordenada por título.");
    }

    public void ordenarPorArtista() {
        if (inicio == null) return;
        boolean trocado;
        do {
            trocado = false;
            No atual = inicio;
            while (atual.proximo != null) {
                if (atual.musica.artista.compareToIgnoreCase(atual.proximo.musica.artista) > 0) {
                    Musica temp = atual.musica;
                    atual.musica = atual.proximo.musica;
                    atual.proximo.musica = temp;
                    trocado = true;
                }
                atual = atual.proximo;
            }
        } while (trocado);
        System.out.println("Playlist ordenada por artista.");
    }
}
