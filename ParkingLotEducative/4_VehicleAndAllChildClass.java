package Z_OOD.ParkingLotEducative;

// Definition for Vehicle and all of its child classes
class VehicleAndAllChildClass {

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
    }

    public class Car extends Vehicle {
        public Car() {
            super(VehicleType.CAR);
        }
    }

    public class Van extends Vehicle {
        public Van() {
            super(VehicleType.VAN);
        }
    }

    public class Truck extends Vehicle {
        public Truck() {
            super(VehicleType.TRUCK);
        }
    }

    public class MotorBike extends Vehicle {
        public MotorBike() {
            super(VehicleType.MOTORBIKE);
        }
    }

    public class Electric extends Vehicle {
        public Electric() {
            super(VehicleType.ELECTRIC);
        }
    }
}
