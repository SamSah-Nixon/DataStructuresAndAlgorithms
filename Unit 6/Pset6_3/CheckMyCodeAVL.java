public class CheckMyCodeAVL{
	private static int testPassed = 0;
	private static double totalTest = 24.0;

	public static void main(String args[]){
		System.out.println("----------------------");
    	System.out.println("--- Starting Point ---");
    	System.out.println("----------------------");
		AVLTree<String> myTree = new AVLTree<String>();
		System.out.println("Created AVLTree<String> myTree");
		System.out.println("size: " +myTree.size());
		System.out.println("is Empty?: "+myTree.isEmpty());
		testFunction((""+myTree.isEmpty()), "true");
		testFunction((""+myTree.toString()), "[]");

		System.out.println("\r\n----------------------");
    	System.out.println("--- insert(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Inserting element sally:");
		myTree.insert("sally");
		testFunction((""+myTree.toString()), "[(null, sally)]");
		System.out.println("Inserting element jake:");
		myTree.insert("jake");
		testFunction((""+myTree.toString()), "[(null, sally), (sally, jake)]");
		System.out.println("Inserting element winston:");
		myTree.insert("winston");
		testFunction((""+myTree.toString()), "[(null, sally), (sally, jake), (sally, winston)]");
		System.out.println("Inserting element hondo:");
		myTree.insert("hondo");
		testFunction((""+myTree.toString()), "[(null, sally), (sally, jake), (sally, winston), (jake, hondo)]");
		System.out.println("Inserting element bishop:");
		myTree.insert("bishop");
		testFunction((""+myTree.toString()), "[(null, sally), (sally, hondo), (sally, winston), (hondo, bishop), (hondo, jake)]");
		System.out.println("Inserting element alice:");
		myTree.insert("alice");
		testFunction((""+myTree.toString()), "[(null, hondo), (hondo, bishop), (hondo, sally), (bishop, alice), (sally, jake), (sally, winston)]");
		System.out.println("Testing Size:\t");
		testFunction((""+myTree.size()), "6");

		System.out.println("\r\n----------------------");
    	System.out.println("--- find(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Searching for element duncan: ");
    	testFunction((""+myTree.find("duncan")), "false");
    	System.out.println("Searching for element alice: ");
    	testFunction((""+myTree.find("alice")), "true");
    	System.out.println("Searching for element jake: ");
    	testFunction((""+myTree.find("jake")), "true");
    	System.out.println("Searching for element felicia: ");
    	testFunction((""+myTree.find("felicia")), "false");
    	System.out.println("Testing Size:\t");
		testFunction((""+myTree.size()), "6");


		myTree.insert("felicia");
		myTree.insert("duncan");
    	System.out.println("\r\n----------------------");
    	System.out.println("--- delete(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Removing element jake:");
    	myTree.delete("jake");
		testFunction((""+myTree.toString()), "[(null, hondo), (hondo, bishop), (hondo, sally), (bishop, alice), (bishop, felicia), (sally, winston), (felicia, duncan)]");
		System.out.println("Removing element alice:");
		myTree.delete("alice");
		testFunction((""+myTree.toString()), "[(null, hondo), (hondo, duncan), (hondo, sally), (duncan, bishop), (duncan, felicia), (sally, winston)]");
		System.out.println("Removing element Duncan:");
		myTree.delete("Duncan");
		testFunction((""+myTree.toString()), "[(null, hondo), (hondo, duncan), (hondo, sally), (duncan, bishop), (duncan, felicia), (sally, winston)]");
    	System.out.println("Testing Size:\t");
		testFunction((""+myTree.size()), "6");

		System.out.println("\r\n----------------------");
    	System.out.println("--- find(item) ---");
    	System.out.println("----------------------");
    	System.out.println("Searching for element duncan: ");
    	testFunction((""+myTree.find("duncan")), "true");
    	System.out.println("Searching for element alice: ");
    	testFunction((""+myTree.find("alice")), "false");
    	System.out.println("Searching for element jake: ");
    	testFunction((""+myTree.find("jake")), "false");
    	System.out.println("Searching for element felicia: ");
    	testFunction((""+myTree.find("felicia")), "true");
    	System.out.println("Searching for element xander: ");
    	testFunction((""+myTree.find("xander")), "false");
    	System.out.println("Testing Size:\t");
		testFunction((""+myTree.size()), "6");


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