import java.util.ArrayList;

public class Jogador {
    private String nome;
    private double saldo;
    private Casa posicaoAtual;
    private ArrayList<Imovel> propriedades = new ArrayList<>();

    public Jogador(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public Casa getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(Casa novaCasa) {
        this.posicaoAtual = novaCasa;
    }

    public void pagar(double valor) {
        saldo -= valor;
        if (saldo < 0) {
            saldo = 0;
        }
    }

    public void receber(double valor) {
        saldo += valor;
    }

    public void adicionarPropriedade(Imovel imovel) {
        propriedades.add(imovel);
    }

    public ArrayList<Imovel> getPropriedades() {
        return propriedades;
    }

    public double calcularPatrimonio() {
        double totalImoveis = propriedades.stream().mapToDouble(Imovel::getPreco).sum();
        return saldo + totalImoveis;
    }

    public boolean estaFalido() {
        return saldo <= 0;
    }


    //status
    public void exibirStatus() {
        System.out.println("---- Status de " + nome + " ----");
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Posição atual: " + (posicaoAtual != null ? posicaoAtual.getNome() : "Indefinida"));
        System.out.println("Propriedades:");
        if (propriedades.isEmpty()) {
            System.out.println("Nenhuma.");
        } else {
            for (Imovel im : propriedades) {
                System.out.println("- " + im.getNome() + " (R$" + im.getPreco() + ")");
            }
        }
    }
}
