package Z_OOD.ParkingLotYoutube;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    // Data structure
    Map<String, ParkingSpot> compactSpotMap = new HashMap<>();
    Map<String, ParkingSpot> largeSpotMap = new HashMap<>();
    Map<String, ParkingSpot> handicapSpotMap = new HashMap<>();
    Map<String, Ticket> ticketMap = new HashMap<>();

    // Fields
    // hard code spot number
    int availableCompactSpot = 100;
    int availableLargeSpot = 100;
    int availableHandicapSpot = 100;

    // index for parking spot
    int compactID = 0;
    int largeID = 100;
    int handicapID = 200;

    // Public API
    // 1. Park()
    public Ticket park(String vehicleType) throws Exception {
        // 1. check do we have enough space
        if (checkFull(vehicleType)) {
            throw new Exception("Sorry, ParkingLot is Full!");
        }

        // 2. handle park spot update
        ParkingSpot parkingSpot = getParkingSpot(vehicleType);
        parkSpotUpdate(parkingSpot);

        // 3. handle ticket creation
        Ticket ticket = new Ticket();
        ticket.setEnter(Timestamp.from(Instant.now().minus(3, ChronoUnit.HOURS)));      // 3 for Test
        ticket.setParkingLocation(parkingSpot.parkingLocation);
        ticket.setHourlyRatio(parkingSpot.hourlyRatio);
        ticket.setParkingSpot(parkingSpot);
        ticketMap.put(parkingSpot.parkingLocation, ticket);     // put in ticket map

        System.out.println("Welcome Enter ParkingLot: You enter at time: " + ticket.getEnter());
        System.out.println("Your vehicle type is: " + vehicleType);
        System.out.println("Your parking location is: " + ticket.getParkingLocation());

        return ticket;
    }

    // 2. Exit()
    public Ticket exit(String parkingLocation) {
        // 1. get location from map
        Ticket ticket = ticketMap.get(parkingLocation);

        // 2. update parking spaces
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.exit(this, parkingSpot);

        // 3. calculate fees
        ticket.calculate();
        System.out.println("You have parked from" + ticket.getEnter() + " to " + ticket.getExit());
        System.out.println("Total fee is: " + ticket.getChargeAmount() + " | hourly ratio: " + ticket.getHourlyRatio());

        return ticket;
    }

    // Helper Method: update parking spot
    private void parkSpotUpdate(ParkingSpot parkingSpot) {
        parkingSpot.park(this, parkingSpot);
    }

    // Helper Method: get parking spot
    private ParkingSpot getParkingSpot (String vehicleType) throws Exception {
        if (vehicleType.equals("large")) {
            return new LargeSpot();
        } else if (vehicleType.equals("compact")) {
            return new CompactSpot();
        } else if (vehicleType.equals("handicap")){
            return new HandicapSpot();
        }
        throw new Exception("Invalid Vehicle Type");
    }

    // Helper Method: check if parking lot is full for current vehicle type
    private boolean checkFull(String vehicleType) throws Exception {
        if (vehicleType.equals("large")) {
            return availableLargeSpot <= 0;
        } else if (vehicleType.equals("compact")) {
            return availableCompactSpot <= 0;
        } else if (vehicleType.equals("handicap")){
            return availableHandicapSpot <= 0;
        }
        throw new Exception("Invalid Vehicle Type");
    }
}
