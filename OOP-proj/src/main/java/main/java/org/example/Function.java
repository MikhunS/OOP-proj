package main.java.org.example;


public class Function {

    public interface F {
        static double f(double x) {
            return Math.cos(x);
        }

        static double g(double x) {
            return Math.sin(x);
        }

        static double h(double x) {
            return Math.tan(x);
        }
    }

 
    public double intSimpson(double a, double b, int n, int y) {
        int i, z;
        double h, s = 0;

        n = n + n;
        if (y == 1) {
            s = F.f(a) * F.f(b);
        }
        if (y == 2) {
            s = F.g(a) * F.g(b);
        }
        if (y == 3) {
            s = F.f(a) * F.f(b);
        }

        h = (b - a) / n;
        z = 4;

        for (i = 1; i < n; i++) {
            if (y == 1) {
                s = s + z * F.f(a + i * h);
            }
            if (y == 2) {
                s = s + z * F.g(a + i * h);
            }
            if (y == 3) {
                s = s + z * F.h(a + i * h);
            }

            z = 6 - z;
        }
        return (s * h) / 3;
    }
}
