package dsa;

import array.Array;

public class App {
    public static void main(String[] args) {
        Array<Integer> items = new Array<>(3);

        items.append(1);
        // items.append(2);

        System.out.println(items.toString());
    }
}
