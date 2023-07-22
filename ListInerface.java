package ArrayList;
public interface ListInerface<E>  {
    int size();

    boolean isEmpty();

    boolean add(E element);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    boolean remove(E element);

    E remove(int index);

    boolean contains(Object element);

    int indexOf(E element);

    int lastIndexOf(E element);

    void clear();

    E[] toArray();

    <T> T[] toArray(T[] array);

    ListInerface<E> subList(int fromIndex, int toIndex);

    boolean removeAll(ListInerface<?> otherList);

    boolean retainAll(ListInerface<?> otherList);

    boolean containsAll(ListInerface<?> otherList);

    boolean addAll(ListInerface<? extends E> otherList);

    //boolean addAll(int index, ListInerface<? extends E> otherList);

    boolean equals(Object obj);

    int hashCode();

    String toString();
}