public class Main {
    /*
     * Método que define os tamanhos dos vetores, gera os vetores aleatórios para cada tamanho,
     * e chama os algoritmos de ordenação para realizar 5 rodadas de teste. No final, exibe
     * os resultados médios de tempo de execução, número de trocas e número de iterações
     * para cada algoritmo e cada tamanho de vetor.
     */
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int seed = 42; // Seed fixa para replicabilidade
        geradorNumeros gerador = new geradorNumeros(seed);

        // Loop para executar os algoritmos de ordenação para cada tamanho de vetor
        for (int tamanho : tamanhos) {
            System.out.println("Tamanho vetor: " + tamanho);

            executarAlgoritmo("InsertSort", gerador, tamanho);
            executarAlgoritmo("SelectionSort", gerador, tamanho);
            executarAlgoritmo("ShellSort", gerador, tamanho);
            executarAlgoritmo("CocktailSort", gerador, tamanho); // Adicionado CocktailSort
            executarAlgoritmo("GnomeSort", gerador, tamanho);    // Adicionado GnomeSort

            System.out.println("=============================================");
        }
    }

    private static void executarAlgoritmo(String nomeAlgoritmo, geradorNumeros gerador, int tamanho) {
        // Arrays para armazenar as métricas em 5 rodadas
        long[] temposExecucao = new long[5];
        long[] trocasTotais = new long[5];
        long[] iteracoesTotais = new long[5];

        for (int i = 0; i < 5; i++) {
            int[] vetor = gerador.gerarVetor(tamanho);
            long[] resultado = new long[3];

            // Executa o algoritmo de acordo com o nome
            switch (nomeAlgoritmo) {
                case "InsertSort":
                    resultado = insertSort.ordenar(vetor, tamanho);
                    break;
                case "SelectionSort":
                    resultado = selectionSort.ordenar(vetor, tamanho);
                    break;
                case "ShellSort":
                    resultado = shellSort.ordenar(vetor, tamanho);
                    break;
                case "CocktailSort":
                    resultado = CocktailSort.ordenar(vetor, tamanho);
                    break;
                case "GnomeSort":
                    resultado = GnomeSort.ordenar(vetor, tamanho);
                    break;
            }
            // Armazena os resultados da rodada nos arrays correspondentes
            temposExecucao[i] = resultado[0];
            trocasTotais[i] = resultado[1];
            iteracoesTotais[i] = resultado[2];
        }

        // Calcula a média dos resultados e exibe
        calcularMediaResultados(temposExecucao, trocasTotais, iteracoesTotais, 5, nomeAlgoritmo);
    }

    /*
     * Este método soma os tempos de execução, as trocas e as iterações de todas as rodadas,
     * calcula a média de cada métrica e exibe o resultado médio para o algoritmo atual.
     */
    private static void calcularMediaResultados(long[] temposExecucao, long[] trocas, long[] iteracoes, int rodadas, String nomeAlgoritmo) {
        long tempoTotal = 0;
        long totalTrocas = 0;
        long totalIteracoes = 0;

        // Soma os valores de todas as rodadas para calcular as médias
        for (int i = 0; i < rodadas; i++) {
            tempoTotal += temposExecucao[i];
            totalTrocas += trocas[i];
            totalIteracoes += iteracoes[i];
        }

        System.out.println("Algoritmo: " + nomeAlgoritmo);
        System.out.println("Tempo médio de execução: " + ((tempoTotal / 1000) / rodadas) + " ms");
        System.out.println("Número médio de trocas: " + (totalTrocas / rodadas));
        System.out.println("Número médio de iterações: " + (totalIteracoes / rodadas));
        System.out.println();
    }
}
