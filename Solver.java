
/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
import java.util.*;
import java.util.concurrent.*;
import java.util.LinkedList;

public class Solver {

    Maze mapita;
    private boolean visited;///////

    LinkedList<Node> rutas;

    public Solver() {
        // Sientase libre de implementar el contructor de la forma que usted lo desee

        try {
            mapita = new Maze("C:\\Users\\Usuario\\Desktop\\proyectoinfo3\\info3repositorio\\tests\\test-7.txt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        rutas = new LinkedList<Node>();

    }

    /////////////
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    //////////////////////

    public String solve(Node nuevoActual, LinkedList opcionesRutas) {
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
        /// ---------------

        if (nuevoActual == null) {
            nuevoActual = mapita.getStartingSpace();

        }

        if(opcionesRutas.isEmpty()){
            opcionesRutas.add(nuevoActual);
        }
        else if(!opcionesRutas.isEmpty()){
            opcionesRutas.remove();   
        }

        

        // --------boolean visitados;//
        ///////

        // ----visitados = true;// ------



        String direccion;
        Node actual;
        Node nodoNor = mapita.moveNorth(nuevoActual);
        Node nodoSur = mapita.moveSouth(nuevoActual);
        Node nodoOeste = mapita.moveWest(nuevoActual);
        Node nodoEste = mapita.moveEast(nuevoActual);
        Node nodoArriba = mapita.moveUp(nuevoActual);
        Node nodoAbajo = mapita.moveDown(nuevoActual);
        ///////////////////////////

        if (nuevoActual != nodoNor && !nodoNor.danger && ) {
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

        while (!actual.visited) {
            if (actual.isExit) {
                return direccion;
            } else if (actual == nuevoActual) {
                return "sin salida";
            } else {
                return direccion + this.solve(actual);
            }

        }
        return direccion;

    }

    public static void main(String[] args) {
        Solver prueba = new Solver();

        String result = prueba.solve(null);
        System.out.print(result);
    }

}