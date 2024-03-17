import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public String[] jugadors = new String[4];
    public boolean ganar = false;
    public String[] jugador1 = {"galicia", "asturias", "cantabria", "pais vasco", "", "", "", "", ""};
    public String[] jugador2 = {"navarra", "la rioja", "aragon", "cataluna", "", "", "", "", ""};
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
            do {
                System.out.println("Què vols fer?");
                System.out.println("1. Atacar una comunitat");
                System.out.println("2. Veure estat comunitats autònomes");
                System.out.println("3. Passar torn");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Posa una opció vàlida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    System.out.println("Selecciona el territorio que quieres atacar:");
                    invadirTerritorio(afegir_soldats);
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("De qui vols veure les comunitats autònomes?");
                        System.out.println("1. " + jugadors[1]);
                        System.out.println("2. " + jugadors[2]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Veure totes les comunitats amb el número de soldats");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Posa una opció vàlida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador3[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("L'estat del mapa és el següent: ");
                                for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
                                }
                                break;
                        }
                    } while (submenu < 1 || submenu > 4);
                    break;
                case 3:
                    turnoJugador2();
                    break;
            }
        } while (option == 2);
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
            do {
                System.out.println("Què vols fer?");
                System.out.println("1. Atacar una comunitat");
                System.out.println("2. Veure estat comunitats autònomes");
                System.out.println("3. Passar torn");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Posa una opció vàlida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    System.out.println("Selecciona el territorio que quieres atacar:");
                    invadirTerritorio(afegir_soldats);
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("De qui vols veure les comunitats autònomes?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[2]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Veure totes les comunitats amb el número de soldats");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Posa una opció vàlida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador3[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("L'estat del mapa és el següent: ");
                                for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
                                }
                                break;
                        }
                    } while (submenu < 1 || submenu > 4);
                    break;
                case 3:
                    turnoJugador3();
                    break;
            }
        } while (option == 2);
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
            do {
                System.out.println("Què vols fer?");
                System.out.println("1. Atacar una comunitat");
                System.out.println("2. Veure estat comunitats autònomes");
                System.out.println("3. Passar torn");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Posa una opció vàlida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    System.out.println("Selecciona el territorio que quieres atacar:");
                    invadirTerritorio(afegir_soldats);
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("De qui vols veure les comunitats autònomes?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[1]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Veure totes les comunitats amb el número de soldats");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Posa una opció vàlida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("L'estat del mapa és el següent: ");
                                for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
                                }
                                break;
                        }
                    } while (submenu < 1 || submenu > 4);
                    break;
                case 3:
                    turnoJugador4();
                    break;
            }
        } while(option == 2);
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
            do {
                System.out.println("Què vols fer?");
                System.out.println("1. Atacar una comunitat");
                System.out.println("2. Veure estat comunitats autònomes");
                System.out.println("3. Passar torn");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Posa una opció vàlida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    System.out.println("Selecciona el territorio que quieres atacar:");
                    invadirTerritorio(afegir_soldats);
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("De qui vols veure les comunitats autònomes?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[1]);
                        System.out.println("3. " + jugadors[2]);
                        System.out.println("4. Veure totes les comunitats amb el número de soldats");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Posa una opció vàlida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Aquest jugador té els següents territoris: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("L'estat del mapa és el següent: ");
                                for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
                                }
                                break;
                        }
                    } while (submenu < 1 || submenu > 4);
                    break;
                case 3:
                    turnoJugador1();
                    break;
            }
        } while(option == 2);
    }

    private static void estadoActual() {

    }

    private static void invadirTerritorio(String territorioAtacante) {
        Random random = new Random();
        // Obtener el número de soldados en el territorio atacante
        int soldadosAtacante = comunitats.get(territorioAtacante);

        // Seleccionar un territorio aleatorio del oponente
        ArrayList<String> territoriosOponente = new ArrayList<>(comunitats.keySet());
        territoriosOponente.remove(territorioAtacante); // Remover el territorio atacante de la lista
        String territorioDefensor = territoriosOponente.get(random.nextInt(territoriosOponente.size()));

        // Obtener el número de soldados en el territorio defensor
        int soldadosDefensor = comunitats.get(territorioDefensor);

        // Calcular el porcentaje de probabilidad de ganar el ataque
        double probabilidadAtaque = (double) soldadosAtacante / (soldadosAtacante + soldadosDefensor);

        // Generar un número aleatorio para determinar el resultado del ataque
        double resultado = random.nextDouble();

        if (resultado < probabilidadAtaque) {
            // El atacante gana el ataque
            System.out.println("¡El ataque ha tenido éxito! " + territorioAtacante + " conquista " + territorioDefensor);
            // El atacante se lleva todos los soldados del defensor
            comunitats.put(territorioAtacante, soldadosAtacante + soldadosDefensor);
            comunitats.put(territorioDefensor, 0);
        } else {
            // El atacante pierde el ataque
            System.out.println("El ataque ha fracasado. " + territorioAtacante + " intentó conquistar " + territorioDefensor);
            // El defensor se lleva los soldados del atacante
            comunitats.put(territorioAtacante, 0);
            comunitats.put(territorioDefensor, soldadosAtacante + soldadosDefensor);
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
}
