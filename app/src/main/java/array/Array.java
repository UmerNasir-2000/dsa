package array;
@SuppressWarnings("unchecked")
public class Array<T> {
    private Integer capacity;
    private int length;
    private T[] items;

    
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

    private void resize() {
        this.setCapacity(this.capacity * 2);
        T[] newItems = (T[]) new Object[this.capacity];

        for (int i = 0; i < this.getLength(); i++) 
            newItems[i] = this.items[i];

        this.items = newItems;
    }

    public void append(T item) {
        if (this.getLength() >= this.capacity) 
            this.resize();

        this.items[this.getLength()] = item;
        this.setLength(this.getLength() + 1);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        int length = this.getLength();

        for (int i = 0; i < length; i++) {
            if (i == length - 1) 
                string.append(this.items[i]);
            else 
                string.append(this.items[i] + ", ");
        }
        
        string.append("]");

        return string.toString();
    }
    
}
