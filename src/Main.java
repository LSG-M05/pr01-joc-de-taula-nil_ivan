import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public String[] jugadors = new String[4];
    public boolean ganar = false;
    public String[] jugador1 = {"galicia", "asturias", "cantabria", "pais vasco", "", "", "", "", ""};
    public String[] jugador2 = {"navarra", "la rioja", "aragon", "cataluña", "", "", "", "", ""};
    public String[] jugador3 = {"castilla y leon", "madrid", "castilla la mancha", "extremadura", "", "", "", "", ""};
    public String[] jugador4 = {"andalucia", "murcia", "canarias", "baleares", "", "", "", "", ""};
    Scanner input = new Scanner(System.in);

    public static int jugadores = 4;
    public static int[] territorios = new int[17];

    //Declaración variables comunidades autónomas
    private static final Map<String, Integer> comunitats = new HashMap<>();
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
        comunitats.put("galicia", 2);
        comunitats.put("asturias", 2);
        comunitats.put("cantabria", 2);
        comunitats.put("pais vasco", 2);
        comunitats.put("navarra", 2);
        comunitats.put("la rioja", 2);
        comunitats.put("aragon", 2);
        comunitats.put("cataluna", 2);
        comunitats.put("castilla y leon", 2);
        comunitats.put("madrid", 2);
        comunitats.put("castilla la mancha", 2);
        comunitats.put("extremadura", 2);
        comunitats.put("andalucia", 2);
        comunitats.put("murcia", 2);
        comunitats.put("canarias", 2);
        comunitats.put("baleares", 2);

        Main main = new Main();
        main.init();


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
        jugadors = ordenJugadores();
        asignacionTerritorios();
        turnoJugador1();
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
    public void turnoJugador1() {
        int option = 0;
        String afegir_soldats;
        boolean comprobacio;
        Scanner input = new Scanner(System.in);
        System.out.println("Torn de " + jugadors[0] + ".");
        System.out.println("Guanyes 2 soldats per inici de torn, a quina comunitat els vols posar?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador1.length; i++){
                if (afegir_soldats.equals(jugador1[i])) {
                    comprobacio = false;
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Aquesta comunitat autònoma no existeix o no és de la teva propietat, si us plau, insereixi una que sigui teva.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("S'han afegit 2 soldats a la comunitat autònoma de " + afegir_soldats + ".");
        System.out.println("Actualment el mapa queda així:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
        }
        do {
            System.out.println("Què vols fer?");
            System.out.println("1. Atacar una comunitat");
            System.out.println("2. Passar torn");
            option = input.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("ERROR! Posa una opció vàlida.");
            }
        } while(option < 1 || option > 2);
        switch (option) {
            case 1:

                break;
            case 2:
                turnoJugador2();
                break;
        }
    }

    public void turnoJugador2(){
        int option = 0;
        String afegir_soldats;
        boolean comprobacio;
        Scanner input = new Scanner(System.in);
        System.out.println("Torn de " + jugadors[1] + ".");
        System.out.println("Guanyes 2 soldats per inici de torn, a quina comunitat els vols posar?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador2.length; i++){
                if (afegir_soldats.equals(jugador2[i])) {
                    comprobacio = false;
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Aquesta comunitat autònoma no existeix o no és de la teva propietat, si us plau, insereixi una que sigui teva.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("S'han afegit 2 soldats a la comunitat autònoma de " + afegir_soldats + ".");
        System.out.println("Actualment el mapa queda així:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
        }
        do {
            System.out.println("Què vols fer?");
            System.out.println("1. Atacar una comunitat");
            System.out.println("2. Passar torn");
            option = input.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("ERROR! Posa una opció vàlida.");
            }
        } while(option < 1 || option > 2);
        switch (option) {
            case 1:
                break;
            case 2:
                turnoJugador3();
                break;
        }
    }

    public void turnoJugador3(){
        int option = 0;
        String afegir_soldats;
        boolean comprobacio;
        Scanner input = new Scanner(System.in);
        System.out.println("Torn de " + jugadors[2] + ".");
        System.out.println("Guanyes 2 soldats per inici de torn, a quina comunitat els vols posar?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador3.length; i++){
                if (afegir_soldats.equals(jugador3[i])) {
                    comprobacio = false;
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Aquesta comunitat autònoma no existeix o no és de la teva propietat, si us plau, insereixi una que sigui teva.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("S'han afegit 2 soldats a la comunitat autònoma de " + afegir_soldats + ".");
        System.out.println("Actualment el mapa queda així:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
        }
        do {
            System.out.println("Què vols fer?");
            System.out.println("1. Atacar una comunitat");
            System.out.println("2. Passar torn");
            option = input.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("ERROR! Posa una opció vàlida.");
            }
        } while(option < 1 || option > 2);
        switch (option) {
            case 1:
                break;
            case 2:
                turnoJugador4();
                break;
        }
    }

    public void turnoJugador4(){
        int option = 0;
        String afegir_soldats;
        boolean comprobacio;
        Scanner input = new Scanner(System.in);
        System.out.println("Torn de " + jugadors[3] + ".");
        System.out.println("Guanyes 2 soldats per inici de torn, a quina comunitat els vols posar?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador4.length; i++){
                if (afegir_soldats.equals(jugador4[i])) {
                    comprobacio = false;
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Aquesta comunitat autònoma no existeix o no és de la teva propietat, si us plau, insereixi una que sigui teva.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("S'han afegit 2 soldats a la comunitat autònoma de " + afegir_soldats + ".");
        System.out.println("Actualment el mapa queda així:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
        }
        do {
            System.out.println("Què vols fer?");
            System.out.println("1. Atacar una comunitat");
            System.out.println("2. Passar torn");
            option = input.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("ERROR! Posa una opció vàlida.");
            }
        } while(option < 1 || option > 2);
        switch (option) {
            case 1:
                break;
            case 2:
                turnoJugador1();
                break;
        }
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
    }
    private static boolean ganarPartida(String[] jugador){
        boolean ganador = false;
        int contador = 0;
        for(int i=0; i < jugador.length; i++) {
            if (jugador[i] != null) {
                contador = contador + 1;
            }
        }
        if (contador == 9){
            ganador = true;
        }
        return ganador;
    }
    private static void invadirFrancia(){

    }
}
