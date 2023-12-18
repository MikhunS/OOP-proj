package org.example;

import java.util.Scanner;

class Integration {

    public static void calc() {
        Function function;
        Dialogue di;
        di = new Dialogue();
        function = new Function();
        Scanner s = new Scanner(System.in);
        System.out.println("выберите функцию : 1) cos , 2) sin , 3) tg");
        int d = s.nextInt();

        di.enter();
        double a = s.nextDouble();
        double b = s.nextDouble();
        int n = s.nextInt();

        double result = function.IntSimpson(a, b, n, d);

        System.out.println("Integral is: " + result);
    }
}
