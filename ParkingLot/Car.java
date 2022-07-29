package Z_OOD.ParkingLot;

public class Car extends Vehicle {
    @Override                                       // 到子类（Car || Truck)的时候，再实例化getSize()
    public VehicleSize getSize() {                  // 返回Compact或者是Large
        return VehicleSize.Compact;
    }
}