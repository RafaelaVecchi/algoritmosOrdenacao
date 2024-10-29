public class shellSort {
/*
 * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Shell Sort.
 *
 * Este método utiliza a sequência de intervalos de Shell para realizar uma ordenação
 * eficiente por inserção. O intervalo é inicialmente grande e é reduzido gradualmente,
 * permitindo que elementos distantes sejam comparados e movimentados para posições
 * corretas rapidamente
 * */
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

        // Define o intervalo inicial usando a sequência de Shell
        int intervalo = 1;
        while (intervalo < tamanho / 3) {
            intervalo = 3 * intervalo + 1;
        }

        // Loop de ordenação com o intervalo ajustado, que diminui gradualmente
        while (intervalo > 0) {
            for (int i = intervalo; i < tamanho; i++) {
                int temp = vetor[i];
                int j = i;

                // Move os elementos do subvetor que são maiores que temp para a direita
                while (j >= intervalo && vetor[j - intervalo] > temp) {
                    vetor[j] = vetor[j - intervalo];
                    j -= intervalo;
                    trocas++;
                    iteracoes++;
                }
                vetor[j] = temp;
                iteracoes++;
            }

            // Reduz o intervalo de acordo com a sequência de Shell, preparando para a próxima iteração
            intervalo = (intervalo - 1) / 3;
        }


        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
