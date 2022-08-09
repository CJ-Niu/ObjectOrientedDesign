package Z_OOD.LinuxFindCommand;

class MinSizeFilter extends Filter{

    int minSize;

    // constructor
    public MinSizeFilter(int minSize) {
        this.minSize = minSize;
    }

    @Override
    boolean apply(File file) {
        return file.size > minSize;
    }
}
