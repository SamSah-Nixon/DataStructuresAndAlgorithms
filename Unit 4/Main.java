public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(6);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(4);
        list.print();
        System.out.println("\n"+list.size());
    }
}
