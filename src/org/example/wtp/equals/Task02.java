package org.example.wtp.equals;

public class Task02 {

    class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point other = (Point) o;

            return x == other.x && y == other.y;
        }

    }

    class ColourPoint extends Point {

        private final String colour;

        public ColourPoint(int x, int y, String colour) {
            super(x, y);
            this.colour = colour;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ColourPoint)) return false;

            ColourPoint other = (ColourPoint) o;

            return this.getX() == other.getX() &&
                    this.getY() == other.getY() &&
                    this.colour.equals(other.colour);
        }

    }

}

// Вопрос: Какое свойство equals нарушается в этом случае? (если нарушается)
// Ответ: Симметрия