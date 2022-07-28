package Z_OOD.AmazonOnlineShoppingSystem;

// the required enums, data types, and constants
class EnumsDataTypesAndConstants {

    public class Address {
        private String streetAddress;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public enum OrderStatus {
        UNSHIPPED, PENDING, SHIPPED, COMPLETED, CANCELED, REFUND_APPLIED
    }

    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOW
    }

    public enum ShipmentStatus {
        PENDING, SHIPPED, DELIVERED, ON_HOLD
    }

    public enum PaymentStatus {
        UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
    }
}
