package exercicio1;

public class Fila<T> {

    private No<T> inicio;

    public Fila() {
        this.inicio = null;
    }

    public void enfilerar(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No<T> noAtual = inicio;
            while (noAtual.proximo != null) {
                noAtual = noAtual.proximo;
            }
            noAtual.proximo = novoNo;
        }
    }

    public T desenfilerar() {
        if (inicio == null) {
            System.out.println("A fila está vazia!");
            return null;
        }
        T valor = inicio.dado;
        inicio = inicio.proximo;
        return valor;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("A fila está vazia.");
            return;
        }
        No<T> atual = inicio;
        System.out.println("Fila:");
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
