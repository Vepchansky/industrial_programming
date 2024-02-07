import java.util.Scanner;
//import java.util.Random;
//import java.time.LocalTime;
//import java.util.List;
//import java.util.ArrayList;

public class task3 {

    public static void main(String[] args){
        float x = 1.2f;
        float y = 2.5f;

        Vector a = new Vector(x, y);
        Vector b = new Vector(2.1f, 1.4f, 3.6f);
        System.out.println(a);
        System.out.println(b);

    }
}

/* ======================
 * Реализуем класс Вектор
 * ======================
 */

class Vector {

    private float x;
    private float y;
    private float z;
    private byte dimension;

    // Определяем конструкторы

    Vector() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
        this.dimension = 2;
    }

    Vector(float first, float second) {
        this.x = first;
        this.y = second;
        this.dimension = 2;
    }

    Vector(float first, float second, float third) {
        this.x = first;
        this.y = second;
        this.z = third;
        this.dimension = 3;
    }

    // Определяем геттеры

    public float getXC() { return this.x; }
    public float getYC() { return this.y; }
    public float getZC() { return this.z; }

    // Определяем сеттеры

    //public void setLuxurySeats(int lSeats) { this.luxurySeats = lSeats; }
    
    // Основные методы класса

    public float getLength() {
        return 1.0f;
    }


    public String toString() {
        String stringFormat;

        if ( this.dimension == 2)
            stringFormat = "\nВектор:\t(" + this.x + ", " + this.y + ") " +
                            "R^" + this.dimension;
        else //( this.dimension == 3 )
            stringFormat = "\nВектор:\t(" + this.x + ", " + this.y + ", " + this.z + ") " +
                            "R^" + this.dimension;

        return stringFormat;

    }


}
