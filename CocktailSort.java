public class CocktailSort {

    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo Cocktail Sort
     *
     * O Cocktail Sort é uma variação do Bubble Sort que melhora a eficiência ao fazer
     * uma passagem da esquerda para a direita e depois da direita para a esquerda
     * Ele continua passando pelo vetor até que nenhuma troca seja necessária, indicando
     * que o vetor está ordenado
     *
     * Complexidade de tempo: O(n^2) no pior e médio caso, O(n) no melhor caso (quando o vetor já está ordenado)
     * Complexidade de espaço: O(1) - ordenação in-place, sem uso adicional de memória
     * É um algoritmo não estável, pois pode alterar a ordem de elementos iguais
     */

    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static double[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

        boolean swapped = true;
        int start = 0;
        int end = tamanho - 1;

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
