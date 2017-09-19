package ru.java.course.homework.shpizel.igor;

public class MyList {

    private static final int INCREMENT = 2;
    private int storage[];
    private int size;
    private int cursor = 0;

    public MyList() {
        size = 2;
        storage = new int[size];

    }

    public MyList(int initialSize) {
        size = initialSize;
        storage = new int[size];
    }

    /**
     * Добавление в конец
     *
     * @param element
     */
    public void add(int element) {
        if (cursor < size) {
            storage[cursor++] = element;
        } else {
            incrementArraySize();
            add(element);
        }
    }

    /**
     * Добавление перед другим элементом
     *
     * @param element
     */
    public void add(int element, int before) {
        while (++cursor >= size || before > size) {
            incrementArraySize();
        }

        if (before > cursor) {
            cursor = before;
        }

        if (before <= 0) {
            before = 1;
        }

        int[] newStorage = new int[size];
        if (before > 1) {
            System.arraycopy(storage, 0, newStorage, 0, before - 1);
        }

        newStorage[before - 1] = element;

        System.arraycopy(storage, before - 1, newStorage, before, size - before);
        storage = null;
        storage = newStorage;
    }

    /**
     * Getter by id
     *
     * @param index
     * @return Если заполнить лист одним значением, а затем обратиться к
     */
    public int get(int index) {
        return storage[index];
    }

    /**
     * Size getter
     *
     * @return
     */
    public int size() {
        return cursor;
    }

    private void incrementArraySize() {
        int newStorage[] = new int[size * INCREMENT];
        System.arraycopy(storage, 0, newStorage, 0, size);
        size *= INCREMENT;
        storage = null;
        storage = newStorage;
    }

    @Override
    public String toString() {
        String[] elements = new String[size()];
        for (int i = 0; i < size(); i++) {
            elements[i] = String.valueOf(storage[i]);
        }
        return "MyList{" +
            "storage=[" + String.join(",", elements) +
            "]}";
    }
}
