package ua.ithillel;

public interface CustomList<E> {

    int size();

    void add(E element);

    E get(int index);

    boolean remove(int index);
}
