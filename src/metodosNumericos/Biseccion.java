package metodosNumericos;

import funciones.Funcion;

public class Biseccion {

    public static double calcular(Funcion f, double a, double b, double e) {
        double r;
        double tempA = a;
        double tempB = b;
       
        do {
            r = (a + b) / 2;
            if (f.valor(a) * f.valor(r) < 0) {
                tempB = b;
                b = r;
            } else {
                tempA = a;
                a = r;
            }
            System.out.println("r="+r);
            System.out.println("e="+Math.abs(f.valor(r)));
        } while (Math.abs(tempA - tempB) > e || f.valor(r) == 0);
        return r;
    }

}
