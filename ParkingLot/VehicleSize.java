package Z_OOD.ParkingLot;

public enum VehicleSize {
    // 为什么要用enum，不用int?
    //  1. 用int的话，用户可以随便设计，比如给个负数，还要考虑edge case，精度太高
    //  2. 假设将来某一层需要50个compact车位 + 100个large车位，这些车位的size如果用int的话怎么设计？
    //     怎么确保Large车位的size能让所有的Truck都停进来？所以如果用int来设计size就太麻烦了
    // 用enum就是有了一个标准，类似床的size (full, queen, king)
    // 我们现在就是要在Vehicle和ParkingSpot之间，就size的问题达成一致的“标准”

    Compact(1),                 // 这里是逗号，不是分号
    Large(2);                   // 之所以Large设定为2，Compact设定为1     Compact < Large
    // 是因为考虑到小车可以停进大车的车位，但大车没法停进小车的车位
    private final int size;

    // constructor
    VehicleSize(int size) {
        this.size = size;
    }
    // getter
    public int getSize() {
        return size;
    }
}