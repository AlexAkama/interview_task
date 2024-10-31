package org.example.wtp.overloading.task01;

/*
Есть два класса SuperBase и наследник Base
Вопрос: Что будет выведено в консоль?
 */
public class Base extends SuperBase {

    public Base() {
        i = 5;
    }

    public static void main(String[] args) {
        SuperBase sb = new Base();
        Object o = "";
        sb.foo(o);
        sb.foo("");
    }

}
/*
Ответ:  Object 5
        String 5
 */
