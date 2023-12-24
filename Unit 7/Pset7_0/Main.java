
public class Main {
    public static void main(String[] args){
        MyListMap<String, Integer> myMap = new MyListMap<>();
        System.out.println(myMap.put("a", 1));
        System.out.println(myMap.put("b", 2));
        System.out.println(myMap.put("c", 3));
        System.out.println(myMap.put("d", 4));
        System.out.println(myMap.put("e", 5));
        System.out.println();
        System.out.println(myMap.contains("e"));
        System.out.println(myMap.contains("f"));
        System.out.println();
        try {
            System.out.println(myMap.get("a"));
            System.out.println(myMap.get("c"));
        } catch (KeyError e) {
            System.out.println("KeyError");
        }
        System.out.println(myMap.set("d", 100));
        System.out.println(myMap.set("f", 6));
        System.out.println();
        try {
            System.out.println(myMap.get("d"));
            System.out.println(myMap.get("f"));
        } catch (KeyError e) {
            System.out.println("KeyError");
        }
        System.out.println();
        System.out.println(myMap.keys());
        System.out.println(myMap.values());
        System.out.println(myMap.items());
        System.out.println(myMap.remove("d"));
        System.out.println(myMap.items());
        System.out.println(myMap.items());
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.size());
        System.out.println(myMap.toString());
    }
}
