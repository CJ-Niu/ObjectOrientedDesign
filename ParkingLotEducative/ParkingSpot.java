package Z_OOD.ParkingLotEducative;

public abstract class ParkingSpot {
    private String number;      // the number for each parking spot (why not use int?)
    private boolean free;       // if the parking spot has no vehicle parked on it
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public boolean isFree() {
        return free;
    }

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (free) {
            this.vehicle = vehicle;
            free = false;
            return true;
        }
        return false;
    }

    public boolean removeVehicle() {
        if (!free) {
            this.vehicle = null;
            free = true;
            return true;
        }
        return false;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
