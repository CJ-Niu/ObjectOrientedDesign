package Z_OOD.LinuxFindCommand;
import java.util.ArrayList;
import java.util.List;

public class FindCommon {

    public List<File> findWithFilters(File directory, List<Filter> filters) {

        if (!directory.isDirectory) {
            throw new IllegalArgumentException("Not a Directory!");
        }

        List<File> output = new ArrayList<>();
        findWithFilters(directory, filters, output);
        return output;
    }

    private void findWithFilters(File directory, List<Filter> filters, List<File> output) {

        if (directory.children == null) {
            return;
        }

        for (File file : directory.children) {
            if (file.isDirectory) {
                findWithFilters(file, filters, output);
            } else {
                boolean selectFile = true;
                for (Filter filter : filters) {
                    if (!filter.apply(file)) {
                        selectFile = false;
                    }
                }
                if (selectFile) {
                    output.add(file);
                }
            }
        }
    }
}
