import java.util.Scanner;
import java.util.Random;
 
public class task3 {
    /*
     * Вывод информации о работе
     */
    static void printInfo() {
        System.out.println("Фамилия разработчика:\t\tЖарков\n" +
                "Дата и время получения задания:\t2023-11-24 13:36:37\n" +
                "Дата и время сдачи задания:\t2024-02-04 18:30:00\n");
    }

    static int[][] exchangeRows (int[][] matrix, int row1, int row2){
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
        return matrix;
    }

    static int[][] exchangeColumns (int[][] matrix, int col1, int col2){
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
        return matrix;
    }


    public static void main(String[] args) {
        printInfo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите размерность квадтратной матрици и заменяемый элемент:");
        int n = Integer.parseInt(scan.nextLine());
        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        int xNew = 0;
        int yNew = 0;

        System.out.println("Введите значения матрицы " + n + " на " + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
                if (matrix[i][j] < matrix[xNew][yNew]){
                    xNew = i;
                    yNew = j;
                }
            }
        }

        matrix = exchangeRows (matrix, x, xNew);
        matrix = exchangeColumns (matrix, y, yNew);

        System.out.println("\nИтоговая матрица:");
        System.out.println ();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print (matrix[i][j]+"\t");
            }
            System.out.println ();
        }
    }

}
