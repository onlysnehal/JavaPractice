package designpattern;

import java.util.*;

/**
 * Implementation of Adapter pattern in Java.
 * The java.util.Map has no way to  automatically load a two dimensional array of objects
 * into a Map as key-value * pairs. This Java program creates an adapter class that does this. *
 * Read more: https://javarevisited.blogspot.com/2016/08/adapter-design-pattern-in-java-example.html#ixzz5n1AVB7Jl
 */
public class SimpleAdapterPattern {
    public static void main(String[] args) {
        String[][] array = {{"A", "Apple"}, {"B", "Banana"}, {"C", "Cat"}, {"D", "Dog"}};
        System.out.println("Array : " + Arrays.deepToString(array));
        //Adapter which converts 2D array to map
        MapAdapter mapAdapter = new MapAdapter(array);
        System.out.println("Array to Map : " + mapAdapter);
    }
}

/**
 * This class is an adapter which allows to create a Map by providing a two
 * dimensional array of keys and values. It extends AbstractMap class so that it
 * become a Map and can be passed around where a Map is needed. All other method
 * is implemented in AbstractMap except the adapter functionality which is
 * implemented in constructor of this class.
 * <p>
 * Reference  : https://javarevisited.blogspot.com
 */

class MapAdapter extends AbstractMap {
    private Map map;

    public MapAdapter(Object[][] array) {
        map = new HashMap();
        for (Object[] arrayMap : array) {
            map.put(arrayMap[0], arrayMap[1]);
        }
    }

    @Override
    public Set<Entry> entrySet() {
        return map.entrySet();
    }
}