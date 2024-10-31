public class CocktailSort {

    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static double[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

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

        long fim = System.currentTimeMillis();
        double tempoExecucao = (fim - inicio);

        return new double[]{tempoExecucao, trocas, iteracoes};
    }
}
