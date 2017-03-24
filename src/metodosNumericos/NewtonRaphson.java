package metodosNumericos;

import funciones.Funcion;

public class NewtonRaphson {

    public static double calcular(Funcion f, double punto, double e) {
        double valorDeriv;
        boolean flag = true;
        do {
            Funcion g = f.derivar();
            if (g.valor(punto) != 0) {
                punto = punto - (f.valor(punto) / g.valor(punto));
            } else {
                flag = false;
            }
            System.out.println("x=" + punto);
            System.out.println("e=" + Math.abs(f.valor(punto)));
        } while (Math.abs(f.valor(punto)) > e && flag);
        return punto;
    }
}
