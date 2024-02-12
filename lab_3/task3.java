import java.util.Scanner;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

public class task3 {
    public static List<Vector> setVector(List<Vector> testVectors) {
	testVectors.add(new Vector(100, 200));
	testVectors.add(new Vector(500, 1000, 0));
	testVectors.add(new Vector(-400, 200));
	testVectors.add(new Vector(100, 200));
	testVectors.add(new Vector(100, 200));
	testVectors.add(new Vector(100, 200));
	testVectors.add(new Vector(100, 200));
	testVectors.add(new Vector(100, 200));
	return testVectors;
    }

    public static void main(String[] args){
        List<Vector> vectors = task3.setVector(new ArrayList<Vector>());

        System.out.println("Дано:");
        System.out.println(vectors.get(0));
        System.out.println(vectors.get(1));
        System.out.println(vectors.get(2));

        System.out.println();
        System.out.println("Длина векторов:");
        System.out.println(vectors.get(0).getLength());
        System.out.println(vectors.get(1).getLength());

        System.out.println();
        System.out.println("Скалярное произведение векторов:");
        System.out.println(vectors.get(0).getScalar(vectors.get(1)));
        System.out.println(vectors.get(0).getScalar(vectors.get(2)));

        System.out.println();
        System.out.println("Сумма векторов:");
        System.out.println(vectors.get(0).getSum(vectors.get(1)));
        System.out.println(vectors.get(0).getSum(vectors.get(2)));

        System.out.println();
        System.out.println("Разность векторов:");
        System.out.println(vectors.get(0).getSub(vectors.get(1)));
        System.out.println(vectors.get(0).getSub(vectors.get(2)));

        System.out.println();
        System.out.println("Умножение вектора на константу:");
        System.out.println(vectors.get(0).getMulOnScal(2.0));
        System.out.println(vectors.get(1).getMulOnScal(2.0));

        System.out.println();
        System.out.println("Проверка векторов\n" + vectors.get(0) +
			   " и " + vectors.get(1) + " на коллинеарность:");
        System.out.println(Vector.isColl(vectors.get(0), vectors.get(1)));
        System.out.println(Vector.isColl(vectors.get(0), vectors.get(2)));

        System.out.println();
        System.out.println("Проверка векторов на ортогональность:");
        System.out.println(Vector.isOrth(vectors.get(0), vectors.get(1)));
        System.out.println(Vector.isOrth(vectors.get(0), vectors.get(2)));

    }
}

/* ======================
 * Реализуем класс Вектор
 * ======================
 */

class Vector {

    private double x;
    private double y;
    private double z;
    private byte dimension;

    // Определяем конструкторы

    Vector() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
        this.dimension = 2;
    }

    Vector(double first, double second) {
        this.x = first;
        this.y = second;
        this.dimension = 2;
    }

    Vector(double first, double second, double third) {
        this.x = first;
        this.y = second;
        this.z = third;
        this.dimension = 3;
    }

    // Определяем геттеры

    public double getXC() { return this.x; }
    public double getYC() { return this.y; }
    public double getZC() { return this.z; }

    // Определяем сеттеры

    //public void setLuxurySeats(int lSeats) { this.luxurySeats = lSeats; }
    
    // Основные методы класса
    // ==========================================

    // Длина векторов
    public double getLength() {
        return Math.sqrt(Math.pow(this.x, 2) +
                Math.pow(this.y, 2) +
                Math.pow(this.z, 2));
    }

    // Скалярное произведение двух векторов
    public double getScalar(Vector second) {
        return  this.x * second.x +
                this.y * second.y +
                this.z * second.z;
    }

    // Сумма двух векторов
    public Vector getSum(Vector second) {
        if ( this.dimension == 2 & 
                second.dimension == 2 )
            return new Vector(this.x + second.x,
                              this.y + second.y);
        else
            return new Vector(this.x + second.x,
                              this.y + second.y,
                              this.z + second.z);
    }

    // Разность двух векторов
    public Vector getSub(Vector second) {
        if ( this.dimension == 2 & 
                second.dimension == 2 )
            return new Vector(this.x - second.x,
                              this.y - second.y);
        else
            return new Vector(this.x - second.x,
                              this.y - second.y,
                              this.z - second.z);
    }

    // Умножение вектора на константу
    public Vector getMulOnScal(double scalar) {
        if ( this.dimension == 2 )
            return new Vector(this.x * scalar,
                              this.y * scalar);
        else
            return new Vector(this.x * scalar,
                              this.y * scalar,
                              this.z * scalar);
    }

    // Определение коллинеарности
    
    public static boolean isColl(Vector first, Vector second) {
	    boolean collinearity = false;
	    double cosine;

	    cosine = first.getScalar(second) / (first.getLength() * second.getLength());

	    if ( cosine == 1 || cosine == -1 ) collinearity = true ;

	    return collinearity;
    }
    
    // Определение ортогональности
    
    public static boolean isOrth(Vector first, Vector second) {
	    boolean orthogonality = false;
	    double cosine;

	    cosine = first.getScalar(second) / (first.getLength() * second.getLength());

	    if ( cosine == 0 ) orthogonality = true ;

	    return orthogonality;
    }
    
    // Метод для вывода строчной информации
 
    public String toString() {
        String stringFormat;

        if ( this.dimension == 2)
            stringFormat = "(" + String.format(Locale.GERMAN, "%,.2f",this.x) +
		    	    "; " + String.format(Locale.GERMAN, "%,.2f", this.y) + ") " +
                            "R^" + this.dimension;
        else //( this.dimension == 3 )
            stringFormat = "(" + String.format(Locale.GERMAN, "%,.2f",this.x) +
		    	    "; " + String.format(Locale.GERMAN, "%,.2f", this.y) +
			    "; " + String.format(Locale.GERMAN, "%,.2f", this.z) + ") " +
                            "R^" + this.dimension;

        return stringFormat;

    }


}
