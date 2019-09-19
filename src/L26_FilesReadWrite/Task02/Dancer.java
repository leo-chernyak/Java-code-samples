package L26_FilesReadWrite.Task02;

class Dancer implements Comparable<Dancer>{
    public final Count count;
    public final Countless countless;

    public Dancer(Count count, Countless countless) {
        this.count = count;
        this.countless = countless;
    }

    @Override
    public int compareTo(Dancer dancer) {
        return count.x + count.y - dancer.count.x  - dancer.count.y;
    }

    @Override
    public String toString() {
        return count.toString() + "\t" + countless.toString();
    }
}