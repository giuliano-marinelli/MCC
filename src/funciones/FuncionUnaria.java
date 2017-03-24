package funciones;

public class FuncionUnaria extends Funcion {

    Funcion operando;
    String tipo;

    public FuncionUnaria(String tipo, Funcion operando) {
        this.operando = operando;
        this.tipo = tipo;
    }

    @Override
    public double valor(double[] x) {
        double res = 0;
        switch (tipo) {
            case "sin":
                res = Math.sin(operando.valor(x));
                break;
            case "cos":
                res = Math.cos(operando.valor(x));
                break;
            case "tan":
                res = Math.tan(operando.valor(x));
                break;
            case "atan":
                res = Math.atan(operando.valor(x));
                break;
            case "e":
                res = Math.exp(operando.valor(x));
                break;
            case "log":
                res = Math.log(operando.valor(x));
                break;
            case "abs":
                res = Math.abs(operando.valor(x));
                break;
        }
        return res;
    }

    @Override
    public Funcion derivar() {
        Funcion aux = null;
        switch (tipo) {
            case "sin":
                aux = new FuncionBinaria(operando.derivar(), "*", new FuncionUnaria("cos", operando));
                break;
            case "cos":
                aux = new FuncionBinaria(new FuncionBinaria(
                        new FuncionConstante(-1), "*", operando.derivar()), "*",
                        new FuncionUnaria("sin", operando));
                break;
            case "tan":
                aux = new FuncionBinaria(operando.derivar(), "/", new FuncionBinaria(
                        new FuncionUnaria("cos", operando), "pow", new FuncionConstante(2)));
                break;
            case "atan":
                aux = new FuncionBinaria(operando.derivar(), "/", new FuncionBinaria(
                        new FuncionConstante(1), "+", new FuncionBinaria(operando, "pow",
                                new FuncionConstante(2))));
                break;
            case "e":
                aux = new FuncionBinaria(operando.derivar(), "*", new FuncionUnaria("e", operando));
                break;
            case "log":
                aux = new FuncionBinaria(operando.derivar(), "/", operando);
                break;
            case "abs":
                aux = new FuncionBinaria(new FuncionBinaria(operando, "/",
                        new FuncionUnaria("abs", operando)), "*", operando.derivar());
                break;
        }
        return aux;
    }

    @Override
    public Funcion derivar(int indice) {
        Funcion aux = null;
        switch (tipo) {
            case "sin":
                aux = new FuncionBinaria(operando.derivar(indice), "*", new FuncionUnaria("cos", operando));
                break;
            case "cos":
                aux = new FuncionBinaria(new FuncionBinaria(
                        new FuncionConstante(-1), "*", operando.derivar(indice)), "*",
                        new FuncionUnaria("sin", operando));
                break;
            case "tan":
                aux = new FuncionBinaria(operando.derivar(indice), "/", new FuncionBinaria(
                        new FuncionUnaria("cos", operando), "pow", new FuncionConstante(2)));
                break;
            case "atan":
                aux = new FuncionBinaria(operando.derivar(indice), "/", new FuncionBinaria(
                        new FuncionConstante(1), "+", new FuncionBinaria(operando, "pow",
                                new FuncionConstante(2))));
                break;
            case "e":
                aux = new FuncionBinaria(operando.derivar(indice), "*", new FuncionUnaria("e", operando));
                break;
            case "log":
                aux = new FuncionBinaria(operando.derivar(indice), "/", operando);
                break;
            case "abs":
                aux = new FuncionBinaria(new FuncionBinaria(operando, "/",
                        new FuncionUnaria("abs", operando)), "*", operando.derivar(indice));
                break;
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return tipo + "(" + operando.toString() + ")";
    }

}
