import java.util.Iterator;
import java.util.Comparator;

/**
 * Класс представляет собой реализацию кастомную реализацию ArrayList
 * @param <E> тип элементов, хранящихся в массиве на основе Generic
 */
public class CustomArray<E> implements Methods<E> {

    public static void main(String[] args) {

    }

    private E[] values;

    /**
     * Конструктор, создает пустой массив, экземпляр CustomArray
     */
    CustomArray(){
        values = (E[]) new Object[0];
    }

    /**
     * Функция для добавления элемента в конец массива
     * @param e элемент, который добавляется в конец массива
     * @return true, если элемент добавлен в конец массива, в противном случае - false
     */
    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("Некорректный тип элемента."); //Выбрасвыаем исключение на некорректное приведение типов
        }
    }

    /**
     * Функция для получения элемента из массива по индексу с проверкой выхода за пределы массива
     * @param index индекс элемента, который нужно получить из массива
     * @return элемент с указанным индексом
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= values.length) {
            return null;
        }
        return values[index];
    }

    /**
     * Функция для удаления элемента из массива по индексу с проверкой выхода за пределы массива
     * @param index индекс элемента, который нужно удалить из массива
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }

        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];

        System.arraycopy(temp, 0, values, 0, index);
        System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
    }

    /**
     * Функция для получения количества элементов в массиве
     * @return возвращает количество элементов в массиве
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * Функция для обновления элемента в массиве по индексу с проверкой выхода за пределы массива
     * @param index индекс элемента, который нужно обновить в массиве
     * @param e элемент, на который нужно заменить
     */
    @Override
    public void update(int index, E e) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        values[index] = e;
    }

    /**
     * Возвращает итератор для перебора элементов массива
     * @return итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }

    /**
     * Функция для сортировки массива по указанному компаратору
     * @param comparator компаратор для сортировки массива
     */
    public void sort(Comparator<E> comparator) {
        if (values != null && values.length > 1) { //Проверка на нулевой размер массива, чтобы избежать лишних сортировок
            quickSort(0, values.length - 1, comparator);
        }
    }

    /**
     *Функция для выполнения быстрой сортировки массива
     * @param low Нижний индекс сортировки
     * @param high Верхний индекс сортировки
     * @param comparator компаратор для сортировки
     */
    private void quickSort(int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Функция для разделения массива и выбора опорного элемента
     * @param low Нижний индекс разделения
     * @param high Верхний индекс разделения
     * @param comparator компаратор для сортировки
     * @return возвращает индекс опорного элемента
     */
    private int partition(int low, int high, Comparator<E> comparator) {
        E pivot = values[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(values[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Функция меняет местами два элемента массива
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        E temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}