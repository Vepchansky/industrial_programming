import java.util.Scanner;
 
public class task1 {
    static void printInfo() {
        System.out.println("Фамилия разработчика:\t\tЖарков\n" +
                "Дата и время получения задания:\t2023-11-24 13:36:37\n" +
                "Дата и время сдачи задания:\t2024-02-04 18:30:00\n");
    }

    public static void main(String[] args) {
        task1.printInfo();
        System.out.print("Введите текст: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String longWord = "", shortWord = line;
        for (String s : line.split(" ")) {
            if (s.length() > longWord.length()) longWord = s;
            if (s.length() < shortWord.length()) shortWord = s;
        }
        System.out.println("Самое длинное слово: '" + longWord + "'");
        System.out.println("Длина: " + longWord.length());
        System.out.println("Самое короткое слово: '" + shortWord + "'");
        System.out.println("Длина: " + shortWord.length());
        scan.close();
    }
}
