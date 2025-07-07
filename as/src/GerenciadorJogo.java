import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorJogo {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private ArrayList<Imovel> imoveis = new ArrayList<>();
    private double saldoInicial = 25000;
    private double salario = 2000;
    private int maxRodadas = 20;

    Scanner scanner = new Scanner(System.in);



    ///CRIANDO IMÓVEL APENAS PARA TESTE PARA NÃO PRECISAR FICAR CRIANDO NA HORA DOS TESTES
    public GerenciadorJogo() {
        scanner = new Scanner(System.in);
        jogadores = new ArrayList<>();
        imoveis = new ArrayList<>();
        saldoInicial = 25000;
        salario = 2000;
        maxRodadas = 20;

        inicializarImoveisTeste();
    }
    private void inicializarImoveisTeste() {
        imoveis.add(new Imovel("Ed Samoa", 10000, 500));
        imoveis.add(new Imovel("Torres RS CENTER", 15000, 700));
        imoveis.add(new Imovel("Lynemar Shopping", 18000, 900));
        imoveis.add(new Imovel("Arena POA", 20000, 1000));
        imoveis.add(new Imovel("Edificio Nova york", 22000, 1200));
        imoveis.add(new Imovel("Mansão Ipiranga", 17000, 800));
        imoveis.add(new Imovel("Cobertura Diamante", 25000, 1400));
        imoveis.add(new Imovel("Casa Passo Fundo", 21000, 1100));
        imoveis.add(new Imovel("Lux Edificio", 14000, 600));
        imoveis.add(new Imovel("Capao Center Comercial", 12000, 550));
    }
    ///FIM DE CRIAÇÃO DE IMOVEIS


    /// menu principal
    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("=== BANCO IMOBILIARIO ===");
            System.out.println("1. Gerenciar Jogadores");
            System.out.println("2. Gerenciar Imóveis");
            System.out.println("3. Definir Configurações da Partida");
            System.out.println("4. Iniciar Jogo");
            System.out.println("0. Sair");
            System.out.print(">> Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuJogadores();
                case 2 -> menuImoveis();
                case 3 -> menuConfiguracoes();
                case 4 -> iniciarPartida();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    /// menu de jogador
    private void menuJogadores() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Jogadores --- (" + jogadores.size() + "/6)");
            System.out.println("1. Cadastrar Novo Jogador");
            System.out.println("2. Listar Jogadores");
            System.out.println("3. Remover Jogador");
            System.out.println("4. Voltar");
            System.out.print(">> Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (jogadores.size() >= 6) {
                        System.out.println("Máximo de jogadores atingido.");
                        break;
                    }
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    jogadores.add(new Jogador(nome, saldoInicial));
                    System.out.println("Jogador '" + nome + "' cadastrado com sucesso!");
                }
                case 2 -> {
                    for (Jogador j : jogadores) {
                        System.out.println("- " + j.getNome() + " | Saldo: R$ " + j.getSaldo());
                    }
                }
                case 3 -> {
                    System.out.print("Digite o nome do jogador a remover: ");
                    String nome = scanner.nextLine();
                    jogadores.removeIf(j -> j.getNome().equalsIgnoreCase(nome));
                    System.out.println("Removido (se existia).");
                }
            }
        } while (opcao != 4);
    }


    /// menu de imoveis
    private void menuImoveis() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Imóveis --- (" + imoveis.size() + "/40)");
            System.out.println("1. Cadastrar Novo Imóvel");
            System.out.println("2. Listar Imóveis");
            System.out.println("3. Remover Imóvel");
            System.out.println("4. Voltar");
            System.out.print(">> Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (imoveis.size() >= 40) {
                        System.out.println("Máximo de imóveis atingido.");
                        break;
                    }
                    System.out.print("Nome do imóvel: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Aluguel: ");
                    double aluguel = scanner.nextDouble();
                    scanner.nextLine();
                    imoveis.add(new Imovel(nome, preco, aluguel));
                    System.out.println("Imóvel cadastrado.");
                }
                case 2 -> {
                    for (Imovel im : imoveis) {
                        System.out.println("- " + im.getNome() + " | R$" + im.getPreco() + " / Aluguel: R$" + im.getAluguel());
                    }
                }
                case 3 -> {
                    System.out.print("Digite o nome do imóvel a remover: ");
                    String nome = scanner.nextLine();
                    imoveis.removeIf(i -> i.getNome().equalsIgnoreCase(nome));
                    System.out.println("Removido (se existia).");
                }
            }
        } while (opcao != 4);
    }


    //menu de configuracao da partida
    private void menuConfiguracoes() {
        int opcao;
        do {
            System.out.println("\n--- Configurações da Partida ---");
            System.out.println("1. Definir Saldo Inicial (Atual: R$" + saldoInicial + ")");
            System.out.println("2. Definir Salário por Volta (Atual: R$" + salario + ")");
            System.out.println("3. Definir Nº Máximo de Rodadas (Atual: " + maxRodadas + ")");
            System.out.println("4. Voltar");
            System.out.print(">> Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Novo saldo inicial: ");
                    saldoInicial = scanner.nextDouble();
                }
                case 2 -> {
                    System.out.print("Novo salário por volta: ");
                    salario = scanner.nextDouble();
                }
                case 3 -> {
                    System.out.print("Número de rodadas: ");
                    maxRodadas = scanner.nextInt();
                }
            }
        } while (opcao != 4);
    }


    //start
    private void iniciarPartida() {
        if (jogadores.size() < 2) {
            System.out.println("ERRO: Mínimo de 2 jogadores não alcançado.");
            return;
        }
        if (imoveis.size() < 10) {
            System.out.println("ERRO: Mínimo de 10 imóveis não alcançado.");
            return;
        }

        System.out.println("Iniciando o jogo...");

        Tabuleiro tabuleiro = new Tabuleiro();


        CasaInicio inicio = new CasaInicio(salario);
        tabuleiro.adicionarCasa(inicio);


        int i = 0;
        for (Imovel im : imoveis) {
            tabuleiro.adicionarCasa(new CasaImovel(im));
            i++;
            if (i % 3 == 0) tabuleiro.adicionarCasa(new CasaImposto());
            if (i % 5 == 0) tabuleiro.adicionarCasa(new CasaRestituicao(salario));
        }


        for (Jogador j : jogadores) {
            j.setPosicaoAtual(inicio);
        }

        executarRodadas(tabuleiro);
    }

    private void executarRodadas(Tabuleiro tabuleiro) {
        int rodada = 1;

        for (; rodada <= maxRodadas; rodada++) {
            System.out.println("\n=== RODADA " + rodada + " / " + maxRodadas + " ===");

            for (Jogador j : jogadores) {
                if (j.estaFalido()) continue;

                System.out.println("\nVEZ DE: " + j.getNome());
                System.out.println("Posição atual: " + j.getPosicaoAtual().getNome());
                System.out.println("Saldo: R$" + j.getSaldo());

                boolean turnoFinalizado = false;
                while (!turnoFinalizado) {
                    System.out.println("\n--- O que você deseja fazer? ---");
                    System.out.println("1. Lançar Dados e Mover");
                    System.out.println("2. Ver Meu Status");
                    System.out.println("3. Ver Ranking de Jogadores");
                    System.out.println("0. Passar a vez");

                    System.out.print(">> Escolha: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    switch (escolha) {
                        case 1 -> {
                            int dado1 = (int) (Math.random() * 6) + 1;
                            int dado2 = (int) (Math.random() * 6) + 1;
                            int total = dado1 + dado2;

                            System.out.println(j.getNome() + " tirou " + dado1 + " e " + dado2 + " (Total: " + total + ")");

                            Casa atual = j.getPosicaoAtual();
                            for (int i = 0; i < total; i++) {
                                atual = atual.getProxima();
                                if (atual instanceof CasaInicio && i < total - 1) {
                                    ((CasaInicio) atual).acao(j);
                                }
                            }

                            j.setPosicaoAtual(atual);
                            System.out.println("Parou em: " + atual.getNome());
                            atual.acao(j);
                            turnoFinalizado = true;
                        }
                        case 2 -> {
                            j.exibirStatus();
                        }
                        case 3 -> {
                            exibirRankingAtual();
                        }
                        case 0 -> {
                            System.out.println(j.getNome() + " passou a vez.");
                            turnoFinalizado = true;
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                }
            }


            jogadores.removeIf(Jogador::estaFalido);

            if (jogadores.size() == 1) {
                System.out.println("\nApenas um jogador não está falido. Encerrando o jogo...");
                break;
            }
        }

        encerrarJogo();
    }

    private void encerrarJogo() {
        System.out.println("\n=== FIM DE JOGO! ===");

        jogadores.sort((j1, j2) -> Double.compare(j2.calcularPatrimonio(), j1.calcularPatrimonio()));

        System.out.println("--- RANKING FINAL ---");
        int pos = 1;
        int falidos = 0;

        for (Jogador j : jogadores) {
            boolean falido = j.estaFalido();
            if (falido) falidos++;

            if (pos == 1 && !falido) {
                System.out.printf(":D %dº - %s (VENCEDOR) - Patrimônio: R$ %.2f%n", pos++, j.getNome(), j.calcularPatrimonio());
            } else {
                System.out.printf("%dº - %s - Patrimônio: R$ %.2f %s%n", pos++, j.getNome(),
                        j.calcularPatrimonio(), falido ? "(Falido)" : "");
            }
        }

        if (jogadores.size() == 1) {
            System.out.println("\n " + jogadores.get(0).getNome() + " venceu por ser o único sobrevivente!");
        }

        System.out.println("\nTotal de jogadores falidos: " + falidos);
    }

    private void exibirRankingAtual() {
        ArvoreRanking ranking = new ArvoreRanking();
        for (Jogador j : jogadores) {
            ranking.inserir(j);
        }
        ranking.exibirRankingDecrescente();
    }
}
