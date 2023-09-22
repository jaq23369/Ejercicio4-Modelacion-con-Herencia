/**
 * Estudiante: Joel Jaquez
 * Carne: 23369
 * Carrera: Ingenieria en Sistemas
 * Fecha de inicio: 22/9/2023
 * Fecha de finalizacion: 22/9/2023
 * Clase que Representa un extremo en la Liga de Campeones de Europa.
*/

public class Extremo extends Jugador{
    private int pases; /** Número de pases realizados por el extremo */
    private int asistenciasEfectivas; /** Número de asistencias efectivas realizadas por el extremo */

    /**
     * Constructor de la clase Extremo.
     *
     * @param nombre Nombre del extremo
     * @param pais País de origen del extremo
     * @param faltas Número de faltas cometidas
     * @param golesDirectos Número de goles directos anotados
     * @param totalLanzamientos Número total de lanzamientos realizados
     * @param pases Número de pases realizados
     * @param asistenciasEfectivas Número de asistencias efectivas realizadas
     */
    public Extremo(String nombre, String pais, String club, int faltas, int golesDirectos, int totalLanzamientos, int pases, int asistenciasEfectivas) {
        super(nombre, pais, club, faltas, golesDirectos, totalLanzamientos);
        this.pases = pases;
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    /**
     * Calcula la efectividad del extremo.
     *
     * @return Efectividad del extremo como valor decimal.
     * @Override
     */
    public double efectividad() {
        return ((pases + asistenciasEfectivas - faltas) * 100.0 / (pases + asistenciasEfectivas + faltas)) + golesDirectos * 100.0 / totalLanzamientos;
    }

    /** @return Número de pases realizados por el extremo */
    public int getPases() {
        return pases;
    }

     /** @return Número de asistencias efectivas realizadas por el extremo */
    public int getAsistenciasEfectivas() {
        return asistenciasEfectivas;
    } 
}  