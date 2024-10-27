import java.util.Random;

public class geradorNumeros {
    private final Random random;

    public geradorNumeros(int seed) {
        this.random = new Random(seed);  // Seed fixa para replicabilidade
    }

    public int[] gerarVetor(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(1000000); // Valores entre 0 e 999999
        }
        return vetor;
    }
}
