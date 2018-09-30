package java8;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Example to demonstrate sort HashMap by value object property
 */
public class HashMapSortByValues {

    public static void main(String args[]) {

        HashMapSortByValues hashMapSortByValues = new HashMapSortByValues();
        Person p1 = new Person("abc", 22);
        Person p2 = new Person("xyz", 10);
        Person p3 = new Person("mno", 35);
        Person p4 = new Person("def", 21);

        Map<String, Person> personMap = new HashMap<>();
        personMap.put("abc", p1);
        personMap.put("xyz", p2);
        personMap.put("mno", p3);
        personMap.put("def", p4);

        // Print Map
        System.out.println("HashMap before sorting");
        hashMapSortByValues.printMap(personMap.entrySet());
        List<Map.Entry<String, Person>> list = hashMapSortByValues.sortWithoutUsingStream(personMap);


        //Print Map after sorting
        System.out.println("HashMap sorting by values without using Java 8 stream");
        hashMapSortByValues.printMap(list);


        // Print Map
        System.out.println("HashMap sorting by values using Java 8 stream");
        hashMapSortByValues.printMap(hashMapSortByValues.sortUsingStream(personMap).entrySet());


    }

    private List<Map.Entry<String, Person>> sortWithoutUsingStream(Map<String, Person> personMap) {
        /**
         * Steps to sort Map by value object property
         * 1. Get EntrySet to list
         * 2. Sort list using Collections.sort
         */
        List<Map.Entry<String, Person>> list = new ArrayList<>(personMap.entrySet());
        //Sort Map by values without Java 8 Stream
        Collections.sort(list, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1, Map.Entry<String, Person> o2) {
                return ((Integer) o1.getValue().getAge()).compareTo((Integer) o2.getValue().getAge());
            }
        });
        return list;
    }

    private void printMap(Collection<Map.Entry<String, Person>> collection) {
        // Print Map
        for (Map.Entry<String, Person> entry : collection) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private Map<String, Person> sortUsingStream(Map<String, Person> map) {
        //Java 8 stream
        return map
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().getAge() - e2.getValue().getAge())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}