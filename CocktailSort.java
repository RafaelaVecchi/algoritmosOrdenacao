public class CocktailSort {

    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static long[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        boolean swapped = true;
        int start = 0;
        int end = tamanho - 1;

        /*
            enquanto tudo não estiver ordenado vamos rodar seguindo uma linha da esquerda até a direita
            e depois da direita para a esquerda, trocando os elementos de lugar
        */
        while (swapped) {
            swapped = false;

            // Passagem da esquerda para a direita
            for (int i = start; i < end; i++) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    // Troca os elementos
                    int valoratual = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = valoratual;
                    trocas++;
                    swapped = true;
                }
            }

            // Se não houve trocas, o array está ordenado
            if (!swapped) {
                break;
            }

            // Ajuste o fim para a próxima passagem
            end--;
            swapped = false;

            // Passagem da direita para a esquerda
            for (int i = end - 1; i >= start; i--) {
                iteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    // Troca os elementos
                    int valoratual = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = valoratual;
                    trocas++;
                    swapped = true;
                }
            }
            
            start++;
        }

        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;

        // Retorna as métricas no formato esperado: [tempoExecucao, numeroTrocas, numeroIteracoes]
        return new long[]{tempoExecucao, trocas, iteracoes};
    }
}
