import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            boolean salir = false;
            while (!salir) {
                menu();
                int opcion = scanner.nextInt();
                switch (opcion) {
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
                    case 10:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }

        private static void menu() {
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
        }

    private static void ordenjugadores(){

    }
    private static void asignacionterritorios(){

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