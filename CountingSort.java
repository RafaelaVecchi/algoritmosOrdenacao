public class CountingSort {
    /*
     * Ordena o vetor de inteiros em ordem crescente usando o algoritmo de Counting Sort
     *
     * O Counting Sort conta as ocorrências de cada número e usa essas contagens
     * para determinar as posições corretas dos elementos no vetor de saída
     *
     * complexidade de tempo: O(n + k), onde n é o número de elementos e k é o valor máximo
     * complexidade de espaço: O(k)
     * é um algoritmo de ordenação estável, preservando a ordem de elementos iguais
     */
    public static double[] ordenar(int[] vetor, int tamanho) {
        long inicio = System.currentTimeMillis(); // Início da contagem do tempo
        long trocas = 0;
        long iteracoes = 0;

        // Encontra o valor máximo no vetor
        int max = vetor[0];
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i] > max) {
                max = vetor[i]; // Atualiza o máximo encontrado
            }
            iteracoes++;
        }

        // Cria um array de contagem e um array de saída
        int[] count = new int[max + 1]; // Array para contar ocorrências
        int[] output = new int[tamanho]; // Array para os resultados ordenados

        // Conta as ocorrências de cada elemento
        for (int i = 0; i < tamanho; i++) {
            count[vetor[i]]++;
            iteracoes++;
        }

        // Acumula as contagens para determinar as posições
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            iteracoes++;
        }

        // Preenche o array de saída com base nas contagens acumuladas
        for (int i = tamanho - 1; i >= 0; i--) {
            output[count[vetor[i]] - 1] = vetor[i]; // Coloca o elemento na posição correta
            count[vetor[i]]--;
            trocas++;
            iteracoes++;
        }

        // Copia o array de saída de volta para o vetor original
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = output[i];
            iteracoes++;
        }

        long fim = System.currentTimeMillis();
        double tempoExecucao = (fim - inicio);
        return new double[]{tempoExecucao, trocas, iteracoes};
    }
}
