package Assignment1_CreateABagClass;

import java.util.ArrayList;
import java.util.Random;

class Bag<T> {
    private ArrayList<T> data;
    private int size;

    public Bag() {
        data = new ArrayList<>();
        size = 0;
    }

    public void add(T item) {
        data.add(item);
        size++;
    }

    public void clear() {
        data.clear();
        size = 0;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if(data.get(i) == item){
                return true;
            }
        }
        return false;
    }

    public T grab() {
        if (isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return data.get(rand.nextInt(data.size()));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(T item) {
        if(contains(item)){
            data.remove(item);
            size--;
            return true;
        }
        else {
            return false;
        }

    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public String toString() {

        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data.get(i));
            if (i != size-1){
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();

    }


}


