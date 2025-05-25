package exercicio1;

public class Pilha<T> {

    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    // Empilhar (inserir no topo)
    public void empilhar(T elemento) {
        No<T> novoNo = new No<>(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    // Desempilhar (remover do topo)
    public T desempilhar() {
        if (topo == null) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        T valor = topo.dado;
        topo = topo.proximo;
        return valor;
    }

    // Exibir os elementos da pilha
    public void exibir() {
        if (topo == null) {
            System.out.println("A pilha está vazia.");
            return;
        }
        No<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
