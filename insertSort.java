public class insertSort {
    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Insertion Sort.
     * Este método percorre o vetor da esquerda para a direita, inserindo cada elemento na
     * posição correta dentro da parte já ordenada do vetor.
     */
    public static double[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

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

        long fim = System.currentTimeMillis();
        double tempoExecucao = (fim - inicio); // Converte para milissegundos
        return new double[]{tempoExecucao, trocas, iteracoes};
    }
}
