package Z_OOD.ParkingLotYoutube;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class Ticket {

    // fields
    private String parkingLocation;
    private Timestamp enter;
    private Timestamp exit;
    private float hourlyRatio;
    private float chargeAmount;
    private ParkingSpot parkingSpot;

    // method
    public void calculate() {
        this.exit = Timestamp.from(Instant.now());
        Duration duration = Duration.between(enter.toLocalDateTime(), this.exit.toLocalDateTime());
        this.chargeAmount = duration.toHours() * hourlyRatio;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getParkingLocation() {
        return parkingLocation;
    }

    public Timestamp getEnter() {
        return enter;
    }

    public Timestamp getExit() {
        return exit;
    }

    public float getChargeAmount() {
        return chargeAmount;
    }

    public float getHourlyRatio() {
        return hourlyRatio;
    }

    public void setEnter (Timestamp timestamp) {
        enter = timestamp;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public void setHourlyRatio(Float ratio) {
        this.hourlyRatio = ratio;
    }


}
