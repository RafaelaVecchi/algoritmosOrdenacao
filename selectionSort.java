public class selectionSort {
    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < tamanho; j++) {
                iteracoes++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Realiza a troca se necessário
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
                trocas++;
            }
        }

        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
