import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Main {
    String[] jugadors = new String[4];
    Scanner input = new Scanner(System.in);

    public static int jugadores = 0;
    public static int[] territorios = new int[17];

    //Declaración variables comunidades autónomas
    public static int galicia = 2;
    public static int asturias = 2;
    public static int cantabria = 2;
    public static int pais_vasco = 2;
    public static int navarra = 2;
    public static int la_rioja = 2;
    public static int aragon = 2;
    public static int cataluña = 2;
    public static int castilla_y_leon = 2;
    public static int madrid = 2;
    public static int castilla_la_mancha = 2;
    public static int extremadura = 2;
    public static int andalucia = 2;
    public static int murcia = 2;
    public static int canatias = 2;
    public static int baleares = 2;


    public static void main(String[] args) {

        Main main = new Main();
        main.init();

    }

    public void init() {
        int menuItem = 0;
        do {
            System.out.println("1. Agregar jugador");
            System.out.println("2. Asignar territorios");
            System.out.println("3. Turno del jugador");
            System.out.println("4. Estado actual");
            System.out.println("5. Invadir territorio");
            System.out.println("6. Ganar territorio");
            System.out.println("7. Eliminar territorio");
            System.out.println("8. Ganar partida");
            System.out.println("9. Invadir francia");
            System.out.println("10. Salir");
            System.out.print("Ingrese la opción: ");

            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        ordenjugadores();
                        break;
                    case 2:
                        asignacionterritorios();
                        break;
                    case 3:
                        turnojugador();
                        break;
                    case 4:
                        estadoactual();
                        break;
                    case 5:
                        invadirterritorio();
                        break;
                    case 6:
                        ganarterrtorio();
                        break;
                    case 7:
                        eliminarterritorio();
                        break;
                    case 8:
                        ganarpartida();
                        break;
                    case 9:
                        invadirfrancia();
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }else{
                System.out.println("Opción no valida");
            }
            input.nextLine();
            System.out.println("");

        }while(menuItem!=10);

    }
    private static void ordenjugadores(){
        //code ivan, mètode per ordre jugadors
        Random random = new Random();
        int dau = 0;
        String[] x = new String[4];
        int[] daus = new int[4];
        for (int i=0; i<4; i++) {
            System.out.println("Escriu el nom de un jugador");
        }
        System.out.println("Ara es tiraran els daus per decidir l'ordre");

        for(int i=0; i<daus.length; i++) {
            dau = random.nextInt(6) + 1;
            boolean repetit;
            for(int j=0; j<daus.length; j++) {
            }
        }
    }
    private static void asignacionterritorios() {
        if (jugadores == 0) {
            System.out.println("No hay jugadores para asignar territorios");
            return;
        }

        int[] territoriosPorJugador = new int[jugadores];
        Random random = new Random();

        for (int i = 0; i < territoriosPorJugador.length; i++) {
            territoriosPorJugador[i] = 0;
        }

        for (int i = 0; i < territorios.length; i++) {
            if (territorios[i] > 0) {
                int randomPlayer = random.nextInt(jugadores);
                territoriosPorJugador[randomPlayer]++;
                territorios[i]--;
            }
        }

        for (int i = 0; i < territoriosPorJugador.length; i++) {
            System.out.println("Jugador " + (i + 1) + " tiene " + territoriosPorJugador[i] + " territorios.");
        }
    }
    private static void turnojugador(){

    }
    private static void estadoactual(){

    }
    private static void invadirterritorio(){

    }
    private static void ganarterrtorio(){

    }
    private static void eliminarterritorio(){

    }
    private static void ganarpartida(){

    }

    private static void invadirfrancia(){

    }
}
