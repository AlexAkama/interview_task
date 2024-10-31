package org.example.wtp.initialization;

/*
Порядок инициализации
Вопрос: Что будет выведено?
 */
public class Task01 {

    static {
        System.out.println("Static");
    }

    {
        System.out.println("Instance");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }


}
/*
 Ответ: Static
        Main
 */
