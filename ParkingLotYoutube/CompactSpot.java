package Z_OOD.ParkingLotYoutube;

public class CompactSpot extends ParkingSpot {

    // constructor
    public CompactSpot() {
        this.hourlyRatio = 5;
    }

    // method
    public void park(ParkingLot parkingLot, ParkingSpot compactSpot) {
        parkingLot.compactID++;
        this.parkingLocation = "" + parkingLot.compactID;

        parkingLot.availableCompactSpot--;
        parkingLot.compactSpotMap.put("" + parkingLot.compactID, compactSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot compactSpot) {
        parkingLot.compactSpotMap.remove(compactSpot.parkingLocation);
        parkingLot.availableCompactSpot++;
    }
}
