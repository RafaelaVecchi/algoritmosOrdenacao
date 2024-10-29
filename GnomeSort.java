public class GnomeSort {

    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

        int i = 0;

        while (i < tamanho) {
            iteracoes++;
            if (i == 0 || vetor[i] >= vetor[i - 1]) {
                i++; // Avança se os elementos estiverem em ordem
            } else {
                // Troca os elementos
                int temp = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = temp;
                trocas++;
                i--; // Retrocede para verificar o elemento anterior
            }
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        // Retorna as métricas no formato esperado: [tempoExecucao, numeroTrocas, numeroIteracoes]
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
