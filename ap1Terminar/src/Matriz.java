import java.util.Random;
import java.util.Scanner;

public class Matriz {

    /// Primeiramente declarei os atributos, sendo dados a matriz

    private int[][] dados;
    private int linhas;
    private int colunas;

    /*Após isso informei os construtores de minha classe, onde o usuario vai estar passando
    a linha e coluna que a matriz vai ter, criando a matriz com as informações baseada nos construtores*/

    public Matriz (int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];
    }

    /*método preencher a matriz manualmente, onde vai percorrer com o for as linhas e colunas, usando o scanner para ler os dados inserido
    do usuario*/

    public void preencherMatrizManual(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Digite o valor para [" + i + "][" + j + "]: ");
                dados[i][j] = sc.nextInt();
            }
        }
    }

    /*método para preencher com valores aleatórios passado num range definido pelo usuário, é percorrido
   com o for também a matriz, utilizando um laço, porém é preenchido com o RANDOM*/
    public void preencherMatrizRandom(int min, int max){
        Random r = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = min + r.nextInt(max - min);
            }
        }
    }


    /*método para adicionar elemento passando a linha, coluna e o valor que vai entrar novo, faz uma verificação
    para ver se vai estar dentro dos parametros, apos isso adiciona o valor pedido*/
    public void addElemento(int linha, int coluna, int valor){
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            dados[linha][coluna] = valor;
        }
    }


    /*passado a linha e coluna que deseja remover o elemento, para usar como base de removido é adicionado um 0 no lugar
    do número anterior, também faz a verificação antes*/
    public void removeElemento(int linha, int coluna){
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            dados[linha][coluna] = 0;
        }
    }

    /*Exibi a matriz completo ao usuario, utilizando um laço que passa por todas as posiçoes*/
    public void exibirMatriz(){
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(dados[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /// Bubble Sort aplicado a uma linha, basicamente compara elementos vizinhos e troca de lugar se estiver fora de ordem
    private void bubbleSort(int[] array) {
        int n = array.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    /// Ordenar cada linha com Bubble Sort
    public void ordenarLinhas() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(dados[i]);
        }
    }

    /// Ordenar cada coluna com Bubble Sort
    public void ordenarColunas() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = dados[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                dados[i][j] = coluna[i];
            }
        }
    }

    /// Ordenar matriz completa com Merge Sort
    public void ordenarMatrizCompleta() {
        int total = linhas * colunas;
        int[] vetor = new int[total];

        /// Achatar matriz
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = dados[i][j];
            }
        }

        /// Ordenar vetor
        mergeSort(vetor, 0, total - 1);

        /// Reconstruir matriz
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = vetor[index++];
            }
        }
    }

    /// Merge Sort recursivo
    private void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercalar(vetor, inicio, meio, fim);
        }
    }

    /// Função auxiliar para mergeSort
    private void intercalar(int[] vetor, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (vetor[i] <= vetor[j]) {
                temp[k++] = vetor[i++];
            } else {
                temp[k++] = vetor[j++];
            }
        }

        while (i <= meio) temp[k++] = vetor[i++];
        while (j <= fim) temp[k++] = vetor[j++];

        for (i = inicio, k = 0; i <= fim; i++, k++) {
            vetor[i] = temp[k];
        }
    }

    /* As diferenças entre os algoritmos de ordenação implementados e em quais casos um é mais eficiente que o outro:

    Bubble Sort: Compara um elemento ao lado do outro, se estão fora de ordem troca de posição, onde repete o processo várias vezes
    até a lista ficar ordenada. Mais efeciente para casos em que a quantidade de elementos é pequena, como ao ordenar linha por linha ou coluna por coluna de uma matriz.


    Merge Sort: Divide o vetor em duas metades, ordena cada metade recursivamente e depois intercala as duas partes já ordenadas. Mais efeciente
    para ordenar grandes volumes de dados,

     */
}
