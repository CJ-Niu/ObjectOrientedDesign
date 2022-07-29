package Z_OOD.ParkingLotEducative;
import java.util.Date;

class ParkingTicket {
    // fields
    private int number;
    private Date startTime;
    private Date endTime;
    private String licensePlate;

    // constructor
    ParkingTicket(Date startTime) {
        this.startTime = startTime;
    }

    // method
    public int getTicketNumber() {
        return number;
    }
}
