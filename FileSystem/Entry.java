package Z_OOD.FileSystem;

public abstract class Entry {

    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    // constructor
    public Entry(String n, Directory p) {
        name = n;
        parent = p;
        created = System.currentTimeMillis();
    }

    // Public API:
    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int size();

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getCreationTime() {
        return created;
    }

    public long getLastUpdatedTime() {
        return lastUpdated;
    }

    public long getLastAccessedTime() {
        return lastAccessed;
    }

    public Entry getChild(String s) {
        // TODO
        return null;
    }
}
