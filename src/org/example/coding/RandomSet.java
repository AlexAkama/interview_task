package org.example.coding;

/*

Реализовать RandomSet что бы все методы работали за O(1)
- boolean add(el)
- boolean contains(el)
- boolean contains(el)
- el getRandom()

Нужно услышать:
Быстро даром не бывает - значит что тут будет использовано много памяти
и что одной структурой не обойтись

Если что:
поговорить про сложность удаления из массива - услышать начало O(n) и конец O(1)
подвести к мысли как удалить из массива за O(1) произвольный элемент когда на порядок не важен

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomSet<T> {

    private final HashMap<T, Integer> map = new HashMap<>();
    private final List<T> list = new ArrayList<>();
    private final Random random = new Random();

    public boolean add(T element) {
        int size = list.size();
        return map.computeIfAbsent(element, t -> {
            list.add(element);
            return list.size() - 1;
        }) == size;
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public boolean remove(T element) {
        Integer removeIndex = map.remove(element);
        if (removeIndex != null) {
            int lastIndex = list.size() - 1;
            T lastElement = list.get(lastIndex);
            list.set(removeIndex, lastElement);
            if (removeIndex > 0) map.put(lastElement, removeIndex);
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    public T getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
