package L30_Threads_Files.Task01;

import java.util.ArrayList;
import java.util.Random;

public class CommonResources {
    private static final String SOURSE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private ArrayList<DataCell> dataCells;
    public int jobs;
    private int pos;

    {
        jobs = 0;
        pos = 0;
    }

    public CommonResources(ArrayList<String> list){
        this.dataCells = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.dataCells.add(new DataCell(list.get(i)));
        }
    }
    public CommonResources(){
        dataCells = new ArrayList<>();
        fillDataCells();
    }

    public synchronized void jobDone() {
        jobs++;
    }
    public synchronized DataCell getDataCell() {
        return isCan() ? dataCells.get(pos++) : null;
    }
    public ArrayList<DataCell> getDatas() {
        return (ArrayList<DataCell>) dataCells.clone();
    }
    public synchronized boolean isCan() { return  pos < dataCells.size(); }
    public void print() {
        dataCells.forEach(dataCell -> {
                    System.out.print(dataCell + "\t");
                    if (dataCell.pos % 10 == 9 ) System.out.println();
                }
        );
    }

    private void fillDataCells() {
        for (int i = 0; i < 50; i++) {
            dataCells.add( new DataCell(generateString(5)) );
        }
    }
    private String generateString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( SOURSE.charAt( new Random().nextInt(SOURSE.length()) ) );
        return sb.toString();
    }
}