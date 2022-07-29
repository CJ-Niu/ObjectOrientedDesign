package Z_OOD.ParkingLotEducative;

public abstract class Vehicle {
    // fields
    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;
    // constructor
    public Vehicle(VehicleType type) {
        this.type = type;
    }
    // method
    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public VehicleType getType() {
        return type;
    }
}