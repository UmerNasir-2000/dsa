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

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count++;
            
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
 
        return Math.max(max, count);
    }

    public void removeAt(int index) {
        this.validateIndex(index);

        for (int i = index; i < this.getLength() - 1; i++)
            items[i] = items[i + 1];

        this.setLength(this.getLength() - 1);
    }

    public void insertAt(int index, T value) {
        this.validateIndex(index);

        if (this.getLength() >= this.capacity) resize();

        for (int i = this.getLength() - 1; i >= index; i--)
            items[i+1] = items[i];

        this.items[index] = value;

        this.setLength(this.getLength() + 1);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.getLength()) throw new IllegalArgumentException("Invalid Index");
    }

    public int getLength() {
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
        int length = this.getLength();

        if (length >= this.capacity) 
            this.resize();

        this.items[this.length++]= item;
    }

    public T pop() {
        if (this.length <= 0) throw new IllegalStateException("Array is empty");
        int length = this.getLength();

        T item = this.items[length - 1];
        this.setLength(length - 1);

        return item;
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
