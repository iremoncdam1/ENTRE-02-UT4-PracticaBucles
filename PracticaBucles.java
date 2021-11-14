import java.util.Random;
/**
 *   autor - Iratxe Remón 
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        int creados = 0;
        int numero = 1;
        float sumaNumeros = 0;
        float media = 0;
        int contador = 0;
        int sumaImpares = 0;
        int maximoPar = -1000;
        System.out.println("Nº máximo de aleatorios a generar " + n);
        System.out.println("o hasta que salga el 0.\n");
        while (creados < n && numero != 0) {
            numero = generador.nextInt(51000) - 1000;
            System.out.printf("%12s:%5s", numero, obtenerNumeroSinCeros(numero));  
            contador++;
            if (contador == 5) {
                contador = 0;
                System.out.println();
            }
            sumaNumeros += numero;
            media = sumaNumeros / n;
            creados++;
            if (numero % 2 != 0) {
                sumaImpares += numero;
            }
            if (numero % 2 == 0) {
                if (numero > maximoPar) {
                    maximoPar = numero;
                }
            }
        }
        String text = String.format("\n\n%25s%10.2f", "Media:", media);
        text += String.format("\n%25s%10s", "Suma impares:", sumaImpares);
        text += String.format("\n%25s%10s", "Máximo pares:", maximoPar);
        System.out.printf(text);
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        boolean impar = numero % 2 != 0;
        return  impar;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3 
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int resul = 0;
        int exp = 0;
        while (numero > 0) {
            int cociente = numero / 10;
            int resto = numero % 10;
            if (resto != 0) {
                int pot = (int) Math.pow (10, exp);
                resul = resul + resto * pot;
                exp++;
            }
            numero = cociente;
        }
        return resul;
    }

    /**
     *  Borrar la pantalla
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  Hay que usar el método escribirCaracter()
     */
    public void escribirLetraN(int altura)    {
       System.out.println("Letra N - Altura: " + altura + "\n");
       escribirCaracter(CARACTER, altura);
    }

    /**
     *  Escribe n veces el caracter indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
       for (int i = 0; i<n; i++) {
           System.out.print(caracter);
           for (int j = 0; j<i; j++) {
               System.out.print(ESPACIO);
           }
           System.out.print(caracter);
           for (int z = n; z>i+1; z--) {
               System.out.print(ESPACIO);
           }
           System.out.println(caracter);
       }
    }
}
