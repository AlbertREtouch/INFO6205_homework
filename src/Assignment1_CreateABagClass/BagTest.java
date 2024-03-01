package Assignment1_CreateABagClass;

public class BagTest {
    public static void main(String[] args) {
        Bag<String> stringBag = new Bag<>();

        stringBag.add("a");
        stringBag.add("b");
        stringBag.add("c");
        stringBag.add("c");
        stringBag.add("z");

        System.out.println("Bag contents: " + stringBag);
        System.out.println("check if Bag contains 'b': " + stringBag.contains("b"));
        System.out.println("Try to Remove 'c' from Bag: " + stringBag.remove("c"));
//       There are two "c", we only remove one of them
        System.out.println("Return Bag size: " + stringBag.size());
        System.out.println("Get Random element from Bag: " + stringBag.grab());

        Object[] stringArray = stringBag.toArray();
        System.out.print("Return array from the Bag: ");
        for (Object num : stringArray) {
            System.out.print(num + " ");
        }
        stringBag.clear();

        System.out.println("check if Bag is empty: " + stringBag.isEmpty());

    }
}
