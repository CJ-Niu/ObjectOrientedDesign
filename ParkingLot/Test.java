package Z_OOD.ParkingLot;
import java.util.*;

public class Test {

//    public static void main (String[] args) {
//
//        Test t = new Test();
//
//        ParkingLot lot = t.new ParkingLot(4, 10);
//
//        List<Vehicle> list = new ArrayList<>();
//
//        for (int i = 0; i < 50; i++) {
//            final Vehicle v = i % 2 == 0 ? t.new Car() : t.new Truck();
//            list.add(v);
//            boolean hasSpot = lot.hasSpot(v);
//
//            if (i < 40) {
//                assert hasSpot;
//                assert lot.park(v);
//            } else {
//                assert !hasSpot;
//                assert !lot.park(v);
//            }
//        }
//
//        assert list.size() == 50;
//        int i = 0;
//
//        for (Vehicle v : list) {
//            assert i >= 40 || lot.leave(v);
//            i++;
//        }
//    }

    public class findCommand {

        // findCommand should return a list of File
        // input: file (can be single file or directory), list of filters

        public List<File> findWithFilter(File directory, List<Filter> filters) {
            // corner case: if input file is not an directory
            if (!directory.isDirectory) {
                throw new IllegalArgumentException("Not a Directory!");
            }
            // data structure
            List<File> result = new ArrayList<>();
            findWithFilter(directory, filters, result);
            return result;
        }

        // recursion
        private void findWithFilter(File directory, List<Filter> filters, List<File> result) {
            // base case: if no more children
            if (directory.children == null) {
                return;
            }
            // recursive rule
            for (File f : directory.children) {
                if (f.isDirectory) {
                    findWithFilter(f, filters, result);
                } else {
                    boolean addFile = true;
                    // check all filter
                    for (Filter filter : filters) {
                        if (!filter.ifApply(f)) {
                            addFile = false;
                        }
                    }
                    // if add
                    if (addFile) {
                        result.add(f);
                    }
                }
            }
        }

    }

    // each File should have:
    //	- name, size, type, is directory or not, list of children file
    private class File {
        String name;
        int size;
        int type;
        FileType fileType;
        boolean isDirectory;
        List<File> children;
    }

    private enum FileType {
        xml,
        doc,
        jpg,
        pdf,
        ppt; // ...
    }

    abstract class Filter {
        abstract boolean ifApply(File file);
    }

    // size filter should have a field size
    class SizeFilter extends Filter {
        int size;
        // constructor
        SizeFilter(int size) {
            this.size = size;
        }
        // method
        @Override
        boolean ifApply(File file) {
            if (!file.isDirectory && file.size >= size) {
                return true;
            }
            return false;
        }
    }

    // type filter should have a field type
    class TypeFilter extends Filter {
        //int type;
        FileType fileType;

        // constructor
        TypeFilter(FileType type) {
            this.fileType = type;
        }
        // method
        @Override
        boolean ifApply(File file) {
            if (!file.isDirectory && file.fileType.equals(fileType)) {
                return true;
            }
            return false;
        }
    }
}
