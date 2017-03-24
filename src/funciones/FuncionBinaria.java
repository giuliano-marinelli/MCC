package funciones;

public class FuncionBinaria extends Funcion {

    Funcion operando1;
    Funcion operando2;
    String operador;

    public FuncionBinaria(Funcion operando1, String operador, Funcion operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }

    @Override
    public double valor(double[] x) {
        double res = 0;
        switch (operador) {
            case "+":
                res = operando1.valor(x) + operando2.valor(x);
                break;
            case "-":
                res = operando1.valor(x) - operando2.valor(x);
                break;
            case "*":
                res = operando1.valor(x) * operando2.valor(x);
                break;
            case "/":
                res = operando1.valor(x) / operando2.valor(x);
                break;
            case "^":
                res = Math.pow(operando1.valor(x), operando2.valor(x));
                break;
            case "sqrt":
                res = Math.pow(operando1.valor(x), 1 / operando2.valor(x));
                break;
        }
        return res;
    }

    @Override
    public Funcion derivar() {
        Funcion aux = null;
        switch (operador) {
            case "+":
                aux = new FuncionBinaria(operando1.derivar(), "+", operando2.derivar());
                break;
            case "-":
                aux = new FuncionBinaria(operando1.derivar(), "-", operando2.derivar());
                break;
            case "*":
                aux = new FuncionBinaria(new FuncionBinaria(operando1.derivar(), "*", operando2), "+",
                        new FuncionBinaria(operando1, "*", operando2.derivar()));
                break;
            case "/":
                Funcion termino1 = new FuncionBinaria(
                        new FuncionBinaria(operando1.derivar(), "*", operando2), "-",
                        new FuncionBinaria(operando1, "*", operando2.derivar()));
                Funcion termino2 = new FuncionBinaria(operando2, "^", new FuncionConstante(2));
                aux = new FuncionBinaria(termino1, "/", termino2);
                break;
            case "^":
                aux = new FuncionBinaria(new FuncionBinaria(operando2, "*",
                        new FuncionBinaria(operando1, "^", new FuncionBinaria(operando2, "-",
                                        new FuncionConstante(1)))), "*", operando1.derivar());
                break;
            case "sqrt":
                aux = new FuncionBinaria(operando1.derivar(), "/",
                        new FuncionBinaria(operando2, "*", new FuncionBinaria(
                                        new FuncionBinaria(operando1, "^",
                                                new FuncionBinaria(operando2, "-",
                                                        new FuncionConstante(1))), "sqrt", operando2)));
                break;
        }
        return aux;
    }

    @Override
    public Funcion derivar(int indice) {
        Funcion aux = null;
        switch (operador) {
            case "+":
                aux = new FuncionBinaria(operando1.derivar(indice), "+", operando2.derivar(indice));
                break;
            case "-":
                aux = new FuncionBinaria(operando1.derivar(indice), "-", operando2.derivar(indice));
                break;
            case "*":
                aux = new FuncionBinaria(new FuncionBinaria(operando1.derivar(indice), "*", operando2), "+",
                        new FuncionBinaria(operando1, "*", operando2.derivar(indice)));
                break;
            case "/":
                Funcion termino1 = new FuncionBinaria(
                        new FuncionBinaria(operando1.derivar(indice), "*", operando2), "-",
                        new FuncionBinaria(operando1, "*", operando2.derivar(indice)));
                Funcion termino2 = new FuncionBinaria(operando2, "^", new FuncionConstante(2));
                aux = new FuncionBinaria(termino1, "/", termino2);
                break;
            case "^":
                aux = new FuncionBinaria(new FuncionBinaria(operando2, "*",
                        new FuncionBinaria(operando1, "^", new FuncionBinaria(operando2, "-",
                                        new FuncionConstante(1)))), "*", operando1.derivar(indice));
                break;
            case "sqrt":
                aux = new FuncionBinaria(operando1.derivar(indice), "/",
                        new FuncionBinaria(operando2, "*", new FuncionBinaria(
                                        new FuncionBinaria(operando1, "^",
                                                new FuncionBinaria(operando2, "-",
                                                        new FuncionConstante(1))), "sqrt", operando2)));
                break;
        }
        return aux;
    }

    @Override
    public String toString() {
        String res1 = operando1.toString();
        String res2 = operando2.toString();
        String res="";
        switch(operador){
            case "+": res = res1+operador+res2;break;
            case "-": res = res1+operador+res2;break;
            case "*": res = res1+operador+res2;break;
            case "/": res = res1+operador+res2;break;
            case "sqrt": res = res2+"√("+res1+")";break;
            case "^": res = res1+operador+res2;break;
        }
        return res;
    }
//    @Override
//    public String toString() {
////        String res1 = operando1.toString();
////        String res2 = operando2.toString();
////        if (operador.equals("+") && !operador.equals("-")) {
////            if (operando1.getClass().getName().equals("funciones.FuncionBinaria")) {
////                res1 = "(" + operando1.toString() + ")";
////            }
////            if (operando2.getClass().getName().equals("funciones.FuncionBinaria")) {
////                res2 = "(" + operando2.toString() + ")";
////            }
////        }
////
////        return res1 + operador + res2;
//        return "("+operando1.toString()+operador+operando2.toString()+")";
//    }

 
}
