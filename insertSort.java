public class insertSort {
    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Insertion Sort.
     *
     * Este método percorre o vetor da esquerda para a direita, inserindo cada elemento na
     * posição correta dentro da parte já ordenada do vetor.
     */
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        // Inicia o Insertion Sort no vetor
        for (int i = 1; i < tamanho; i++) {
            int chave = vetor[i];
            int j = i - 1;

            // Move os elementos maiores que a chave para a direita
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
                iteracoes++;
            }
            vetor[j + 1] = chave;
            iteracoes++;
        }

        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
