public class shellSort {
    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        // Define o intervalo inicial usando a sequência de Shell
        int intervalo = 1;
        while (intervalo < tamanho / 3) {
            intervalo = 3 * intervalo + 1;
        }

        // Loop de ordenação com o intervalo ajustado de acordo com a sequência de Shell
        while (intervalo > 0) {
            for (int i = intervalo; i < tamanho; i++) {
                int temp = vetor[i];
                int j = i;

                // Ordenação com inserção usando o intervalo atual
                while (j >= intervalo && vetor[j - intervalo] > temp) {
                    vetor[j] = vetor[j - intervalo];
                    j -= intervalo;
                    trocas++;
                    iteracoes++;
                }
                vetor[j] = temp;
                iteracoes++;
            }

            // Reduz o intervalo conforme a sequência de Shell
            intervalo = (intervalo - 1) / 3;
        }


        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
