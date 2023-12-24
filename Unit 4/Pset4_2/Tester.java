public class Tester {
    public static void main(String[] args) {
        DoublyList<Integer> list = new DoublyList<>();
        DoublyList<Integer> emptylist = new DoublyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.pop(5);
        System.out.println(list.toString());
        System.out.println(list.reverseToString());
        System.out.println(emptylist.toString());
    }
}
