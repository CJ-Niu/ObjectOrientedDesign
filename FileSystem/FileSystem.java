package Z_OOD.FileSystem;
import java.util.*;

public class FileSystem {

    private final Directory root;

    // constructor
    public FileSystem() {
        root = new Directory("/", null);
    }

    // resolve a path like:  /foo/bar
    private List<Entry> resolve(String path) {
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<Entry>(components.length + 1);
        entries.add(root);

        Entry entry = root;

        for(String component : components) {
            if (entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("invalid path: " + path);
            }
            if (!component.isEmpty()) {
                entry = ((Directory)entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);

        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exists: " + path);
        }

        String[] components = path.split("/");

        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);

        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    public void createFile(String path) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);

        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exist: " + path);
        }

        final String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) entries.get(entries.size() - 2);

        File file = new File(fileName, parent, 0);
        parent.addEntry(file);
    }

    // delete the file / directory with given path
    public void delete(String path) {
        // TODO
    }

    // Entry[] --> EntryInfo[]
    // list all immediate children of the directory specified by the given path
    public Entry[] list (String path) {
        // TODO
        return null;
    }

    // return total number of files / directories in FileSystem
    public int count() {
        // TODO
        return 0;
    }
}
