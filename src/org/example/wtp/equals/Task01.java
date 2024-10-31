package org.example.wtp.equals;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
EQUALS
Вопрос: Что напечатает следующий код?
 */
class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point other) {
        if (this == other) return true;

        return this.x == other.x && this.y == other.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

}

public class Task01 {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2022, 2023);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        Set<Point> set = new HashSet<>();
        set.add(p1);

        System.out.println(set.contains(p2));
        System.out.println(set.contains(p3));
    }

}

/*
Ответ:  true
        false
        false
        false

Пояснение
Метод boolean equals(Point other) не переопределяет Object.equals, а перегружает его.
Плюс не определен метод hashcode(), что осложняет нахождение объекта в HashSet.
Теория: https://alexakama.github.io/whitebook/content/java_interview/java_core/classes/index.html#equals_hashcode
 */

