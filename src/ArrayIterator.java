import java.util.Iterator;

/**
 * Класс представляет собой реализацию итератора для перебора элементов коллекции
 * @param <E> тип элементов, хранящихся в коллекции
 */
public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    E[] values;

    ArrayIterator(E[] values) {
        this.values = values;
    }

    /**
     * Проверяет наличие следующего элемента в коллекции
     * @return возвращает true, если следующий элемент в коллекции есть
     */
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    /**
     * Получение следующего элемента в коллекции
     * @return возвращает следующий элемент в коллекции
     */
    @Override
    public E next() {
        return values[index++];
    }

}