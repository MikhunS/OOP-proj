package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Dialogue {
    public void start() {
        System.out.println("Я приложение вычисляющее интегралы введенной функции, для просмотра функционала введите --help");
    }

    public void enter() {
        System.out.println("Введите нижний предел интегрирования");
        System.out.println("Введите верхний предел интегрирования");
        System.out.println("Введите точность вычисления интеграла");

    }

    public String help(ArrayList<String> mas) {
        for (String arg : mas) {
            if (Objects.equals(arg, "--help")) {
                System.out.println("Для вычисления неопределенного интеграла введите -u");
                System.out.println("Для вычисления определенного интеграла введите -d ");
                return "Для вычисления неопределенного интеграла введите -u";
            }
            else {
                System.out.println("Вы не ввели --help");
                return "";
            }
        }
        return null;
    }
}
