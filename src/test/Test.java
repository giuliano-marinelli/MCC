package test;

import funciones.*;
import metodosNumericos.*;
import matriz.*;
import tecladoIn.*;

public class Test {

    public static void main(String[] args) {
        double res;

        //Funcion polinomica
//        double[] c = {-1, -2, 0, 1};
//        FuncionPolinomica f = new FuncionPolinomica(c);
//        res = Biseccion.calcular(f, 1, 2, 0.1);
//        res = Secante.calcular(f, 1, 2, 0.01);
//        res = NewtonRaphson.calcular(f, 0, 0.1);
//        System.out.println("Resultado: " + res);
        //Funcion generica
//        Funcion fcoef1 = new FuncionBinaria(new FuncionConstante(1), "*", new FuncionBinaria(new FuncionVariable(0), "pow", new FuncionConstante(3)));
//        Funcion fcoef2 = new FuncionBinaria(new FuncionConstante(-2), "*", new FuncionVariable(0));
//        Funcion fcoef3 = new FuncionConstante(-1);
//        Funcion fx = new FuncionBinaria(fcoef1, "+", (new FuncionBinaria(fcoef2, "+", fcoef3)));
//        res = Biseccion.calcular(fx, 1, 2, 0.1);
//        res = Secante.calcular(fx, 1, 2, 0.01);
//        res = NewtonRaphson.calcular(fx, 0, 0.1);
//        System.out.println("Resultado: " + res);
        //Funcion trigonometrica
//        Funcion gcoef1 = new FuncionConstante(2);
//        Funcion gcoef2 = new FuncionUnaria("sin", new FuncionBinaria(new FuncionVariable(0), "-", new FuncionConstante(1)));
//        Funcion gx = new FuncionBinaria(gcoef1, "*", gcoef2);
//        res = Biseccion.calcular(gx, 0, 3, 0.1);
//        res = Secante.calcular(gx, 0, 3, 0.01);
//        res = NewtonRaphson.calcular(gx, 0, 0.1);
//        System.out.println("Resultado: " + res);

        /*
         x   |  y
         ---------
         2   | 21
         2.5 | 33.25
         3   | 48
         3.5 | 65.25
         4   | 85
         */
        double[][] matrizValores = new double[2][5];
//        matrizValores[0][0] = 150;
//        matrizValores[0][1] = 35.5;
//        matrizValores[0][0] = 160;
//        matrizValores[0][1] = 37.8;
//        matrizValores[1][0] = 170;
//        matrizValores[1][1] = 43.6;
//        matrizValores[3][0] = 180;
//        matrizValores[3][1] = 45.7;
//        matrizValores[4][0] = 190;
//        matrizValores[4][1] = 47.3;
//        res = SimpsonUnTercio.calcular(matrizValores);
//        res = SimpsonUnTercio.calcular(f, 4, 2, 4);
//        res = Lagrange.calcularInterpolacion(matrizValores, 162);
//        System.out.println("res: "+res);
        /*Metodo de Gauss*/
//        double[][] coefM = new double[3][3];
//        double[] indepM = new double[3];
//        coefM[0][0] = 1;
//        coefM[0][1] = 2;
//        coefM[0][2] = -1;
//        coefM[1][0] = 2;
//        coefM[1][1] = 3;
//        coefM[1][2] = -2;
//        coefM[2][0] = 1;
//        coefM[2][1] = -2;
//        coefM[2][2] = 1;
//        indepM[0] = 2;
//        indepM[1] = 3;
//        indepM[2] = 0;
//        double[] x = Matriz.gauss(coefM, indepM);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(x[i]);
//        }

        /*Los siguientes valores son para probar la matriz inversa*/
//        double[][] matrizInvertida;
//        double[][] matrizValores = new double[2][2];
//        matrizValores[0][0] = 4;
//        matrizValores[0][1] = 3;
//        matrizValores[1][0] = 2;
//        matrizValores[1][1] = 1;
//        matrizInvertida = Matriz.invertir(matrizValores);
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(matrizInvertida[i][j] + " | ");
//            }
//            System.out.println("");
//        }
//        FuncionBinaria term11 = new FuncionBinaria(new FuncionBinaria(new FuncionVariable(0), "pow", new FuncionConstante(4)), "+", (new FuncionBinaria(new FuncionConstante(0.06823), "*", new FuncionVariable(0))));
//        FuncionBinaria term12 = new FuncionBinaria(new FuncionBinaria(new FuncionVariable(1), "pow", new FuncionConstante(4)), "+", (new FuncionBinaria(new FuncionConstante(0.05848), "*", new FuncionVariable(1))));
//        Funcion f1 = new FuncionBinaria(new FuncionBinaria(term11, "-",term12),"-",new FuncionConstante(0.01509));
//        
//        FuncionBinaria term21 = new FuncionBinaria(new FuncionBinaria(new FuncionConstante(2), "*", new FuncionBinaria(new FuncionVariable(1), "pow", new FuncionConstante(4))), "+", (new FuncionBinaria(new FuncionConstante(0.11696), "*", new FuncionVariable(1))));
//        FuncionBinaria term22 = new FuncionBinaria(new FuncionBinaria(new FuncionVariable(0), "pow", new FuncionConstante(4)), "+", (new FuncionBinaria(new FuncionConstante(0.05848), "*", new FuncionVariable(0))));
//        Funcion f2 = new FuncionBinaria(term22, "-",term21);
//        
//        Funcion[] fs = {f1,f2};
//        double[] x0 = {0.2,-0.4};
//        
//        System.out.println(Matriz.toString(NewtonRaphsonNoLineal.calcular(fs, x0, 0.001)));
    /*    
         //        prueba de minimosCuadrados    
         //        matrizValores[0][0] = 0;
         //        matrizValores[0][1] = 0.25;
         //        matrizValores[0][2] = 0.5;
         //        matrizValores[0][3] = 0.75;
         //        matrizValores[0][4] =1;
         //        matrizValores[1][0] =1;
         //        matrizValores[1][1] =1.2840;
         //        matrizValores[1][2] =1.6487;
         //        matrizValores[1][3] =2.117;
         //        matrizValores[1][4] =2.7183;
         //        
         //        System.out.println(MinimosCuadrados.calcular(matrizValores, 2).toString());
         */
        
        
        /*TEST Minimos Cuadrados*/
//        double[][] matrizCoeficientes;
//        int tamañoMatriz;
//        int gradoPolinomio;
//        Funcion polinomio;
//        System.out.println("Ingrese la cantidad de numeros que tiene la tabla "
//                + "de valores: ");
//        tamañoMatriz = TecladoIn.readInt();
//        matrizCoeficientes = new double[2][tamañoMatriz];
//        System.out.println("A continuación ingrese los valores: ");
//        for (int i = 0; i < tamañoMatriz; i++) {
//            System.out.println("Ingrese el valor: x" + (i + 1));
//            matrizCoeficientes[0][i] = TecladoIn.readLineDouble();
//            System.out.println("Ingrese el valor: f(x" + (i + 1) + ")");
//            matrizCoeficientes[1][i] = TecladoIn.readLineDouble();
//        }
//
//        System.out.println("Ingrese el grado de polinomio que desee");
//        gradoPolinomio = TecladoIn.readInt();
//
//        polinomio = MinimosCuadrados.calcular(matrizCoeficientes, gradoPolinomio);
//        System.out.println("El polinomio resultante es:");
//        System.out.println(polinomio.toString());
        
        /*TEST EULER MODIFICADO*/
//        Funcion f = new FuncionBinaria(new FuncionVariable(1), "-", new FuncionVariable(0));    
//        double intervalo[] = {0,1};
//        System.out.println("resultado: "+EulerModificado.calcular(f, 1, intervalo, 4, 2));
        
        
        
//        /*TEST TrapeciosDoble*/
//        Funcion f1 = new FuncionBinaria(new FuncionVariable(0), "pow", new FuncionConstante(2));
//        Funcion f2 = new FuncionBinaria(new FuncionVariable(1), "pow", new FuncionConstante(2));
//        Funcion f3 = new FuncionBinaria(f1, "+", f2);
//        System.out.println(TrapecioDoble.calcular(f3, 2, 2, 0, 2, 0, 2));
        
        /*TEST SimpsonUnTercioDoble*/
//        Funcion f1 = new FuncionBinaria(new FuncionVariable(0), "pow", new FuncionConstante(2));
//        Funcion f2 = new FuncionBinaria(new FuncionVariable(1), "pow", new FuncionConstante(2));
//        Funcion f3 = new FuncionBinaria(f1, "+", f2);
//        System.out.println(SimpsonUnTercioDoble.calcular(f3, 2, 2, 0, 2, 0, 2));
    }

}
