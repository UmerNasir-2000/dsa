package array;

public class Array<T> {

    private Integer capacity;
    private int length;
    private T[] items;


    @SuppressWarnings("unchecked")
    public Array(Integer capacity) {
        this.setCapacity(capacity);
        this.items = (T[]) new Object[this.capacity];
    }

    private int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setCapacity(Integer size) {
        if (size < 0) throw new IllegalArgumentException("Size must be greater than 0");
        this.capacity = size;
    }

    public void append(T item) {
        this.items[this.getLength()] = item;
        this.setLength(this.getLength() + 1);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < this.getLength(); i++) 
            string.append(this.items[i]);

        return string.toString();
    }
    
}
