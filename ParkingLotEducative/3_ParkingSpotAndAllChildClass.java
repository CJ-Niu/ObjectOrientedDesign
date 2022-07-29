package Z_OOD.ParkingLotEducative;

// Definition of ParkingSpot and all of its children classes
class ParkingSpotAndAllChildClass {

    public abstract class ParkingSpot {
        private String number;
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
    }

    public class HandicappedSpot extends ParkingSpot {
        public HandicappedSpot() {
            super(ParkingSpotType.HANDICAPPED);
        }
    }

    public class CompactSpot extends ParkingSpot {
        public CompactSpot() {
            super(ParkingSpotType.COMPACT);
        }
    }

    public class LargeSpot extends ParkingSpot {
        public LargeSpot() {
            super(ParkingSpotType.LARGE);
        }
    }

    public class MotorBikeSpot extends ParkingSpot {
        public MotorBikeSpot() {
            super(ParkingSpotType.MOTORBIKE);
        }
    }

    public class ElectricSpot extends ParkingSpot {
        public ElectricSpot() {
            super(ParkingSpotType.ELECTRIC);
        }
    }
}
