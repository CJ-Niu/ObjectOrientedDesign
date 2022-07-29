package Z_OOD.ParkingLot;
import java.util.*;

class Level {
    // Level should have list of ParkingSpot
    private final List<ParkingSpot> spots;                          // 每一层停车位的数量&&类型是固定不变的，
    // 但final锁的是名片，不是名片里的内容，所以即使有final，我还是可以继续往这个List里面加ParkingSpot
    // constructor                                                  // 所以这里的final锁的是spots这个reference，只能指向当前的Level，不能指向其他的Level
    Level(int numOfSpots) {                                         // 要做到constructor完成后，spots list里面的内容无法被改变，就用Collections.unmodifiableList
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);

        int i = 0;                                                  // 车位一半设为Compact，另一半设为Large
        while (i < numOfSpots / 2) {
            list.add(new ParkingSpot(VehicleSize.Compact));
            i++;
        }
        while (i < numOfSpots) {
            list.add(new ParkingSpot(VehicleSize.Large));
            i++;
        }

        spots = Collections.unmodifiableList(list);                 // 每一层停车位的数量&&类型是固定不变的
    }                                                               // list初始化好之后，调用.unmodifiableList()保证不能被更改

    // method:	hasSpot, park, leave
    boolean hasSpot(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.fit(v)) {
                s.park(v);
                return true;
            }
        }
        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.getVehicle() == v) {
                s.leave();
                return true;
            }
        }
        return false;
    }

}