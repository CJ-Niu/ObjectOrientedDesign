package Z_OOD.ParkingLotYoutube;

public class HandicapSpot extends ParkingSpot {

    // constructor
    public HandicapSpot() {
        this.hourlyRatio = 2;
    }

    // method
    public void park(ParkingLot parkingLot, ParkingSpot handicapSpot) {
        parkingLot.handicapID++;
        this.parkingLocation = "" + parkingLot.handicapID;

        parkingLot.availableHandicapSpot--;
        parkingLot.handicapSpotMap.put("" + parkingLot.handicapID, handicapSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot handicapSpot) {
        parkingLot.handicapSpotMap.remove(handicapSpot.parkingLocation);
        parkingLot.availableHandicapSpot++;
    }
}
