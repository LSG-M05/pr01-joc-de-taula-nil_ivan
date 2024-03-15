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
    public static int cataluna = 2;
    public static int castilla_y_leon = 2;
    public static int madrid = 2;
    public static int castilla_la_mancha = 2;
    public static int extremadura = 2;
    public static int andalucia = 2;
    public static int murcia = 2;
    public static int canarias = 2;
    public static int baleares = 2;


    public static void main(String[] args) {

        //Main main = new Main();
        //main.init();
        String[] ordre = new String[4];
        ordre = ordenJugadores();
        for (int i = 0; i < ordre.length; i++) {
            System.out.println(ordre[i]);
        }

    }

    public void init() {
        int menuItem = 0;
        do {
            System.out.println("------- Menú -------");
            System.out.println("1. Nueva partida");
            System.out.println("2. Salir");
            System.out.print("Ingrese la opción: ");

            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        nuevaPartida();
                        break;
                    case 2:
                        System.out.println("Saliendo del juego...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } else {
                System.out.println("Opción no válida");
            }
            input.nextLine();
            System.out.println("");

        } while (menuItem != 2);

    }

    private void nuevaPartida() {
        // Lógica para una nueva partida
        System.out.println("Iniciando una nueva partida...");
        ordenJugadores();
        asignacionTerritorios();
        turnoJugador();
    }

    private static String[] ordenJugadores() {
        //code ivan, mètode per ordre jugadors
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String[] x = new String[4];
        int[] daus = new int[4];
        String[] ordre_final = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Escriu el nom de un jugador");
            x[i] = input.next();
        }
        System.out.println("Ara es decidirà l'ordre aleatoriament");

        for (int i = 0; i < daus.length; i++) {
            int dau;
            boolean repetit;
            do {
                repetit = false;
                dau = random.nextInt(4) + 1;
                for (int j = 0; j < i; j++) {
                    if (dau == daus[j]) {
                        repetit = true;
                        break;
                    }
                }
                daus[i] = dau;
            } while (repetit);
        }
        for (int i = 0; i < daus.length; i++) {
            if (daus[i] == 1) {
                ordre_final[i] = x[0];
            } else if (daus[i] == 2) {
                ordre_final[i] = x[1];
            } else if (daus[i] == 3) {
                ordre_final[i] = x[2];
            } else if (daus[i] == 4) {
                ordre_final[i] = x[3];
            }
        }
        return ordre_final;
    }

    private void asignacionTerritorios() {
        if (jugadores == 0) {
            System.out.println("No hay jugadores para asignar territorios");
            return;
        }

        Random random = new Random();

        for (int i = 0; i < territorios.length; i++) {
            if (territorios[i] > 0) {
                int randomPlayer = random.nextInt(jugadores);
                switch (i) {
                    case 0:
                        galicia--;
                        break;
                    case 1:
                        asturias--;
                        break;
                    case 2:
                        cantabria--;
                        break;
                    case 3:
                        pais_vasco--;
                        break;
                    case 4:
                        navarra--;
                        break;
                    case 5:
                        la_rioja--;
                        break;
                    case 6:
                        aragon--;
                        break;
                    case 7:
                        cataluna--;
                        break;
                    case 8:
                        castilla_y_leon--;
                        break;
                    case 9:
                        madrid--;
                        break;
                    case 10:
                        castilla_la_mancha--;
                        break;
                    case 11:
                        extremadura--;
                        break;
                    case 12:
                        andalucia--;
                        break;
                    case 13:
                        murcia--;
                        break;
                    case 14:
                        canarias--;
                        break;
                    case 15:
                        baleares--;
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println("Asignación de territorios completada.");
    }

    private void turnoJugador() {
    }

    private static void estadoActual() {

    }

    private static void invadirTerritorio(int jugador) {
        // Sumar los soldados al territorio
        switch (jugador) {
            case 1:
                galicia += 2;
                break;
            case 2:
                asturias += 2;
                break;
            case 3:
                cantabria += 2;
                break;
            case 4:
                pais_vasco += 2;
                break;
            case 5:
                navarra += 2;
                break;
            case 6:
                la_rioja += 2;
                break;
            case 7:
                aragon += 2;
                break;
            case 8:
                cataluna += 2;
                break;
            case 9:
                castilla_y_leon += 2;
                break;
            case 10:
                madrid += 2;
                break;
            case 11:
                castilla_la_mancha += 2;
                break;
            case 12:
                extremadura += 2;
                break;
            case 13:
                andalucia += 2;
                break;
            case 14:
                murcia += 2;
                break;
            case 15:
                canarias += 2;
                break;
            case 16:
                baleares += 2;
                break;
            default:
                break;
        }
        System.out.println("Has invadido con éxito el territorio.");
    }

    private void ganarTerritorio(int jugador) {
        Random random = new Random();
        int probabilidad = random.nextInt(2); // 50% de probabilidad

        if (probabilidad == 0) {
            // El jugador gana la batalla
            System.out.println("¡Has ganado la batalla!");
            invadirTerritorio(jugador); // Se suman los soldados al territorio
        } else {
            // El jugador pierde la batalla
            System.out.println("¡Has perdido la batalla!");
        }
    }

    private void eliminarTerritorio(int jugador) {
        Random random = new Random();
        int probabilidad = random.nextInt(2); // 50% de probabilidad

        if (probabilidad == 0) {
            // El jugador pierde el territorio
            switch (jugador) {
                case 1:
                    galicia = 0;
                    break;
                case 2:
                    asturias = 0;
                    break;
                case 3:
                    cantabria = 0;
                    break;
                case 4:
                    pais_vasco = 0;
                    break;
                case 5:
                    navarra = 0;
                    break;
                case 6:
                    la_rioja = 0;
                    break;
                case 7:
                    aragon = 0;
                    break;
                case 8:
                    cataluna = 0;
                    break;
                case 9:
                    castilla_y_leon = 0;
                    break;
                case 10:
                    madrid = 0;
                    break;
                case 11:
                    castilla_la_mancha = 0;
                    break;
                case 12:
                    extremadura = 0;
                    break;
                case 13:
                    andalucia = 0;
                    break;
                case 14:
                    murcia = 0;
                    break;
                case 15:
                    canarias = 0;
                    break;
                case 16:
                    baleares = 0;
                    break;
                default:
                    break;
            }
            System.out.println("Has perdido el territorio.");
        } else {
            // El jugador conserva el territorio
            System.out.println("Has mantenido tu territorio.");
        }
        //code nil

    }

    private static void ganarPartida() {

    }

    private static void ganarpartida() {

    }
}
