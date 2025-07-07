public class CasaRestituicao extends Casa {
    private double salarioBase;

    public CasaRestituicao(double salarioBase) {
        super("Restituição");
        this.salarioBase = salarioBase;
    }

    @Override
    public void acao(Jogador jogador) {
        double valor = salarioBase * 0.10;
        jogador.receber(valor);
        System.out.println(jogador.getNome() + " recebeu R$" + valor + " de restituição.");
    }
}