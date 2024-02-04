import java.util.Scanner;

public class task2 {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте размер массива: ");
        int n = in.nextInt();
        if (n < 3) {
            System.out.println("Мал размер массива!");
            System.exit(0);
        }
        System.out.println("Вводите последовательность чисел: ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == (arr[i - 1] + arr[i + 1]) / 2) {
                System.out.println("Число " + arr[i] + " равно полусумме соседних элементов");
            }
        }
        in.close();
    }
}
