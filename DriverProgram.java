import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Estudiante: Joel Jaquez
 * Carne: 23369
 * Carrera: Ingenieria en Sistemas
 * Fecha de inicio: 22/9/2023
 * Fecha de finalizacion: 22/9/2023
 * DriverProgram sirve como punto de entrada para el sistema de registro 
 * y análisis del campeonato internacional de balonmano.
 * Permite registrar jugadores, mostrarlos, identificar a los porteros con 
 * mejor rendimiento y contar extremos con alta efectividad.
*/
public class DriverProgram {
    private static ArrayList<Jugador> jugadores = new ArrayList<>(); /** Lista para almacenar los jugadores registrados en el sistema. */
    private static Scanner scanner = new Scanner(System.in); /** Objeto Scanner para capturar la entrada del usuario. */

    /**
     * Método principal que ejecuta el menú interactivo del programa.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este contexto).
     */
    public static void main(String[] args) {
         int opcion;
        do {
            System.out.println("\nLiga de Campeones de Europa");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Mostrar Jugadores");
            System.out.println("3. Mostrar 3 mejores porteros");
            System.out.println("4. Extremos con más del 85% de efectividad");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarJugador(); /**Registra un nuevo jugador (Portero o Extremo) basándose en la entrada del usuario.*/
                    break;
                case 2:
                    mostrarJugadores(); /**Muestra la información de todos los jugadores registrados en el sistema.*/
                    break;
                case 3:
                    mostrarMejoresPorteros(); /**Muestra la información de los 3 porteros con mayor efectividad.*/
                    break;
                case 4:
                    contarExtremosEficientes(); /**Muestra y cuenta el número de los extremos con una efectividad superiro al 85% .*/
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el programa!"); /**Muestra un mensaje al salir del programa.*/
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo."); /**Muestra un mensaje si se ingresa una opción incorrecta.*/
            }
        } while (opcion != 5);
    }

    private static void registrarJugador() {
        System.out.println("\nRegistro de Jugador");
        System.out.println("1. Portero");
        System.out.println("2. Extremo");
        System.out.print("Seleccione el tipo de jugador: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("País: ");
        String pais = scanner.nextLine();
        
        System.out.print("Club: ");
        String club = scanner.nextLine();

        System.out.print("Faltas: ");
        int faltas = scanner.nextInt();
        
        System.out.print("Goles directos: ");
        int golesDirectos = scanner.nextInt();
        
        System.out.print("Total de lanzamientos: ");
        int totalLanzamientos = scanner.nextInt();
        
        if (tipo == 1) {
            System.out.print("Paradas efectivas: ");
            int paradasEfectivas = scanner.nextInt();
            
            System.out.print("Goles recibidos: ");
            int golesRecibidos = scanner.nextInt();

            jugadores.add(new Portero(nombre, pais, club, faltas, golesDirectos, totalLanzamientos, paradasEfectivas, golesRecibidos));
        } else if (tipo == 2) {
            System.out.print("Pases: ");
            int pases = scanner.nextInt();
            
            System.out.print("Asistencias efectivas: ");
            int asistenciasEfectivas = scanner.nextInt();

            jugadores.add(new Extremo(nombre, pais, club, faltas, golesDirectos, totalLanzamientos, pases, asistenciasEfectivas));
        } else {
            System.out.println("Tipo de jugador no válido.");
        }
    }

    private static void mostrarJugadores() {
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Portero) {
                System.out.println("\n--- Portero ---");
            } else {
                System.out.println("\n--- Extremo ---");
            }
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("País: " + jugador.getPais());
            System.out.println("Club: " + jugador.getClub());
            System.out.println("Efectividad: " + jugador.efectividad() + "%");
        }
    }

    private static void mostrarMejoresPorteros() {
        jugadores.stream()
                .filter(j -> j instanceof Portero)
                .sorted(Comparator.comparing(Jugador::efectividad).reversed())
                .limit(3)
                .forEach(j -> {
                    System.out.println("\n--- Portero ---");
                    System.out.println("Nombre: " + j.getNombre());
                    System.out.println("Efectividad: " + j.efectividad() + "%");
                });
    }

    private static void contarExtremosEficientes() {
        long count = jugadores.stream()
                .filter(j -> j instanceof Extremo && j.efectividad() > 85)
                .count();
        
        System.out.println("Número de extremos con más del 85% de efectividad: " + count);
    }
}