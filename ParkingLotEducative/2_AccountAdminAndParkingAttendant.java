package Z_OOD.ParkingLotEducative;

// These classes represent【 Various People 】that interact with our system
class AccountAdminAndParkingAttendant {

    public abstract class Account {
        private String userName;
        private String passWord;
        private AccountStatus status;
        private Person person;

        public boolean resetPassword() {
            return false;
        }
    }

    public class Admin extends Account {

//        public boolean addParkingFloor(ParkingFloor floor);
//        public boolean addParkingSpot(String floorName, ParkingSpot spot);
//        public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
//        public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);


//        public boolean addEntrancePanel(EntrancePanel entrancePanel);
//        public boolean addExitPanel(ExitPanel exitPanel);
    }

    public class ParkingAttendant extends Account {

//        public boolean processTicket(String ticketNumber);
    }
}
