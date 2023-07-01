import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String dimensao[] = new String[2];
        String linha[];

        System.out.println("Informe a quantidade de linhas e colunas da matriz A: ");
        dimensao = scan.nextLine().split(" ");
        int matrizA[][] = new int[Integer.parseInt(dimensao[0])][Integer.parseInt(dimensao[1])];
        linha = new String[Integer.parseInt(dimensao[0])];

        System.out.println("\nMatriz A: ");
        for (int l = 0; l < Integer.parseInt(dimensao[0]); l++) {
            System.out.println("\nInforme os elementos da linha " + l + ": ");
            linha = scan.nextLine().split(" ");

            for (int c = 0; c < Integer.parseInt(dimensao[1]); c++) {
                matrizA[l][c] = Integer.parseInt(linha[c]);
            }
        }

        System.out.println("\nInforme a quantidade de linhas e colunas da submatriz B: ");
        dimensao = scan.nextLine().split(" ");
        int submatrizB[][] = new int[Integer.parseInt(dimensao[0])][Integer.parseInt(dimensao[1])];
        linha = new String[Integer.parseInt(dimensao[0])];

        System.out.println("\nSubmatriz B: ");
        for (int l = 0; l < Integer.parseInt(dimensao[0]); l++) {
            System.out.println("\nInforme os elementos da linha " + l + ": ");
            linha = scan.nextLine().split(" ");

            for (int c = 0; c < Integer.parseInt(dimensao[1]); c++) {
                submatrizB[l][c] = Integer.parseInt(linha[c]);
            }
        }

        System.out.println(
                "\nA submatrizB pode ser encontrada " + matrizContem(matrizA, submatrizB) + " vez(es) na matrizA.\n");

    }

    public static int matrizContem(int[][] matrizA, int[][] submatrizB) {

        int count = 0;

        // Computa o tamanho das linhas e colunas das matrizes.
        int larguraMatrizA = matrizA[0].length;
        int alturaMatrizA = matrizA.length;
        int larguraSubmatrizB = submatrizB[0].length;
        int alturaSubmatrizB = submatrizB.length;

        // Percorre as linhas da matriz A (para localizar a submatriz B).
        for (int i = 0; i <= alturaMatrizA - alturaSubmatrizB; i++) {
            // Percorre as colunas da matriz A (para localizar a submatriz B).
            r: for (int j = 0; j <= larguraMatrizA - larguraSubmatrizB; j++) {

                // Percorre as linhas da matriz A e da submatriz B.
                for (int m = 0; m < alturaSubmatrizB; m++) {
                    // Percorre as colunas da matriz A e da submatriz B.
                    for (int n = 0; n < larguraSubmatrizB; n++) {

                        // Se as coordenadas tiverem valores diferentes interrompe o
                        // processo de percorrer a matriz A e a submatriz B juntas;
                        // salta para a próxima possibilidade na matriz A.
                        if (matrizA[i + m][j + n] != submatrizB[m][n]) {
                            continue r;
                        }

                    }
                }
                count += 1;
            }
        }

        return count;
    }
}
