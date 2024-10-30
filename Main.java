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
            System.out.println("-----> Tamanho vetor: " + tamanho + "\n");

            executarAlgoritmo("InsertSort", gerador, tamanho);
            executarAlgoritmo("SelectionSort", gerador, tamanho);
            executarAlgoritmo("ShellSort", gerador, tamanho);
            executarAlgoritmo("CocktailSort", gerador, tamanho);
            executarAlgoritmo("GnomeSort", gerador, tamanho);

            System.out.println("=============================================");
        }
    }

    private static void executarAlgoritmo(String nomeAlgoritmo, geradorNumeros gerador, int tamanho) {
        // Arrays para armazenar as métricas em 5 rodadas
        double[] temposExecucao = new double[5];
        long[] trocasTotais = new long[5];
        long[] iteracoesTotais = new long[5];

        for (int i = 0; i < 5; i++) {
            int[] vetor = gerador.gerarVetor(tamanho);
            double[] resultado = new double[3];


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
            trocasTotais[i] = (long) resultado[1];
            iteracoesTotais[i] = (long) resultado[2];
        }

        // Calcula a média dos resultados e exibe
        calcularMediaResultados(temposExecucao, trocasTotais, iteracoesTotais, 5, nomeAlgoritmo);
    }

    /*
     * Este método soma os tempos de execução, as trocas e as iterações de todas as rodadas,
     * calcula a média de cada métrica e exibe o resultado médio para o algoritmo atual.
     */
    private static void calcularMediaResultados(double[] temposExecucao, long[] trocas, long[] iteracoes, int rodadas, String nomeAlgoritmo) {
        double tempoTotal = 0;
        long totalTrocas = 0;
        long totalIteracoes = 0;

        // Soma os valores de todas as rodadas para calcular as médias
        for (int i = 0; i < rodadas; i++) {
            tempoTotal += temposExecucao[i];
            totalTrocas += trocas[i];
            totalIteracoes += iteracoes[i];
        }

        // Calcula a média
        double tempoMedio = tempoTotal / rodadas;
        long trocasMedia = totalTrocas / rodadas;
        long iteracoesMedia = totalIteracoes / rodadas;

        System.out.println("Algoritmo: " + nomeAlgoritmo);
        System.out.println("Tempo médio de execução: " + tempoMedio + " ms");
        System.out.println("Número médio de trocas: " + trocasMedia);
        System.out.println("Número médio de iterações: " + iteracoesMedia);
        System.out.println();
    }
}
