public class ArvoreRanking {
    private NoBST raiz;

    public void inserir(Jogador jogador) {
        raiz = inserirRec(raiz, jogador);
    }

    private NoBST inserirRec(NoBST atual, Jogador jogador) {
        if (atual == null) return new NoBST(jogador);

        double patrimonioAtual = atual.jogador.calcularPatrimonio();
        double patrimonioNovo = jogador.calcularPatrimonio();

        if (patrimonioNovo < patrimonioAtual) {
            atual.esquerda = inserirRec(atual.esquerda, jogador);
        } else {
            atual.direita = inserirRec(atual.direita, jogador);
        }

        return atual;
    }

    public void exibirRankingDecrescente() {
        System.out.println("\n--- RANKING ATUAL ---");
        exibirInverso(raiz);
    }

    private void exibirInverso(NoBST no) {
        if (no == null) return;
        exibirInverso(no.direita);
        Jogador j = no.jogador;
        System.out.printf("%s - Patrimônio: R$ %.2f %s\n",
                j.getNome(),
                j.calcularPatrimonio(),
                j.estaFalido() ? "(Falido)" : "");
        exibirInverso(no.esquerda);
    }
}