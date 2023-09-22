/**
 * Estudiante: Joel Jaquez
 * Carne: 23369
 * Carrera: Ingenieria en Sistemas
 * Fecha de inicio: 22/9/2023
 * Fecha de finalizacion: 22/9/2023
 * Clase que Representa un jugador en la Liga de Campeones de Europa.
*/

public abstract class Jugador{
    protected String nombre; /** Nombre del jugador */
    protected String pais; /** País del jugador */
    protected String club;
    protected int faltas; /** Faltas cometidas por el jugador */
    protected int golesDirectos; /** Goles directos anotados por el jugador */
    protected int totalLanzamientos; /** Total de lanzamientos realizados por el jugador */

    /**
     * Constructor de la clase Jugador.
     *
     * @param nombre Nombre del jugador
     * @param pais País de origen del jugador
     * @param faltas Número de faltas cometidas
     * @param golesDirectos Número de goles directos anotados
     * @param totalLanzamientos Número total de lanzamientos realizados
     * @param club club al que pertenece el jugador
     */

    public Jugador(String nombre, String pais, String club, int faltas, int golesDirectos, int totalLanzamientos){
        this.nombre = nombre;
        this.pais = pais;
        this.club = club;
        this.faltas = faltas;
        this.golesDirectos = golesDirectos;
        this.totalLanzamientos = totalLanzamientos;
    }

    /**
     * Calcula la efectividad del jugador.
     *
     * @return Efectividad del jugador como valor decimal.
     */

    public abstract double efectividad();

    /** @return Nombre del jugador */
    public String getNombre(){
        return  nombre ;
    }

     /** @return País del jugador */
    public String getPais(){
        return pais;
    }

     public String getClub() {
        return club;
    }
}