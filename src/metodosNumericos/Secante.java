package metodosNumericos;

import funciones.Funcion;

public class Secante {

    public static double calcular(Funcion f, double pto1, double pto2, double e) {
        double aux;
        int i = 0;
        do {
            aux = pto2 - (f.valor(pto2) * (pto2 - pto1)) / (f.valor(pto2) - f.valor(pto1));
            pto1 = pto2;
            pto2 = aux;
            i++;
            System.out.println("x"+(i+1)+"="+pto2);
            System.out.println("e"+(i+1)+"="+Math.abs(f.valor(pto2)));
        } while (i < 20 && Math.abs(f.valor(pto2)) > e);
        return pto2;
    }
}
