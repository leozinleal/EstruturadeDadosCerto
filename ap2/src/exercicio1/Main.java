package exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila<Pedido> pedidosPendentes = new Fila<>();
        Pilha<Pedido> pedidosCancelados = new Pilha<>();
        Scanner sc = new Scanner(System.in);
        int opcao;
        int i = 1;

        do {
            System.out.println("MENU");
            System.out.println("1 - Adicionar Novo Pedido");
            System.out.println("2 - Atender Pedido");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("4 - Restaurar Pedido Cancelado");
            System.out.println("5 - Imprimir Pedidos Pendentes");
            System.out.println("6 - Imprimir Pedidos Cancelados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do pedido: ");
                    String descricao = sc.nextLine();
                    Pedido pedido = new Pedido(String.valueOf(i++), descricao);
                    pedidosPendentes.enfilerar(pedido);
                    System.out.println("Pedido adicionado: " + pedido);
                    break;

                case 2:
                    Pedido atendido = pedidosPendentes.desenfilerar();
                    if (atendido != null) {
                        System.out.println("Pedido atendido: " + atendido);
                    }
                    break;

                case 3:
                    Pedido cancelado = pedidosPendentes.desenfilerar();
                    if (cancelado != null) {
                        pedidosCancelados.empilhar(cancelado);
                        System.out.println("Pedido cancelado: " + cancelado);
                    }
                    break;

                case 4:
                    Pedido restaurado = pedidosCancelados.desempilhar();
                    if (restaurado != null) {
                        pedidosPendentes.enfilerar(restaurado);
                        System.out.println("Pedido restaurado para fila: " + restaurado);
                    }
                    break;

                case 5:
                    pedidosPendentes.exibir();
                    break;

                case 6:
                    pedidosCancelados.exibir();
                    break;

                case 0:
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}