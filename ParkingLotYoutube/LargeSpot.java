package Z_OOD.ParkingLotYoutube;

public class LargeSpot extends ParkingSpot {

    // constructor
    public LargeSpot() {
        this.hourlyRatio = 10;
    }

    // method
    public void park(ParkingLot parkingLot, ParkingSpot largeSpot) {
        parkingLot.largeID++;
        this.parkingLocation = "" + parkingLot.largeID;

        parkingLot.availableLargeSpot--;
        parkingLot.largeSpotMap.put("" + parkingLot.largeID, largeSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot largeSpot) {
        parkingLot.largeSpotMap.remove(largeSpot.parkingLocation);
        parkingLot.availableLargeSpot++;
    }
}
