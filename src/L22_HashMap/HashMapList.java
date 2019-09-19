package L22_HashMap;

import java.util.*;


public class HashMapList<Key, Value> implements Iterable<Map.Entry<Key, ArrayList<Value>>>, Iterator<Map.Entry<Key, ArrayList<Value>>> {
    private Map<Key, ArrayList<Value>> map = new HashMap<>();
    private int count = 0;

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(Object o) {
        return map.containsKey(o);
    }

    public boolean containsValue(Object o) {
        Collection list = values();
        return list.contains(o);
    }

    public ArrayList<Value> get(Object o) {
        return map.get(o);
    }

    public ArrayList<Value> put(Key o, Value o2) {
        if ( containsKey(o) ) { get(o).add((Value) o2); }
        else {
            map.put((Key) o, new ArrayList<>(){{add((Value) o2);}});
        }
        return map.get(o);
    }

    public void clear() {
        map.clear();
    }

    public Set keySet() {
        return map.keySet();
    }

    public Collection values() {
        ArrayList<Value> list = new ArrayList<>();
        for (ArrayList<Value> values : map.values()) {
            list.addAll(values);
        }
        return list;
    }

    public Set<Map.Entry<Key, ArrayList<Value>>> entrySet() {
        return map.entrySet();
    }

    @Override
    public Iterator<Map.Entry<Key, ArrayList<Value>>> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return map.size() > count;
    }

    @Override
    public Map.Entry<Key, ArrayList<Value>> next() {
        var key = keySet().toArray()[count++];
        return new AbstractMap.SimpleEntry<>((Key) key, get(key));
    }
}