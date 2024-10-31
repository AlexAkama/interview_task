package org.example.coding;

/*

Написать класс, который может преобразовать строку вида: "k=v;k1=v1" в словарь.
При это требуется реализовать три метода в этом классе
    1. Преобразование строки (parse)
    2. Получение значения по ключу за O(1) (getValue)
    3. Выдать исходную строку (generateRecord)
Пример входной строки: key1=val1;key1=abc;key2=val2;key3=val3;key2=val5;key1=val6


Услышать хранение строки в локальной переменной
Минус если
- сплитим строку без вопроса о длине
- если нет вопроса про повторяющиеся значения
- если будет реализация с перезаписью значений (хочется услышать в список)

Если все хорошо - вопрос про иммутабельность
и как из того что есть сделать иммутабельный класс
Ожидаем два варианта:
- в конструктор
- фабричный метод

 */

public class ParseHolder {

    public void parse(String str) {
    }

    public String generateRecord() {
        return null;
    }

    public String getValue(String key) {
        return null;
    }

    public class Solution {
        public static void main(String args[]) throws Exception {
            String testString = "key1=val1;key1=abc;key2=val2;key3=val3;key2=val5;key1=val6";
            ParseHolder parser = new ParseHolder();
            parser.parse(testString);
            System.out.println(parser.generateRecord());
        }
    }
}

