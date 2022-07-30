package Z_OOD.FileSystem;

public class File extends Entry {

    private String content;
    private int size;

    // constructor
    public File(String n, Directory p, int size) {
        super(n, p);        // 调用parent class Entry的constructor --> public Entry(String n, Directory p)
        this.size = size;   // https://www.geeksforgeeks.org/super-keyword/
    }

    public int size() {
        return size;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String c) {
        content = c;
    }
}
