package interfaz;

import funciones.Funcion;
import funciones.FuncionBinaria;
import funciones.FuncionConstante;
import funciones.FuncionUnaria;
import funciones.FuncionVariable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Reconocer {

    private String formula;
    private String nombreFuncion;
    private List<String> variables;

    public Reconocer(String str) {
        nombreFuncion = obtenerNombre(str);
        formula = obtenerFormula(str);
        variables = new LinkedList();
        obtenerVariables(str);
    }

    public Funcion crearFuncion() {
        Funcion res = null;
        if (balanceParentesis(formula)) {
            preProcesar();
            res = crearFuncion(formula, 0);
        } else {
            throw new RuntimeException("Error de sintaxis (paréntesis no balanceados).");
        }
        return res;
    }

    private boolean balanceParentesis(String cadena) {
        int i = 0;
        int contAbierto = 0;
        int contCerrado = 0;
        boolean ok;
        while (i < cadena.length()) {
            if (cadena.charAt(i) == '(') {
                contAbierto++;
            }
            if (cadena.charAt(i) == ')') {
                contCerrado++;
            }
            i++;
        }
        ok = (contAbierto == contCerrado);
        return ok;
    }

    private Funcion crearFuncion(String str, int j) {
        char op = ' ';
        String subc = "";
        Funcion func;
        int aux = 0;
        int i = j;
        boolean esTermino;
        esTermino = !(str.charAt(i) == '-');
        while ((i < str.length()) && (str.charAt(i) != '+' && (!(str.charAt(i) == '-' && esTermino)))) {
            if (str.charAt(i) == '(') {
                int cantP = 1;
                while (cantP != 0) {
                    subc += str.charAt(i);
                    i++;
                    if (str.charAt(i) == '(') {
                        cantP++;
                    } else if (str.charAt(i) == ')') {
                        cantP--;
                    }
                }
            }
            if (i < str.length() && str.charAt(i) != '(') {
                subc += str.charAt(i);
                if ((str.charAt(i) < 48 || str.charAt(i) > 57)) {
                    esTermino = false;
                }
            }

            i++;
        }

        int h;
        if (subc.charAt(0) == '(') {
            h = pasarParentesis(str, 1);
            if (h >= subc.length()) {
                func = crearFuncion(extraerArgumento(subc, 1), 0);
            } else {
                func = reconocerFuncionConsOUnaria(subc, str, aux);
            }
        } else {
            func = buscarProductoODivision(subc, str, aux);
        }

        if (i < str.length()) {
            op = str.charAt(i);
        }
        i++;
        String temp = "";
        if (i < str.length()) {
            if (str.charAt(i) == '(') {
                temp = extraerArgumento(str, i + 1);
            } else {
                temp = str.substring(i);
            }
        }

        if (op != ' ' && !temp.equals("")) {
            switch (op) {
                case '+':
                    func = new FuncionBinaria(func, "+", crearFuncion(str, i));
                    break;
                case '-':
                    func = new FuncionBinaria(func, "-", crearFuncion(str, i));
                    break;
            }
        }
        return func;
    }

    private Funcion reconocerFuncionConsOUnaria(String cadena, String total, int indice) {
        Funcion res = null;
        int i = 0;
        String temp = "";
        while (i < cadena.length()) {
            if (cadena.charAt(i) == '(') {
                i = pasarParentesis(cadena, i + 1) - 1;
            }
            if (i < cadena.length() && cadena.charAt(i) != '(') {
                temp += cadena.charAt(i);
            }
            i++;
        }
        if (temp.contains("*") || temp.contains("/") || temp.charAt(0) == '(') {
            res = buscarProductoODivision(cadena, total, indice);
        }

        boolean token = true;
        i = 0;
        String op = "";
        while (i < cadena.length() && cadena.charAt(i) != '(') {
            op += cadena.charAt(i);
            i++;
        }

        if (res == null) {
            switch (op) {
                case "sen":
                case "sin":
                    res = new FuncionUnaria("sen", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "cos":
                    res = new FuncionUnaria("cos", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "tan":
                    res = new FuncionUnaria("tan", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "atan":
                    res = new FuncionUnaria("atan", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "e":
                    res = new FuncionUnaria("e", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "log":
                    res = new FuncionUnaria("log", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                case "abs":
                    res = new FuncionUnaria("abs", crearFuncion(extraerArgumento(cadena, i + 1), 0));
                    break;
                default:
                    token = false;
            }
        }
        if (!token) {
            res = crearFuncionVariable(res, cadena);
            if (res == null) {
                res = new FuncionConstante(Double.parseDouble(cadena));
            }
        }
        return res;
    }

    private Funcion buscarProductoODivision(String str, String total, int indice) {
        char op = ' ';
        String subc = "";
        Funcion func;
        int i = 0;
        while ((i < str.length()) && (str.charAt(i) != '*' && str.charAt(i) != '/')) {
            if (str.charAt(i) == '(') {
                int cantP = 1;
                while (cantP != 0) {
                    subc += str.charAt(i);
                    i++;
                    if (str.charAt(i) == '(') {
                        cantP++;
                    } else if (str.charAt(i) == ')') {
                        cantP--;
                    }
                }
            }
            if (i < str.length() && str.charAt(i) != '(') {
                subc += str.charAt(i);
            }
            i++;
        }
        if (subc.charAt(0) == '(') {
            subc = extraerArgumento(subc, 1);
        }
        if (subc.contains("^") || subc.contains("sqrt")) {
            func = buscarPotenciaOraiz(subc, total, indice);
        } else {
            func = reconocerFuncionConsOUnaria(subc, total, 0);
        }

        if (i < str.length()) {
            op = str.charAt(i);
        }
        i++;

        if (i < str.length()) {
            if (str.charAt(i) == '(') {
                str = extraerArgumento(str, i + 1);
                i = 0;
            }
        }
        if (op != ' ') {
            switch (op) {
                case '*':
                    func = new FuncionBinaria(func, "*", crearFuncion(str, i));
                    break;
                case '/':
                    func = new FuncionBinaria(func, "/", crearFuncion(str, i));
                    break;
            }
        }
        return func;
    }

    private Funcion buscarPotenciaOraiz(String str, String total, int indice) {
        String op = "";
        String subc = "";
        Funcion func;
        int i = 0;
        while ((i < str.length()) && (str.charAt(i) != '^' && !subc.equals("sqrt"))) {
            if (str.charAt(i) == '(') {
                int cantP = 1;
                while (cantP != 0) {
                    subc += str.charAt(i);
                    i++;
                    if (str.charAt(i) == '(') {
                        cantP++;
                    } else if (str.charAt(i) == ')') {
                        cantP--;
                    }
                }
            }
            if (i < str.length() && str.charAt(i) != '(') {
                subc += str.charAt(i);
            }
            i++;
        }
        if (!subc.equals("sqrt")) {
            func = crearFuncion(subc, 0);
        } else {
            func = new FuncionBinaria(crearFuncion(extraerParametro(1, str, i + 1), 0), "sqrt", crearFuncion(extraerParametro(2, str, i + 1), 0));
            i = pasarParentesis(str, i + 1);
        }
        if (i < str.length()) {
            op += str.charAt(i);
        }
        i++;
        if (i < str.length()) {
            if (str.charAt(i) == '(') {
                str = extraerArgumento(str, i + 1);
                i = 0;
            }
        }
        if (op.equals("^")) {
            func = new FuncionBinaria(func, "^", crearFuncion(str, i));
        }
        return func;
    }

    private String extraerParametro(int nroParametro, String cadena, int pos) {
        String parametro = "";
        int i = pos;
        int nroP = 1;
        boolean flag = false;
        while (i < cadena.length() && !flag && !(nroP == nroParametro && cadena.charAt(i) == ',') && cadena.charAt(i) != ')') {
            if (nroP == nroParametro) {
                parametro += cadena.charAt(i);
            } else if (nroP > nroParametro) {
                flag = true;
            }
            if (cadena.charAt(i) == ',') {
                nroP++;
            }
            i++;
        }
        return parametro;
    }

    /**
     * recibe un argumento y el indice del primer caracter. (el primer
     * parentesis esta implicito por lo tanto si se tiene la cadena (22), debe
     * recibir el indice de la cadena a partir del primer 2.) para (22) debe
     * llamarse con i = 1.
     *
     * @param str
     * @param i
     * @return
     */
    private int pasarParentesis(String str, int i) {
        int cantAbiertos = 1;
        while (cantAbiertos != 0 && i < str.length()) {
            if (str.charAt(i) == '(') {
                cantAbiertos++;
            } else {
                if (str.charAt(i) == ')') {
                    cantAbiertos--;
                }
            }
            i++;
        }
        return i;
    }

    private String extraerArgumento(String str, int i) {
        String argumento = "";
        int cantAbiertos = 1;
        int cantCerrados = 0;
        while (i < str.length() && cantAbiertos != cantCerrados) {
            if (str.charAt(i) == '(') {
                cantAbiertos++;
            } else {
                if (str.charAt(i) == ')') {
                    cantAbiertos--;
                }
            }
            if (cantAbiertos - cantCerrados > 0) {
                argumento += str.charAt(i);
            }
            i++;
        }
        return argumento;
    }

    private Funcion crearFuncionVariable(Funcion res, String var) {
        boolean flag = false;
        int i = 0;
        while (i < variables.size() && !flag) {
            if (variables.get(i).equals(var)) {
                flag = true;
                res = new FuncionVariable(i, var);
            }
            i++;
        }
        return res;
    }

    private void preProcesar() {
        int i = 0;
        while (i < formula.length()) {
            if (i + 1 < formula.length()) {
                if ((formula.charAt(i) > 48 && formula.charAt(i) < 57) && (formula.charAt(i + 1) == '-')) {
                    formula = formula.substring(0, i + 1) + "+" + formula.substring(i + 1);
                }
                if (formula.charAt(i) == ')' && formula.charAt(i + 1) == '-') {
                    formula = formula.substring(0, i + 1) + "+" + formula.substring(i + 1);
                }
            }
            i++;
        }
        verificarConsistencia();
    }

    private void verificarConsistencia() {
        int i = 0;
        while (i < formula.length() && i + 1 < formula.length()) {
            if (formula.charAt(i) == '-' && (formula.charAt(i + 1) < 48 || formula.charAt(i + 1) > 57)) {
                formula = formula.substring(0, i + 1) + "1*" + formula.substring(i + 1);
            }
            i++;
        }
    }

    private String obtenerNombre(String cadena) {
        int i = 0;
        String res = "";
        while (i < cadena.length() && cadena.charAt(i) != '(') {
            res += cadena.charAt(i);
            i++;
        }
        return res;
    }

    private String obtenerFormula(String cadena) {
        int i = 0;
        String res;
        while (i < cadena.length() && cadena.charAt(i) != '=') {
            i++;
        }
        res = cadena.substring(i + 1);
        return res;
    }

    private void obtenerVariables(String cadena) {
        int i = 0;
        String res;
        while (i < cadena.length() && cadena.charAt(i) != '(') {
            i++;
        }
        i++;
        while (i < cadena.length() && cadena.charAt(i) != ')') {
            if (cadena.charAt(i) != ',') {
                variables.add(cadena.charAt(i) + "");
            }
            i++;
        }
    }
}
