package Z_OOD.ParkingLotEducative;
import java.util.HashMap;

// This class encapsulates a parking floor
class ParkingFloor {
    private String name;

    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorBikeSpot> motorBikeSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private ParkingDisplayBoard displayBoard;
    // private HashMap<String, CustomerInfoPortal> infoPortals;

    // constructor
    public ParkingFloor(String name) {
        this.name = name;
    }

    // method
    // Method 1. add parking spot
    public void addParkingSpot(ParkingSpot spot) {
        // switch keyword
        switch (spot.getType()) {
            // case statements
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
                break;
            case MOTORBIKE:
                motorBikeSpots.put(spot.getNumber(), (MotorBikeSpot) spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
                break;
            default:
                System.out.print("Wrong Parking Spot Type!");
        }
    }

    // Method 2. assign vehicle to parking spot (make NO SENSE)
    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        boolean assign = spot.assignVehicle(vehicle);
        if (!assign) {
            System.out.println("Current Spot Not Available!");
            return;
        }

        switch(spot.getType()) {
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            case COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(spot);
                break;
            case MOTORBIKE:
                updateDisplayBoardForMotorBike(spot);
                break;
            case ELECTRIC:
                updateDisplayBoardForElectric(spot);
                break;
            default:
                System.out.println("Wrong Parking Spot Type!");
        }
    }

    // Method 3. update display board for ...
    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber().equals(spot.getNumber())) {
            // find another free handicapped spot and assign to display board
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                    break;
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber().equals(spot.getNumber())) {
            // fina another free compact spot and assign to display board
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                    break;
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForLarge(ParkingSpot spot) {
        if (this.displayBoard.getLargeFreeSpot().getNumber().equals(spot.getNumber())) {
            // fina another free compact spot and assign to display board
            for (String key : largeSpots.keySet()) {
                if (largeSpots.get(key).isFree()) {
                    this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
                    break;
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForMotorBike(ParkingSpot spot) {
        if (this.displayBoard.getMotorBikeFreeSpot().getNumber().equals(spot.getNumber())) {
            // fina another free compact spot and assign to display board
            for (String key : motorBikeSpots.keySet()) {
                if (largeSpots.get(key).isFree()) {
                    this.displayBoard.setMotorBikeFreeSpot(motorBikeSpots.get(key));
                    break;
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForElectric(ParkingSpot spot) {
        if (this.displayBoard.getElectricFreeSpot().getNumber().equals(spot.getNumber())) {
            // fina another free compact spot and assign to display board
            for (String key : electricSpots.keySet()) {
                if (largeSpots.get(key).isFree()) {
                    this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
                    break;
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    // 4. free parking spot
    public void freeSpot(ParkingSpot spot) {
        boolean free = spot.removeVehicle();
        if (!free) {
            System.out.println("Spot is already free!");
            return;
        }

        switch (spot.getType()) {
            case HANDICAPPED:
                // freeHandicappedSpotCount++;
                break;
            case COMPACT:
                // freeCompactSpotCount++;
                break;
            case LARGE:
                // freeLargeSpotCount++;
                break;
            case MOTORBIKE:
                // freeMotorBikeCount++;
                break;
            case ELECTRIC:
                // freeElectricCount++;
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    // 4. is full
    public boolean isFull() {
        return false;
    }

}
