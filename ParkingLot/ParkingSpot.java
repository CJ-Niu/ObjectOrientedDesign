package Z_OOD.ParkingLot;
import java.util.*;

class ParkingSpot {
    // 每一个parking spot需要有的属性：size，current parked vehicle
    private final VehicleSize size;             // 每一个ParkingSpot的size确定以后不可改变
    private Vehicle currentVehicle;

    // constructor
    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    // method:	fit, park, leave, getter
    // when can fit?
    //	1. current spot is empty, no vehicle
    //	2. current spot size is >= vehicle size
    boolean fit(Vehicle v) {
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
        // 第一个getSize()是Vehicle里面的size，第二个是enum里面的size
        // enum里的getter getSize()返回int，这样才能对比大小，不能直接对比‘Compact’和‘Large’的大小

        // &&短路法，第一个表达式的值为FALSE，那么整个逻辑表达式的值为FALSE，第二个表达式不计算
        // p1 && p2，Java先计算p1，若p1为true再计算p2

        // 只有当currentVehicle为Null时，才说明这个车位是空的，才能停新车进来
    }

    void park(Vehicle v) {
        // record a vehicle is parked in by updating the currentVehicle field
        currentVehicle = v;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getVehicle() {
        return currentVehicle;
    }

}

