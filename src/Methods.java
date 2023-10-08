/**
 * интерфейс, хранящий методы кастомного массива
 * @param <E> тип элементов массива
 */
public interface Methods<E> extends Iterable<E> {

    boolean add(E e);
    E get(int index);
    void remove(int index);
    int size();
    void update(int index, E e);

}
