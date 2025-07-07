public class Tabuleiro {
    private Casa inicio;
    private int totalCasas = 0;

    public void adicionarCasa(Casa novaCasa) {
        if (inicio == null) {
            inicio = novaCasa;
            inicio.setProxima(inicio);
        } else {
            Casa atual = inicio;
            while (atual.getProxima() != inicio) {
                atual = atual.getProxima();
            }
            atual.setProxima(novaCasa);
            novaCasa.setProxima(inicio);
        }
        totalCasas++;
    }

    public Casa getInicio() {
        return inicio;
    }

    public int getTotalCasas() {
        return totalCasas;
    }

    public void exibirCasas() {
        Casa atual = inicio;
        if (atual == null) {
            System.out.println("Tabuleiro vazio.");
            return;
        }
        do {
            System.out.println("-> " + atual.getNome());
            atual = atual.getProxima();
        } while (atual != inicio);
    }
}