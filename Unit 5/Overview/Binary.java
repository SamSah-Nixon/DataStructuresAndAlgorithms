public class Binary{

    public static void main(String[] args){
        int n = 45;
        System.out.println("Decimal: " + n);
        System.out.println("Binary: " + toBinaryStack(n));
        System.out.println("Binary: " + toBinaryQueue(n));
    }
    public static int toBinaryStack(int n){
        Stack<Integer> stack = new Stack<Integer>();
        while(n > 0){
            stack.push(n % 2);
            n /= 2;
            System.out.println("Number: "+ n+" Stack: "+ stack.toString() );
        }
        String binary = "";
        while(!stack.isEmpty()){
            binary += stack.pop();
        }
        return Integer.parseInt(binary);
    }
    public static int toBinaryQueue(int n){
        Queue<Integer> queue = new Queue<Integer>();
        while(n > 0){
            queue.enQueue(n % 2);
            n /= 2;
            System.out.println("Number: "+ n+" Stack: "+ queue.toString());
        }
        String binary = "";
        while(!queue.isEmpty()){
            binary = queue.deQueue() + binary;
        }
        return Integer.parseInt(binary);
    }
}