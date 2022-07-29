package Z_OOD.ParkingLotEducative;
import java.util.Date;
import java.util.HashMap;

// Our system will have only one object of this class
// This can be enforced by using the Singleton pattern
class ParkingLot {

    private String name;
    private String address;
    private double parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorBikeSpotCount;
    private int electricSpotCount;

    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorBikeCount;
    private final int maxElectricCount;

    // private HashMap<String, EntrancePanel> entrancePanels;
    // private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;
    private HashMap<Integer, ParkingTicket> activeTickets;   // all active parking tickets, identified by their ticketNumber

    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
    // similarly exit panels will also use this object to close parking tickets

    private static ParkingLot parkingLotInstance = null; // -- Lazy Initialization

    // Constructor: private constructor to restrict for singleton
    private ParkingLot() {
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //    this map should tell how many parking spots are there on each floor. This
        //    should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
        maxCompactCount = 100;
        maxLargeCount = 50;
        maxMotorBikeCount = 20;
        maxElectricCount = 20;
    }

    // static method to get the singleton instance of ParkingLot -- Lazy Initialization
    public static ParkingLot getInstance() {
        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot();
        }
        return parkingLotInstance;
    }

    // Method 1. get new parking ticket
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        if (this.isFull(vehicle.getType())) {
            System.out.println("Sorry, ParkingLot Full!");
        }
        Date startTime = new Date();
        ParkingTicket ticket = new ParkingTicket(startTime);
        vehicle.assignTicket(ticket);
        // ticket.saveInDB();

        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);

        // return
        return ticket;
    }

    // Method 2. check if parking lot is Full, base on the vehicle type
    public boolean isFull(VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.MOTORBIKE) {
            return motorBikeSpotCount >= maxMotorBikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount + maxElectricCount);
    }

    // Method 3. increment the parking spot count based on the vehicle type
    private void incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORBIKE) {
            motorBikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else {    // electric vehicle
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    // Method 4. ???
    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

//    public void addParkingFloor(ParkingFloor floor) {
//        /* store in database */ }

//    public void addEntrancePanel(EntrancePanel entrancePanel) {
//        /* store in database */ }

//    public void addExitPanel(ExitPanel exitPanel) {
//        /* store in database */ }
}
