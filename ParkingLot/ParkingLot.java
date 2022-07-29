package Z_OOD.ParkingLot;
import java.util.*;

public class ParkingLot {
    // ParkingLot should have array of Level
    private final Level[] levels;

    // constructor
    public ParkingLot (int numLevels, int numSpotsPerLevel) {
        levels = new Level[numLevels];

        for (int i = 0; i < numLevels; i++) {
            levels[i] = new Level(numSpotsPerLevel);
        }
    }

    // method:	hasSpot, park, leave
    public boolean hasSpot(Vehicle v) {
        for (Level l : levels) {
            if (l.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        for (Level l : levels) {
            if (l.park(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        for (Level l : levels) {
            if (l.leave(v)) {
                return true;
            }
        }
        return false;
    }
}
