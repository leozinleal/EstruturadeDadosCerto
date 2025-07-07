public class CasaImposto extends Casa {

    public CasaImposto() {
        super("Imposto");
    }

    @Override
    public void acao(Jogador jogador) {
        double patrimonio = jogador.calcularPatrimonio();
        double imposto = patrimonio * 0.05;
        jogador.pagar(imposto);
        System.out.println(jogador.getNome() + " pagou R$" + imposto + " de imposto.");
    }
}
