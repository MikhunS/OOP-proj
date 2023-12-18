package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ArrayList<String> arg = new ArrayList();
        Scanner scan = new Scanner(System.in);
        Integration i = new Integration();
        Dialogue d = new Dialogue();
        arg.addAll(Arrays.asList(args));
        d.start();
        if (args.length == 0) {
            arg.add(scan.next());
        }

        d.help(arg);
        String c = scan.next();
        if (Objects.equals(c, "-d")) {
            Integration.calc();
        }

    }
}
