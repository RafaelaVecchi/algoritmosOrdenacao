public class shellSort {
    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        // Define o intervalo inicial
        for (int intervalo = tamanho / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < tamanho; i++) {
                int temp = vetor[i];
                int j;

                for (j = i; j >= intervalo && vetor[j - intervalo] > temp; j -= intervalo) {
                    vetor[j] = vetor[j - intervalo];
                    trocas++;
                    iteracoes++;
                }
                vetor[j] = temp;
                iteracoes++;
            }
        }

        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
