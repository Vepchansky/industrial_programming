import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;

public class task1 {
    public static void main(String[] args){

        Train t1 = new Train();

        System.out.println(t1.getDestPoint());

    }
}

class Train {

    private String destPoint;
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

    //Train() {
    //}

    public String  getDestPoint() {
        return this.destPoint;
    }

}
