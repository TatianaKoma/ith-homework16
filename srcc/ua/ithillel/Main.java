package ua.ithillel;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> digits = new SinglyLinkedList<>();

        digits.add(1);
        digits.add(5);
        System.out.println("First: " + digits.get(0));
        System.out.println("Second: " + digits.get(1));

        digits.add(8);
        System.out.println("Third: " + digits.get(2));

        System.out.println("Size: " + digits.size());

        digits.remove(digits.size() / 2);
        System.out.println("Size: " + digits.size());

        System.out.println("First: " + digits.get(0));
        System.out.println("Second: " + digits.get(1));

        Iterator<Integer> it = digits.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        DoublyLinkedList<Integer> numbers =new DoublyLinkedList<>();
        numbers.add(98);
        numbers.add(99);
        System.out.println("first:" + numbers.get(0));
        numbers.addFirst(3);
        System.out.println("first:" + numbers.get(0));
        numbers.remove(0);
        System.out.println("first:" + numbers.get(0));
        numbers.iterateForward();
        numbers.iterateBackward();
    }
}
