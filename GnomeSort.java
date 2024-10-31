public class GnomeSort {

    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Gnome Sort
     *
     * O Gnome Sort é um algoritmo de ordenação simples que move os elementos
     * para frente e para trás como um gnome que planta flores na ordem correta
     * Se um elemento estiver fora de ordem, ele é trocado com o elemento anterior
     * e o algoritmo retrocede para verificar novamente
     *
     * Complexidade de tempo: O(n^2) no pior caso, O(n) no melhor caso (quando o vetor já está ordenado)
     * Complexidade de espaço: O(1) - ordenação in-place, sem uso adicional de memória
     * É um algoritmo não estável, pois pode alterar a ordem de elementos iguais
     */

    // Retorna um array com [tempoExecucao, numeroTrocas, numeroIteracoes]
    public static double[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis();
        long trocas = 0;
        long iteracoes = 0;

        int i = 0;

        // Enquanto não chegar ao final do vetor
        while (i < tamanho) {
            iteracoes++;
            if (i == 0 || vetor[i] >= vetor[i - 1]) {
                i++;
            } else {
                // Troca os elementos se estiverem fora de ordem
                int temp = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = temp;
                trocas++;
                i--; // Retrocede para verificar o elemento anterior
            }
        }

        long fim = System.currentTimeMillis();
        double tempoExecucao = (fim - inicio);

        // Retorna as métricas no formato esperado: [tempoExecucao, numeroTrocas, numeroIteracoes]
        return new double[]{tempoExecucao, trocas, iteracoes};
    }
}
