import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a ordem para a matriz quadrada NxN: ");
        int n = scan.nextInt();

        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("\nDigite o valor da posição " + i + j + ": ");
                matriz[i][j] = scan.nextInt();
            }
        }

        System.out.println("\nMatriz original: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Array para guardar as diagonais:
        int[] diagonalPrincipal = new int[n];
        int[] diagonalSecundaria = new int[n];

        // Guarda as diagonais:
        for (int i = 0; i < n; i++) {
            diagonalPrincipal[i] = matriz[i][i];
            diagonalSecundaria[i] = matriz[i][(n - 1) - i];
        }

        // Inverte as diagonais:
        for (int i = 0; i < n; i++) {
            matriz[i][i] = diagonalPrincipal[(n - 1) - i];
            matriz[i][(n - 1) - i] = diagonalSecundaria[(n - i) - 1];
        }

        System.out.println("\nMatriz com as diagonais principal e secundária invertidas: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
