import java.util.Random;
/**
 *    @author - 
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int sol = 1;
        while(numero >= sol * 2){
            sol *= 2;
        }
        return sol;

    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        int aux = numero;
        int aux2 = 0;
        System.out.printf("%6d =", aux);
        while(aux > 0){
            aux2 = mayorPotencia2(aux);
            aux = aux - aux2;
            System.out.printf("%6d", aux2);
        }

    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 0 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        int aleatorio = generador.nextInt(255);
        int contador = 1;
        borrarPantalla();
        System.out.println("Nºs aleatorios como suma de potencias de 2");
        while(aleatorio != 0 && contador <= n){
            System.out.println();
            escribirSumaPotencias(aleatorio);
            aleatorio = generador.nextInt(255);
            contador++;
        }
        System.out.println("\nBucle terminado porque se han generado ya " + n + " aleatorios");
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
        String dibujo = "";
        for (int contador = 1; contador <= n; contador++){
            dibujo += caracter;
        }
        System.out.println(dibujo);
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        int nEscalones = 1;
        int nFilas = 1;
        int escrito = 1;
        int vacio = 1;
        borrarPantalla();
        for (nEscalones = 1; nEscalones <= escalones; nEscalones++){
            System.out.println();

            for (nFilas = 1; nFilas <= alto; nFilas++){

                for (escrito = 1; escrito <= alto; escrito++){
                    escribirCaracter(ancho, ASTERISCO);
                }
                for (vacio = 1; vacio <= alto; vacio++){
                       escribirCaracter(ancho, ESPACIO); 
                    }
            }
        }

    }
    /**
     * 
     */
    public void borrarPantalla() {
        System.out.println("\u000c");
    }

}
