import java.util.Scanner;
import java.util.Random;
class RandomNumbers {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private int N;
    private int[] myArray;
    public void setN(){
        System.out.print("Введите количество случайных чисел: ");
        N = scanner.nextInt();
    }
    public int getN(){
        return N;
    }
    public void setMyArray(int N){
        myArray = new int[N];
        for (int i = 0; i<N; i++){
            myArray[i] = random.nextInt(10);
        }
 
    }
    public void showMyArray(){
        System.out.print("Массив случайных чисел без перехода на новую строку: ");
        for (int i = 0; i<myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
    public void showLnMyArray(){
        System.out.println("Массив случайных чисел с переходом на новую строку: ");
        for (int i = 0; i<myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
}
public class task1 {
    public static void main(String[] args){
        RandomNumbers num = new RandomNumbers();
        num.setN();
        num.setMyArray(num.getN());
        num.showMyArray();
        num.showLnMyArray();
    }
}