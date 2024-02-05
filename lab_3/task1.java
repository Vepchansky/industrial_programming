import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class task1 {
    public static List<Train> setTrains(List<Train> testTrains) {
       testTrains.add(new Train("Казань", 7777, LocalTime.of(8, 0, 0), new int[] {0, 600, 350, 50}));
       testTrains.add(new Train("Москва", 5555, LocalTime.of(19, 20, 0), new int[] {300, 0, 300, 0}));
       testTrains.add(new Train("Коломна", 1234, LocalTime.of(8, 30, 0), new int[] {300, 0, 0, 0}));
       testTrains.add(new Train("Москва", 4321, LocalTime.of(18, 0, 0), new int[] {0, 0, 500, 0}));
       testTrains.add(new Train("Коломна", 5234, LocalTime.of(12, 25, 0), new int[] {500, 0, 0, 0}));
       testTrains.add(new Train("Рязань", 6124, LocalTime.of(9, 40, 0), new int[] {500, 0, 400, 100}));
       testTrains.add(new Train("Рязань", 6124, LocalTime.of(14, 26, 0), new int[] {500, 0, 400, 100}));
       testTrains.add(new Train("Казань", 6666, LocalTime.of(22, 15, 0), new int[] {0, 600, 350, 50}));
       testTrains.add(new Train("Коломна", 1234, LocalTime.of(20, 4, 0), new int[] {500, 0, 0, 0}));
       testTrains.add(new Train("Казань", 7777, LocalTime.of(16, 50, 0), new int[] {0, 600, 350, 50}));
       return testTrains;
    }

    public static void main(String[] args){

        LocalTime testTime =  LocalTime.of(1, 2, 3);
        int[] testSeats = {100, 50, 30, 20};

        Train t1 = new Train();
        Train[] tm = {
            new Train(),
            new Train("Москва", 666, testTime),
            new Train("Казань", 7777, testTime, testSeats),
        };

        // Проверка методов get и set

        //System.out.println(t1.getDestPoint());
        //System.out.println(t1.getDepTime());

        // Проверка метода toString

        //System.out.println(t1);
        //System.out.println(tm[1]);
        //System.out.println(tm[2]);

        // Проверка заполнения массива

        List<Train> trains = task1.setTrains(new ArrayList<Train>());
        System.out.println(trains.get(2).getDestPoint());

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите пункт назначения: ");
        String destination = scan.nextLine();

        // Пункт задачи а
        System.out.println("Поезда следующие до " + destination);
        for(int i = 0; i < trains.size(); i++) {
            if ( trains.get(i).getDestPoint().equals(destination) )
            {
                System.out.println(trains.get(i));
            }
        }

        // Пункт задачи с
        System.out.println("Поезда следующие до " + destination +
                            " имеющие общие места:");
        for(int i = 0; i < trains.size(); i++) {
            if ( trains.get(i).getDestPoint().equals(destination) &
                    trains.get(i).getTotalSeats() > 0 )
            {
                System.out.println(trains.get(i));
            }
        }

        // Пункт задачи b
        System.out.print("Введите время отправления[hh mm]: ");
        int hours = scan.nextInt();
        int minutes = scan.nextInt();
        LocalTime timeDepart = LocalTime.of(hours, minutes);


        System.out.println("Поезда следующие до " + destination +
                            " после " + timeDepart + " :");
        for(int i = 0; i < trains.size(); i++) {
            if ( trains.get(i).getDestPoint().equals(destination) & 
                    trains.get(i).getDepTime().isAfter(timeDepart) )
            {
                System.out.println(trains.get(i));
            }
        }

        

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

    // Определяем конструкторы

    Train() {
        this.setDestPoint("Голутвин");
        this.setTrainNum(6432);
        this.setDepTime(8,30,0);
        this.setTotalSeats(1000);
        this.setCompSeats(400);
        this.setReservedSeats(500);
        this.setLuxurySeats(100);
        
    }

    Train(String destPoint) {
        this.setDestPoint(destPoint);
    }

    Train(String destPoint, int trainNum) {
        this.setDestPoint(destPoint);
        this.setTrainNum(trainNum);
    }

    Train(String destPoint, int trainNum, LocalTime depTime) {
        this.setDestPoint(destPoint);
        this.setTrainNum(trainNum);
        this.setDepTime(depTime);
    }

    Train(String destPoint, int trainNum, LocalTime depTime, int[] seats) {
        this.setDestPoint(destPoint);
        this.setTrainNum(trainNum);
        this.setDepTime(depTime);
        this.setTotalSeats(seats[0]);
        this.setCompSeats(seats[1]);
        this.setReservedSeats(seats[2]);
        this.setLuxurySeats(seats[3]);
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
    public void setDepTime(LocalTime depTime) {
        this.departureTime = depTime; 
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
