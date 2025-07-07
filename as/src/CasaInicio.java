public class CasaInicio extends Casa {
    private double salario;

    public CasaInicio(double salario) {
        super("Início");
        this.salario = salario;
    }

    @Override
    public void acao(Jogador jogador) {
        jogador.receber(salario);
        System.out.println(jogador.getNome() + " recebeu R$" + salario + " ao passar pelo Início.");
    }
}