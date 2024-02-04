import java.util.Scanner;
import java.util.Random;
 
public class task2 {
    /*
     * Вывод информации о работе
     */
    static void printInfo() {
        System.out.println("Фамилия разработчика:\t\tЖарков\n" +
                "Дата и время получения задания:\t2023-11-24 13:36:37\n" +
                "Дата и время сдачи задания:\t2024-02-04 18:30:00\n");
    }

    /*
     * Метод для создания интервала
     */
    static int[] getInterval() {

        int[] interval = new int[2];

        System.out.print("Введите начальное значение интервала n: ");
        Scanner scan = new Scanner(System.in);
        interval[0] = scan.nextInt();
        System.out.print("Введите конечное значение интервала m: ");
        interval[1] = scan.nextInt();
        scan.close();
        return interval;

    }
    
    static int getRandom(int[] interval) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(interval.length + 1) + interval[0];
        return randomNumber;
    }

    public static void main(String[] args) {
        int[] interval;
        int k;

        task2.printInfo();
        interval = getInterval();

        k = getRandom(interval);
        System.out.println("Случайное число k: " + k);

        System.out.println("Случайное число k=" + k + " принадлежит интервалам:");
        if (k == interval[0])
        {
            System.out.println("1) [" + interval[0] + "," + interval[1] + ")");
            System.out.println("2) [" + interval[0] + "," + interval[1] + "]");
        }
        else if (k == interval[1])
        {
            System.out.println("1) (" + interval[0] + "," + interval[1] + "]");
            System.out.println("2) [" + interval[0] + "," + interval[1] + "]");
        }
        else
        {
            System.out.println("1) [" + interval[0] + "," + interval[1] + "]");
            System.out.println("2) (" + interval[0] + "," + interval[1] + ")");
            System.out.println("3) (" + interval[0] + "," + interval[1] + "]");
            System.out.println("4) [" + interval[0] + "," + interval[1] + ")");
        }
    }
}
