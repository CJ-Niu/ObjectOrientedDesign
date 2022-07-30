package Z_OOD.FileSystem;
import java.util.*;

public class Directory extends Entry {

    private List<Entry> contents;

    // constructor
    public Directory(String n, Directory p) {
        super(n, p);
        contents = new ArrayList<Entry>();
    }

    protected List<Entry> getContents() {
        return contents;
    }

    public int size() {
        int size = 0;

        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numOfFiles() {
        int count = 0;

        for (Entry e : contents) {
            if (e instanceof Directory) {       // if current Entry is a Directory
                count++;                        //  Step 1. count Directory itself, every Directory counts as a file
                Directory d = (Directory) e;    //  Step 2. count each Directory's number of files
                count += d.numOfFiles();
            } else if (e instanceof File) {     // if current Entry is a File
                count++;                        //  just count each file
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry e) {
        return contents.remove(e);
    }

    public void addEntry(Entry e) {
        contents.add(e);
    }
}
