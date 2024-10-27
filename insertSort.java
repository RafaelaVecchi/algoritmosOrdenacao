public class insertSort {
    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        for (int i = 1; i < tamanho; i++) {
            int chave = vetor[i];
            int j = i - 1;

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
