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
            if (menuItem != 2) {
            init();
            }
    }
    private void nuevaPartida() {
        // Lógica para una nueva partida
        System.out.println("Iniciando una nueva partida...");
        jugadors = ordenJugadores();
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
            System.out.println("Escribe el nombre del jugador");
            x[i] = input.next();
        }
        System.out.println("Ahora se decidirá el orden de forma aleatoria");

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


    public void turnoJugador1() {
        int option = 0;
        String afegir_soldats;
        boolean comprobacio;
        Scanner input = new Scanner(System.in);
        System.out.println("Turno de " + jugadors[0] + ".");
        System.out.println("Tienes los siguientes territorios: ");
        for (int i=0; i<jugador1.length; i++) {
            if (jugador1[i] != null) {
                System.out.print(jugador1[i] + " ");
            }
        }
        System.out.println("Obtienes 2 soldados al inicio del turno, ¿en qué comunidad quieres colocarlos?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador1.length; i++){
                if (jugador1[i] != null) {
                    if (afegir_soldats.equals(jugador1[i])) {
                        comprobacio = false;
                    }
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Esta comunidad autónoma no existe o no es de tu propiedad, por favor, ingresa una que sea tuya.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("\"Se han añadido 2 soldados a la comunidad autónoma de" + afegir_soldats + ".");
        System.out.println("Actualmente el mapa queda así:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldados");
        }
        do {
            do {
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Atacar una comunidad");
                System.out.println("2. Ver estado de las comunidades autónomas");
                System.out.println("3. Pasar turno");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("¡ERROR! Ingresa una opción válida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    String atacant;
                    String defensor;
                    System.out.println("Selecciona el territorio con el que atacarás:");
                    do {
                        comprobacio = true;
                        atacant = input.next();
                        for (int i=0; i<jugador1.length; i++){
                            if (jugador1[i] != null) {
                                if (atacant.equals(jugador1[i])) {
                                    comprobacio = false;
                                }
                            }
                        }
                        if(comprobacio){
                            System.out.println("¡ERROR! Esta comunidad autónoma no existe o no puedes atacarla.");
                        }
                    } while(comprobacio);
                    System.out.println("Selecciona el territorio con el que atacarás:");
                    do {
                        comprobacio = true;
                        defensor = input.next();
                        for (int i=0; i<9; i++){
                            if (jugador2[i] != null && defensor.equals(jugador2[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador1, jugador2);
                            } else if (jugador3[i] != null && defensor.equals(jugador3[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador1, jugador3);
                            } else if (jugador4[i] != null && defensor.equals(jugador4[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador1, jugador4);
                            }
                        }
                        if(comprobacio){
                            System.out.println("¡ERROR! Esta comunidad autónoma no existe o no puedes atacarla.");
                        }
                    } while(comprobacio);
                    ganar = ganarPartida(jugador1, ganar);
                    if(ganar){
                        System.out.println("Enhorabuena! El jugador " + jugadors[0] + " ha ganado la partida!");
                    } else {
                        turnoJugador2();
                    }
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("De quien quieres ver las comunidades autonomas?");
                        System.out.println("1. " + jugadors[1]);
                        System.out.println("2. " + jugadors[2]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Ver todas las comunidades con el número de soldados.");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Pon una opción valida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador3[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("El estado del mapa es el siguiente: ");
                                for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " soldados");
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
        System.out.println("Tienes los siguientes territorios: ");
        for (int i=0; i<jugador2.length; i++) {
            if (jugador2[i] != null) {
                System.out.print(jugador2[i] + " ");
            }
        }
        System.out.println("Ganas 2 soldados por inicio de turno, ¿en qué comunidad los quieres poner?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador2.length; i++){
                if(jugador2[i] != null) {
                    if (afegir_soldats.equals(jugador2[i])) {
                        comprobacio = false;
                    }
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Esta comunidad autónoma no existe o no es de tu propiedad, por favor, inserta una que sea tuya.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("Se han añadido 2 soldados a la comunidad autónoma de " + afegir_soldats + ".");
        System.out.println("Actualmente el mapa queda así:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldados");
        }
        do {
            do {
                System.out.println("¿Qué quieres hacer?");
                System.out.println("1. Atacar una comunidad");
                System.out.println("2. Ver estado comunidades autónomas");
                System.out.println("3. Pasar turno");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Pon una opción válida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    String atacant;
                    String defensor;
                    System.out.println("Selecciona el territorio con el que atacarás:");
                    do {
                        comprobacio = true;
                        atacant = input.next();
                        for (int i=0; i<jugador2.length; i++){
                            if (jugador2[i] != null) {
                                if (atacant.equals(jugador2[i])) {
                                    comprobacio = false;
                                }
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    System.out.println("Selecciona el territorio que atacarás:");
                    do {
                        comprobacio = true;
                        defensor = input.next();
                        for (int i=0; i<9; i++){
                            if (jugador1[i] != null && defensor.equals(jugador1[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador2, jugador1);
                            } else if (jugador3[i] != null && defensor.equals(jugador3[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador2, jugador3);
                            } else if (jugador4[i] != null && defensor.equals(jugador4[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador2, jugador4);
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    ganar = ganarPartida(jugador2, ganar);
                    if(ganar){
                        System.out.println("¡Enhorabuena! ¡El jugador " + jugadors[1] + " ha ganado la partida!");
                    } else {
                        turnoJugador3();
                    }
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("¿De quién quieres ver las comunidades autónomas?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[2]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Ver todas las comunidades con el número de soldados");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Pon una opción válida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador3[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("El estado del mapa es el siguiente: ");
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
        System.out.println("Tienes los siguientes territorios: ");
        for (int i=0; i<jugador3.length; i++) {
            if (jugador3[i] != null) {
                System.out.print(jugador3[i] + " ");
            }
        }
        System.out.println("Ganas 2 soldados por inicio de turno, ¿en qué comunidad los quieres poner?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador3.length; i++){
                if (jugador3[i] != null) {
                    if (afegir_soldats.equals(jugador3[i])) {
                        comprobacio = false;
                    }
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Esta comunidad autónoma no existe o no es de tu propiedad, por favor, inserta una que sea tuya.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("Se han añadido 2 soldados a la comunidad autónoma de " + afegir_soldats + ".");
        System.out.println("Actualmente el mapa queda así:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldados");
        }
        do {
            do {
                System.out.println("¿Qué quieres hacer?");
                System.out.println("1. Atacar una comunidad");
                System.out.println("2. Ver estado comunidades autónomas");
                System.out.println("3. Pasar turno");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Pon una opción válida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    String atacant;
                    String defensor;
                    System.out.println("Selecciona el territorio con el que atacarás:");
                    do {
                        comprobacio = true;
                        atacant = input.next();
                        for (int i=0; i<jugador3.length; i++){
                            if (jugador3[i] != null) {
                                if (atacant.equals(jugador3[i])) {
                                    comprobacio = false;
                                }
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    System.out.println("Selecciona el territorio que atacarás:");
                    do {
                        comprobacio = true;
                        defensor = input.next();
                        for (int i=0; i<9; i++){
                            if (jugador1[i] != null && defensor.equals(jugador1[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador3, jugador1);
                            } else if (jugador2[i] != null && defensor.equals(jugador2[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador3, jugador2);
                            } else if (jugador4[i] != null && defensor.equals(jugador4[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador3, jugador4);
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    ganar = ganarPartida(jugador3, ganar);
                    if(ganar){
                        System.out.println("¡Enhorabuena! ¡El jugador " + jugadors[2] + " ha ganado la partida!");
                    } else {
                        turnoJugador4();
                    }
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("¿De quién quieres ver las comunidades autónomas?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[1]);
                        System.out.println("3. " + jugadors[3]);
                        System.out.println("4. Ver todas las comunidades con el número de soldados");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Pon una opción válida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador4.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador4[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("El estado del mapa es el siguiente: ");
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
        System.out.println("Turno de " + jugadors[3] + ".");
        System.out.println("Tienes los siguientes territorios: ");
        for (int i=0; i<jugador4.length; i++) {
            if (jugador4[i] != null) {
                System.out.print(jugador4[i] + " ");
            }
        }
        System.out.println("Ganas 2 soldados por inicio de turno, ¿en qué comunidad autónoma los quieres colocar?");
        do {
            comprobacio = true;
            afegir_soldats = input.next();
            for (int i=0; i<jugador4.length; i++){
                if (jugador4[i] != null) {
                    if (afegir_soldats.equals(jugador4[i])) {
                        comprobacio = false;
                    }
                }
            }
            if(comprobacio){
                System.out.println("ERROR! Esta comunidad autónoma no existe o no es de tu propiedad, por favor, inserta una que sea tuya.");
            }
        } while(comprobacio);
        int valor_actual = comunitats.get(afegir_soldats);
        comunitats.put(afegir_soldats, valor_actual + 2);
        System.out.println("Se han añadido 2 soldados a la comunidad autónoma de " + afegir_soldats + ".");
        System.out.println("Actualmente el mapa queda así:");
        for(Map.Entry<String, Integer> entry : comunitats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " soldats");
        }
        do {
            do {
                System.out.println("¿Qué quieres hacer?");
                System.out.println("1. Atacar una comunidad");
                System.out.println("2. Ver estado comunidades autónomas");
                System.out.println("3. Pasar turno");
                option = input.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("ERROR! Pon una opción válida.");
                }
            } while (option < 1 || option > 3);
            switch (option) {
                case 1:
                    String atacant;
                    String defensor;
                    System.out.println("Selecciona el territorio con el que atacarás:");
                    do {
                        comprobacio = true;
                        atacant = input.next();
                        for (int i=0; i<jugador4.length; i++){
                            if (jugador4[i] != null) {
                                if (atacant.equals(jugador4[i])) {
                                    comprobacio = false;
                                }
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    System.out.println("Selecciona el territorio que atacarás:");
                    do {
                        comprobacio = true;
                        defensor = input.next();
                        for (int i=0; i<9; i++){
                            if (jugador1[i] != null && defensor.equals(jugador1[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador4, jugador1);
                            } else if (jugador2[i] != null && defensor.equals(jugador2[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador4, jugador2);
                            } else if (jugador3[i] != null && defensor.equals(jugador3[i])) {
                                comprobacio = false;
                                invadirTerritorio(atacant, defensor, jugador4, jugador3);
                            }
                        }
                        if(comprobacio){
                            System.out.println("ERROR! Esta comunidad autónoma no existe o no la puedes atacar.");
                        }
                    } while(comprobacio);
                    ganar = ganarPartida(jugador4, ganar);
                    if(ganar){
                        System.out.println("¡Enhorabuena! ¡El jugador " + jugadors[3] + " ha ganado la partida!");
                    } else {
                        turnoJugador1();
                    }
                    break;
                case 2:
                    int submenu = 0;
                    do {
                        System.out.println("¿De quién quieres ver las comunidades autónomas?");
                        System.out.println("1. " + jugadors[0]);
                        System.out.println("2. " + jugadors[1]);
                        System.out.println("3. " + jugadors[2]);
                        System.out.println("4. Ver todas las comunidades con el número de soldados");
                        submenu = input.nextInt();
                        if (submenu < 1 || submenu > 4) {
                            System.out.println("ERROR! Pon una opción válida");
                        }
                        switch (submenu) {
                            case 1:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador1.length; i++) {
                                    if (jugador1[i] != null) {
                                        System.out.print(jugador1[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador2.length; i++) {
                                    if (jugador2[i] != null) {
                                        System.out.print(jugador2[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Este jugador tiene los siguientes territorios: ");
                                for (int i=0; i<jugador3.length; i++) {
                                    if (jugador4[i] != null) {
                                        System.out.print(jugador3[i] + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("El estado del mapa es el siguiente: ");
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

    private static void invadirTerritorio(String atacant, String defensor, String[] j1, String[] j2) {
        Random random = new Random();
        int x = comunitats.get(atacant);
        int y = comunitats.get(defensor);
        int z = x + y;
        int aleatori = random.nextInt(z) + 1;
        boolean resultat;
        if (aleatori <= y) {
            System.out.println("El ataque no ha tenido éxito, has perdido el territorio de " + atacant + ".");
            resultat = false;
        } else {
            System.out.println("El ataque ha tenido éxito! Has ganado el territorio de  " + defensor + ".");
            resultat = true;
        }
        if(resultat == true) {
            for(int i=0; i< j1.length; i++) {
                if (j1[i].isEmpty() || j1[i] == null) {
                    j1[i] = defensor;
                    break;
                }
            }
            for(int i=0; i<j2.length; i++) {
                if (j2[i] != null) {
                    if (j2[i].equals(defensor)) {
                        j2[i] = "";
                        break;
                    }
                }
            }
        } else {
            for(int i=0; i< j2.length; i++) {
                if (j2[i].isEmpty() || j2[i] == null) {
                    j2[i] = atacant;
                    break;
                }
            }
            for(int i=0; i<j1.length; i++) {
                if (j1[i] != null) {
                    if (j1[i].equals(atacant)) {
                        j1[i] = "";
                        break;
                    }
                }
            }
        }
    }

    private static boolean ganarPartida(String[] jugador, boolean ganador){
        ganador = false;
        int contador = 0;
        for(int i=0; i < jugador.length; i++) {
            if (jugador[i] != "") {
                contador = contador + 1;
            }
        }
        if (contador == 9){
            ganador = true;
        }
        return ganador;
    }
}
