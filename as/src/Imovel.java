import java.util.Scanner;

public class Imovel {
    private String nome;
    private double preco;
    private double aluguel;
    private Jogador dono;

    public Imovel(String nome, double preco, double aluguel) {
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.dono = null;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getAluguel() {
        return aluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    public boolean estaDisponivel() {
        return dono == null;
    }


    //caso cair em um imovel
    public void interagir(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nVocê caiu em: " + nome);
        System.out.println("Preço: R$" + preco + " | Aluguel: R$" + aluguel);

        if (dono == null) {
            if (jogador.getSaldo() >= preco) {
                System.out.println("--- O que deseja fazer? ---");
                System.out.println("1. Comprar imóvel");
                System.out.println("2. Passar a vez");

                System.out.print(">> Escolha: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    jogador.pagar(preco);
                    setDono(jogador);
                    jogador.adicionarPropriedade(this);
                    System.out.println(jogador.getNome() + " comprou o imóvel " + nome + " por R$" + preco);
                } else {
                    System.out.println(jogador.getNome() + " optou por não comprar o imóvel " + nome);
                }
            } else {
                System.out.println("Saldo insuficiente para comprar este imóvel.");
            }

        } else if (!dono.equals(jogador)) {
            jogador.pagar(aluguel);
            dono.receber(aluguel);
            System.out.println(jogador.getNome() + " pagou R$" + aluguel + " de aluguel para " + dono.getNome());
        } else {
            System.out.println("Você parou em um imóvel que já é seu.");
        }
    }
}