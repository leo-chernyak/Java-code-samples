package L24_Map.Task02;

import java.util.Comparator;

public class HunamComparator implements Comparator<Human> {
    @Override
    public int compare(Human lhs, Human rhs) {
        if ( lhs.getHealth() != rhs.getHealth() ) return lhs.getHealth() - rhs.getHealth();
        return lhs.name.compareTo(rhs.name);
    }
}
