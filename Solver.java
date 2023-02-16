
/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
import java.util.*;

public class Solver {

    Maze mapita;

    public Solver() {
        // Sientase libre de implementar el contructor de la forma que usted lo desee

        try {
            mapita = new Maze("C:\\Users\\Usuario\\Desktop\\proyectoinfo3\\info3repositorio\\tests\\test-3.txt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String solve(Node nuevoActual) {
        // Implemente su metodo aqui. Sientase libre de implementar métodos adicionales

        /**
         * Node actual = mapita.getStartingSpace();
         * actual = mapita.moveSouth(actual);
         * if (mapita.isExitSpace(actual.xIndex, actual.yIndex, actual.zIndex)) {
         * return "[S]";
         * }
         * 
         * return "[-1]";
         * }
         * 
         * public static void main(String[] args) {
         * Solver prueba = new Solver();
         * String result = prueba.solve();
         * System.out.print(result);
         * }
         */
        if (nuevoActual == null) {
            nuevoActual = mapita.getStartingSpace();

        }
        nuevoActual.visited = true;

        String direccion;
        Node actual;
        Node nodoNor = mapita.moveNorth(nuevoActual);
        Node nodoSur = mapita.moveSouth(nuevoActual);
        Node nodoOeste = mapita.moveWest(nuevoActual);
        Node nodoEste = mapita.moveEast(nuevoActual);
        Node nodoArriba = mapita.moveUp(nuevoActual);
        Node nodoAbajo = mapita.moveDown(nuevoActual);

        if (nuevoActual != nodoNor && !nodoNor.visited && !nodoNor.danger) {
            direccion = "N,";
            actual = nodoNor;
        } else if (nuevoActual != nodoSur && !nodoSur.visited && !nodoSur.danger) {
            direccion = "S,";
            actual = nodoSur;
        } else if (nuevoActual != nodoOeste && !nodoOeste.visited && !nodoOeste.danger) {
            direccion = "O,";
            actual = nodoOeste;
        } else if (nuevoActual != nodoEste && !nodoEste.visited && !nodoEste.danger) {
            direccion = "E,";
            actual = nodoEste;
        } else if (nuevoActual != nodoArriba && !nodoArriba.visited && !nodoArriba.danger) {
            direccion = "U,";
            actual = nodoArriba;
        } else if (nuevoActual != nodoAbajo && !nodoAbajo.visited && !nodoAbajo.danger) {
            direccion = "D,";
            actual = nodoAbajo;
        } else {
            direccion = "[-1]";
            actual = nuevoActual;
        }

        if (actual.isExit) {
            return direccion;
        } else if (actual == nuevoActual) {
            return "sin salida";
        } else {
            return direccion + this.solve(actual);
        }

    }

    public static void main(String[] args) {
        Solver prueba = new Solver();

        String result = prueba.solve(null);
        System.out.print(result);
    }

}