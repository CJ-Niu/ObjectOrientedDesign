package Z_OOD.ParkingLotEducative;

// This class encapsulates a parking display board
class ParkingDisplayBoard {

    // fields
    private String id;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorBikeSpot motorBikeFreeSpot;
    private ElectricSpot electricFreeSpot;

    // method
    // 1. show empty spot number
    public void showEmptySpotNumber() {
        // initialize message
        String message = "";

        if (handicappedFreeSpot.isFree()) {
            message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
        } else {
            message += "Handicapped is Full";
        }
        message += System.lineSeparator();      // add new line

        if (compactFreeSpot.isFree()) {
            message += "Free Compact: " + compactFreeSpot.getNumber();
        } else {
            message += "Compact is Full";
        }
        message += System.lineSeparator();

        if (largeFreeSpot.isFree()) {
            message += "Free Large: " + largeFreeSpot.getNumber();
        } else {
            message += "Large is Full";
        }
        message += System.lineSeparator();

        if (motorBikeFreeSpot.isFree()) {
            message += "Free MotorBike: " + motorBikeFreeSpot.getNumber();
        } else {
            message += "MotorBike is Full";
        }
        message += System.lineSeparator();

        if(electricFreeSpot.isFree()){
            message += "Free Electric: " + electricFreeSpot.getNumber();
        } else {
            message += "Electric is full";
        }

        System.out.println(message);
    }

    // Method 2.
    ParkingSpot getHandicappedFreeSpot() {
        return handicappedFreeSpot;
    }
    void setHandicappedFreeSpot(HandicappedSpot spot) {

    }

    ParkingSpot getCompactFreeSpot() {
        return compactFreeSpot;
    }
    void setCompactFreeSpot(CompactSpot spot) {

    }

    ParkingSpot getLargeFreeSpot() {
        return compactFreeSpot;
    }
    void setLargeFreeSpot(LargeSpot spot) {

    }

    ParkingSpot getMotorBikeFreeSpot() {
        return motorBikeFreeSpot;
    }
    void setMotorBikeFreeSpot(MotorBikeSpot spot) {

    }

    ParkingSpot getElectricFreeSpot() {
        return electricFreeSpot;
    }
    void setElectricFreeSpot(ElectricSpot spot) {

    }


}
