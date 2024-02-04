import java.util.Scanner;

public class task3 {
        public static void main(String[] args) {
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
