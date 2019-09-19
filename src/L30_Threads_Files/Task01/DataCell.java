package L30_Threads_Files.Task01;

import java.io.Serializable;

public class DataCell implements Serializable {
    private static int positions = 0;
    public String str;
    public int pos;

    public DataCell( String str ) {
        this.pos = positions++;
        this.str = str;
    }

    @Override
    public String toString() {
        String position = pos < 10 ? "0" + pos : Integer.toString(pos);
        return /*position + " - " +*/ str;
    }
}