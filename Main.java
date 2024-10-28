public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        int seed = 42; // Seed fixa para replicabilidade
        geradorNumeros gerador = new geradorNumeros(seed);

        for (int tamanho : tamanhos) {
            // Vetores para armazenar os resultados de 5 rodadas para cada algoritmo
            System.out.println("Tamanho vetor: " + tamanho);

            executarAlgoritmo("InsertSort", gerador, tamanho);
            executarAlgoritmo("SelectionSort", gerador, tamanho);
            executarAlgoritmo("ShellSort", gerador, tamanho);

            System.out.println("=============================================");
        }
    }

    private static void executarAlgoritmo(String nomeAlgoritmo, geradorNumeros gerador, int tamanho) {
        // Arrays para armazenar as métricas em 5 rodadas
        long[] temposExecucao = new long[5];
        int[] trocasTotais = new int[5];
        int[] iteracoesTotais = new int[5];

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
            }

            temposExecucao[i] = resultado[0];
            trocasTotais[i] = (int) resultado[1];
            iteracoesTotais[i] = (int) resultado[2];
        }

        // Calcula a média dos resultados e exibe
        calcularMediaResultados(temposExecucao, trocasTotais, iteracoesTotais, 5, nomeAlgoritmo);
    }

    // Calcula e exibe a média dos resultados para o algoritmo atual
    private static void calcularMediaResultados(long[] temposExecucao, int[] trocas, int[] iteracoes, int rodadas, String nomeAlgoritmo) {
        long tempoTotal = 0;
        int totalTrocas = 0;
        int totalIteracoes = 0;

        for (int i = 0; i < rodadas; i++) {
            tempoTotal += temposExecucao[i];
            totalTrocas += trocas[i];
            totalIteracoes += iteracoes[i];
        }

        System.out.println("Algoritmo: " + nomeAlgoritmo);
        System.out.println("Tempo médio de execução: " + (tempoTotal / rodadas) + " ns");
        System.out.println("Número médio de trocas: " + (totalTrocas / rodadas));
        System.out.println("Número médio de iterações: " + (totalIteracoes / rodadas));
        System.out.println();
    }
}
