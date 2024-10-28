import java.util.Random;

public class geradorNumeros {
    /*
     * Objeto Random para gerar números aleatórios, inicializado com uma seed fixa
     * para garantir replicabilidade dos valores gerados em diferentes execuções.
     */
    private final Random random;

    public geradorNumeros(int seed) {
        this.random = new Random(seed);  // Seed fixa para replicabilidade
    }

    // Gera um vetor de inteiros aleatórios com o tamanho especificado.
    public int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(1000000); // Valores entre 0 e 999999
        }
        return vetor;
    }
}
