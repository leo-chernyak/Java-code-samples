package L09_Classes_Base_10.Task09;

public class Main {

    public static void main(String[] args) throws
            CloneNotSupportedException{
        Date date = new Date(1,7,2396);
        System.out.println("The season by date is: " + date.season());
        System.out.println("The season by days is: " + Date.seasonByDays(60));
        Date date1 = new Date(04,10,2000);
        Date date2 = new Date(05,12,2019);
        System.out.println(date1.diffInDays(date2));


        System.out.println(date1 + " - " + date2);
        // work
        // date1 = date2;
        // don't work
         Date.swap(date1, date2);
        // don't work
        //swap(date1, date2);
        System.out.println(date1 + " - " + date2);


        Carts[] carts = Carts.values();




        for (var card : carts)
            System.out.println(card.name());

    }
    public static void swap(Date date1, Date date2) {
        date1 = date2;
    }
}

