package Z_OOD.AmazonOnlineShoppingSystem;
import java.util.Date;
import java.util.List;

// After successfully placing an order, a shipment record will be created
class ShipmentShipmentLogAndNotification {

    public class ShipmentLog {
        private String shipmentNumber;
        private ShipmentStatus status;
        private Date creationDate;
    }

    public class Shipment {
        private String shipmentNumber;
        private Date shipmentDate;
        private Date estimatedArrival;
        private String shipmentMethod;
        private List<ShipmentLog> shipmentLogs;

        public boolean addShipmentLog(ShipmentLog shipmentLog) {
            this.shipmentLogs = shipmentLogs;
            return true;
        }
    }

    public abstract class Notification {
        private int notificationID;
        private Date createdOn;
        private String content;

        public boolean sendNotification(Account account) {
            // implementation...
            return true;
        }
    }
}
