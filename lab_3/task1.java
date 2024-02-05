import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;

public class task1 {
    public static void main(String[] args){

        Train t1 = new Train();
        Train[] tm = {
            new Train(),
            new Train(),
            new Train(),
        };

        // Проверка методов get и set

        System.out.println(t1.getDestPoint());
        System.out.println(t1.getDepTime());

        // Проверка метода toString

        System.out.println(t1);
        System.out.println(tm[1]);


    }
}

class Train {

    private String destPoint = "Коломна";
    private int trainNumber;
    private LocalTime departureTime;
    private int totalSeats,
                compartmentSeats,
                reservedSeats,
                luxurySeats;

    {
        this.destPoint = "undefined";
        this.trainNumber = 0;
        this.departureTime = LocalTime.of(0, 0, 0);
        this.totalSeats = 0;
        this.compartmentSeats = 0;
        this.reservedSeats = 0;
        this.luxurySeats = 0;
    }

    Train() {
        this.setDestPoint("Голутвин");
        this.setTrainNum(6432);
        this.setDepTime(8,30,0);
        this.setTotalSeats(1000);
        this.setCompSeats(400);
        this.setReservedSeats(500);
        this.setLuxurySeats(100);
        
    }

    // Определяем геттеры

    public String  getDestPoint() { return this.destPoint; }
    public int  getTrainNum() { return this.trainNumber; }
    public LocalTime  getDepTime() { return this.departureTime; }
    public int  getTotalSeats() { return this.totalSeats; }
    public int  getCompSeats() { return this.compartmentSeats; }
    public int  getReservedSeats() { return this.reservedSeats; }
    public int  getLuxurySeats() { return this.luxurySeats; }

    // Определяем сеттеры

    public void setDestPoint(String dPoint) { this.destPoint = dPoint; }
    public void setTrainNum(int tNum) { this.trainNumber = tNum; }
    public void setDepTime(int h, int m, int s) {
        this.departureTime = LocalTime.of(h, m, s); 
    }
    public void setTotalSeats(int tSeats) { this.totalSeats = tSeats; }
    public void setCompSeats(int cSeats) { this.compartmentSeats = cSeats; }
    public void setReservedSeats(int rSeats) { this.reservedSeats = rSeats; }
    public void setLuxurySeats(int lSeats) { this.luxurySeats = lSeats; }
    
    public String toString() {
        String stringFormat;

        stringFormat = "\nПункт назначения:\t\t" + this.destPoint +
                        "\nНомер поезда:\t\t\t" + this.trainNumber +
                        "\nВремя отправления:\t\t" + this.departureTime +
                        "\nОбщее количество мест:\t\t" + this.totalSeats +
                        "\nМест купе:\t\t\t" + this.compartmentSeats +
                        "\nМест платцкарта:\t\t" + this.reservedSeats +
                        "\nМест люкс:\t\t\t" + this.luxurySeats;

        return stringFormat;

    }


}
