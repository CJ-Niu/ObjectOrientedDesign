package Z_OOD.ParkingLotYoutube;

// 用abstract class好做扩展
public abstract class ParkingSpot {
    // common fields
    public String parkingLocation;
    public float hourlyRatio;

    // common method
    public abstract void park(ParkingLot parkingLot, ParkingSpot parkSpot);

    public abstract void exit(ParkingLot parkingLot, ParkingSpot parkSpot);
}
