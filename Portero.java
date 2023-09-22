/**
 * Estudiante: Joel Jaquez
 * Carne: 23369
 * Carrera: Ingenieria en Sistemas
 * Fecha de inicio: 22/9/2023
 * Fecha de finalizacion: 22/9/2023
 * Clase que Representa un portero en la Liga de Campeones de Europa.
*/

public class Portero extends Jugador{
    private int paradasEfectivas; /** Número de paradas efectivas realizadas por el portero */
    private int golesRecibidos; /** Número de goles recibidos por el portero */

    /**
     * Constructor de la clase Portero.
     *
     * @param nombre Nombre del portero
     * @param pais País de origen del portero
     * @param faltas Número de faltas cometidas
     * @param golesDirectos Número de goles directos anotados
     * @param totalLanzamientos Número total de lanzamientos realizados
     * @param paradasEfectivas Número de paradas efectivas realizadas
     * @param golesRecibidos Número de goles recibidos por el portero
     */
    public Portero(String nombre, String pais, String club, int faltas, int golesDirectos, int totalLanzamientos, int paradasEfectivas, int golesRecibidos){
        super(nombre, pais, club, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }

    /**
     * Calcula la efectividad del portero.
     *
     * @return Efectividad del portero como valor decimal.
     * @Override
     */
    public double efectividad(){
        return ((paradasEfectivas - golesRecibidos) * 100.0 / (paradasEfectivas + golesRecibidos)) + golesDirectos * 100.0 / totalLanzamientos;
    }

    /** @return Número de paradas efectivas realizadas por el portero */
    public int getParadasEfectivas(){
        return paradasEfectivas;
    }

    /** @return Número de goles recibidos por el portero */
    public int getGolesRecibidos(){
        return golesRecibidos;
    }
}