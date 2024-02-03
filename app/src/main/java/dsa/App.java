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

        System.out.println(items.toString());
    }
}
