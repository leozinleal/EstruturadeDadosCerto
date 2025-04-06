import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matriz matriz = null;
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU MATRIZ ---");
            System.out.println("1. Criar nova matriz");
            System.out.println("2. Preencher manualmente");
            System.out.println("3. Preencher aleatoriamente");
            System.out.println("4. Adicionar elemento");
            System.out.println("5. Remover elemento");
            System.out.println("6. Exibir matriz");
            System.out.println("7. Ordenar linhas (Bubble Sort)");
            System.out.println("8. Ordenar colunas (Bubble Sort)");
            System.out.println("9. Ordenar matriz completa (Merge Sort)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número de linhas: ");
                    int linhas = sc.nextInt();
                    System.out.print("Número de colunas: ");
                    int colunas = sc.nextInt();
                    matriz = new Matriz(linhas, colunas);
                    System.out.println("Matriz criada com sucesso.");
                    break;

                case 2:
                    if (matriz != null) {
                        matriz.preencherMatrizManual();
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 3:
                    if (matriz != null) {
                        System.out.print("Valor mínimo: ");
                        int min = sc.nextInt();
                        System.out.print("Valor máximo: ");
                        int max = sc.nextInt();
                        matriz.preencherMatrizRandom(min, max);
                        System.out.println("Matriz preenchida aleatoriamente.");
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 4:
                    if (matriz != null) {
                        System.out.print("Linha: ");
                        int l = sc.nextInt();
                        System.out.print("Coluna: ");
                        int c = sc.nextInt();
                        System.out.print("Valor: ");
                        int v = sc.nextInt();
                        matriz.addElemento(l, c, v);
                        System.out.println("Elemento adicionado.");
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 5:
                    if (matriz != null) {
                        System.out.print("Linha: ");
                        int l = sc.nextInt();
                        System.out.print("Coluna: ");
                        int c = sc.nextInt();
                        matriz.removeElemento(l, c);
                        System.out.println("Elemento removido.");
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 6:
                    if (matriz != null) {
                        matriz.exibirMatriz();
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 7:
                    if (matriz != null) {
                        matriz.ordenarLinhas();
                        System.out.println("Linhas ordenadas com Bubble Sort.");
                        matriz.exibirMatriz();
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 8:
                    if (matriz != null) {
                        matriz.ordenarColunas();
                        System.out.println("Colunas ordenadas com Bubble Sort.");
                        matriz.exibirMatriz();
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 9:
                    if (matriz != null) {
                        matriz.ordenarMatrizCompleta();
                        System.out.println("Matriz completa ordenada com Merge Sort.");
                        matriz.exibirMatriz();
                    } else {
                        System.out.println("Crie a matriz primeiro!");
                    }
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}
