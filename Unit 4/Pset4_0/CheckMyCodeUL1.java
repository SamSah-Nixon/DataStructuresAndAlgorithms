public class CheckMyCodeUL1{
	private static int testPassed = 0;
	private static double totalTest = 52;

	public static void main(String args[]){
		System.out.println("----------------------");
    	System.out.println("--- Starting Point ---");
    	System.out.println("----------------------");
		UnorderedList<Integer> myList = new UnorderedList<Integer>();
		System.out.println("Created UnorderedList<Integer> myList");
		System.out.println("size: " +myList.size());
		System.out.println("is Empty?: "+myList.isEmpty());
		testFunction((""+myList.isEmpty()), "true");
		testFunction((""+myList.toString()), "[]");

		System.out.println("\r\n----------------------");
    	System.out.println("--- add(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Adding element 1:");
		myList.add(1);
		testFunction((""+myList.toString()), "[1]");
		System.out.println("Adding element 4:");
		myList.add(4);
		testFunction((""+myList.toString()), "[4, 1]");
		System.out.println("Adding element 3:");
		myList.add(3);
		testFunction((""+myList.toString()), "[3, 4, 1]");
		System.out.println("Adding element 2:");
		myList.add(2);
		testFunction((""+myList.toString()), "[2, 3, 4, 1]");
		System.out.println("Adding element 4:");
		myList.add(4);
		testFunction((""+myList.toString()), "[2, 3, 4, 1]");
		System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "4");

		System.out.println("\r\n----------------------");
    	System.out.println("--- indexOf(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Index of element 4: " +myList.indexOf(4));
    	testFunction((""+myList.indexOf(4)), "2");
    	System.out.println("Index of element 3: " +myList.indexOf(3));
    	testFunction((""+myList.indexOf(3)), "1");
    	System.out.println("Index of element 1: " +myList.indexOf(1));
    	testFunction((""+myList.indexOf(1)), "3");
    	System.out.println("Index of element 2: " +myList.indexOf(2));
    	testFunction((""+myList.indexOf(2)), "0");
    	System.out.println("Index of element 12: " +myList.indexOf(12));
    	testFunction((""+myList.indexOf(12)), "-1");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "4");

    	System.out.println("\r\n----------------------");
    	System.out.println("--- remove() ---");
    	System.out.println("----------------------");
    	System.out.println("Removing element 10:");
    	testFunction((""+myList.remove(10)), "null");
    	System.out.println("Removing element 1:");
    	testFunction((""+myList.remove(1)), "1");
    	System.out.println("Removing element 3:");
    	testFunction((""+myList.remove(3)), "3");
    	System.out.println("Testing toString:\t");
    	testFunction((""+myList.toString()), "[2, 4]");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "2");

		System.out.println("\r\n----------------------");
    	System.out.println("--- append(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Appending element 2:");
		myList.append(2);
		testFunction((""+myList.toString()), "[2, 4]");
		System.out.println("Appending element 3:");
		myList.append(3);
		testFunction((""+myList.toString()), "[2, 4, 3]");
		System.out.println("Appending element 5:");
		myList.append(5);
		testFunction((""+myList.toString()), "[2, 4, 3, 5]");
		System.out.println("Appending element 17:");
		myList.append(17);
		testFunction((""+myList.toString()), "[2, 4, 3, 5, 17]");
		System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "5");

		System.out.println("\r\n----------------------");
    	System.out.println("--- pop() ---");
    	System.out.println("----------------------");
    	System.out.println("Popping first element:");
    	testFunction((""+myList.pop()), "2");
    	System.out.println("Popping first element:");
    	testFunction((""+myList.pop()), "4");
    	System.out.println("Popping first element:");
    	testFunction((""+myList.pop()), "3");
    	System.out.println("Popping first element:");
    	testFunction((""+myList.pop()), "5");
    	System.out.println("Testing toString:\t");
    	testFunction((""+myList.toString()), "[17]");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "1");

		System.out.println("\r\n----------------------");
    	System.out.println("--- insert(pos, item) ---");
    	System.out.println("----------------------");
    	System.out.println("Inserting element 4 at pos 0:");
		myList.insert(0, 4);
		testFunction((""+myList.toString()), "[4, 17]");
		System.out.println("Inserting element 12 at pos 1:");
		myList.insert(1, 12);
		testFunction((""+myList.toString()), "[4, 12, 17]");
		System.out.println("Inserting element 28 at pos 1:");
		myList.insert(1, 28);
		testFunction((""+myList.toString()), "[4, 28, 12, 17]");
		System.out.println("Inserting element 50 at pos 3:");
		myList.insert(3, 50);
		testFunction((""+myList.toString()), "[4, 28, 12, 50, 17]");
		System.out.println("Inserting element 1 at pos 0:");
		myList.insert(0, 1);
		testFunction((""+myList.toString()), "[1, 4, 28, 12, 50, 17]");
		System.out.println("Inserting element 4 at pos 0:");
		myList.insert(0, 4);
		testFunction((""+myList.toString()), "[1, 4, 28, 12, 50, 17]");
		System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "6");

		System.out.println("\r\n----------------------");
    	System.out.println("--- valueAt(pos) ---");
    	System.out.println("----------------------");
		System.out.println("!!!! "+myList.toString());
    	System.out.println("Value at position 3: " +myList.valueAt(3));
    	testFunction((""+myList.valueAt(3)), "12");
    	System.out.println("Value at position 0: " +myList.valueAt(0));
    	testFunction((""+myList.valueAt(0)), "1");
    	System.out.println("Value at position 5: " +myList.valueAt(5));
    	testFunction((""+myList.valueAt(5)), "17");
    	System.out.println("Value at position 4: " +myList.valueAt(4));
    	testFunction((""+myList.valueAt(4)), "50");
    	System.out.println("Value at position 6: " +myList.valueAt(6));
    	testFunction((""+myList.valueAt(6)), "null");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "6");

		System.out.println("\r\n----------------------");
    	System.out.println("--- contains(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Searching for element 3: ");
    	testFunction((""+myList.contains(3)), "false");
    	System.out.println("Searching for element 50: ");
    	testFunction((""+myList.contains(50)), "true");
    	System.out.println("Searching for element 1: ");
    	testFunction((""+myList.contains(1)), "true");
    	System.out.println("Searching for element 100: ");
    	testFunction((""+myList.contains(100)), "false");
    	System.out.println("Searching for element 5: ");
    	testFunction((""+myList.contains(5)), "false");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "6");

		System.out.println("\r\n----------------------");
    	System.out.println("--- front() ---");
    	System.out.println("----------------------");
    	System.out.println("Peaking at the front element: ");
    	testFunction((""+myList.front()), "1");
    	System.out.println("Testing toString:\t");
    	testFunction((""+myList.toString()), "[1, 4, 28, 12, 50, 17]");
    	System.out.println("Testing Size:\t");
		testFunction((""+myList.size()), "6");

		System.out.println("\r\nTest Passed: " +testPassed+ " out of " + totalTest+ ": \r\n\t\t" +(testPassed/totalTest)*100.0+ "%");
	}

	public static void testFunction(String actualValue, String expectedValue){
		if(actualValue.equals(expectedValue)){
			System.out.println("PASS: " + "expected output matches actual");
			testPassed++;
		} else{
			System.out.println("FAIL: Output does not match, check your algorithm. ");
    		System.out.println("   -  Your output:     " + actualValue);
    		System.out.println("   -  Expected output: " + expectedValue);
		}
	}
}