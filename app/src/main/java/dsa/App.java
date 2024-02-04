package dsa;

import array.Array;

public class App {
    public static void main(String[] args) {
        Array<Integer> items = new Array<>(6);

        items.append(1);
        items.append(2);
        items.append(3);
        items.append(4);
        items.append(5);
        items.append(6);
        items.append(7);

        System.out.println(items.pop());
        System.out.println(items.toString());
    }
}
