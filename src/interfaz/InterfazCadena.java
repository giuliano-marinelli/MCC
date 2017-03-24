package interfaz;

import funciones.Funcion;

public class InterfazCadena {
    
    public static void main(String[] args) {
//        String cadena="f(x)=sen(1*(1*(3*4))*1)";
//        String cadena="f(x)=2-(2*-2)+2";
//        String cadena="f(x,y)=(2*x+y)+2";
//        String cadena="f(x)=(2^x+5*2)";
        String cadena="f(x,y)=sqrt(6+2,3)*x*y";
//        String cadena="f(x,y)=x^2";
//        String cadena="f(x)=2-sen(2*-3)*52";
//        String cadena="f(x)=2*sen(3)*2+2";
//        String cadena="f(x)=e(-2)/5";
//        String cadena="f(x)=abs(2*-5)";
        Reconocer rec = new Reconocer(cadena);
        Funcion f = rec.crearFuncion();
        System.out.println("funcion: "+f.toString());
        double[] valores = {5,2};
        System.out.println("resultado: "+f.valor(valores));
        

    }
}
