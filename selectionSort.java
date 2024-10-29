public class selectionSort {
    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Selection Sort.
     *
     * Este método percorre o vetor para encontrar o menor elemento em cada iteração do loop
     * principal e o coloca na posição correta no início da parte ainda não ordenada do vetor.
     *
     * */
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

        // Inicia o Selection Sort no vetor
        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;

            // Encontra o menor elemento no restante do vetor
            for (int j = i + 1; j < tamanho; j++) {
                iteracoes++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Realiza a troca se o menor elemento não estiver na posição inicial
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
                trocas++;
            }
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
