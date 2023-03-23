import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1a. Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String
        System.out.println("Ejercico 1a");

        String textoDelEjercicio = "Este es un string, un poco más largo para buscar";
        char letraABuscar = 'e';
        int suma = Ejercicio1(textoDelEjercicio, letraABuscar);
        System.out.println("Texto: \"" + textoDelEjercicio + "\"");
        System.out.println("La letra \"" + letraABuscar + "\" se encuentra " + suma + " veces en el texto.");


        // 1b. Dados 3 números y un orden (ascendente o decreciente) que ordene los mismos y los retorne en un vector de 3
        System.out.println("\nEjercico 1b");
        int primerNumero = 2;
        int segundoNumero = 3;
        int tercerNumero = 7;
        boolean ascendente = true;

        int[] arregloDeInt = Ejercicio2(primerNumero, segundoNumero, tercerNumero, ascendente);
        System.out.println("Primer número: " + primerNumero + " | Segundo número: " + segundoNumero + " | Tercer número: " + tercerNumero + " | Ascendente: " + ascendente);
        System.out.println(Arrays.toString(arregloDeInt));


        // 1c. Dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado
        System.out.println("\nEjercico 1c");
        int[] vectorDeNumeros = new int[]{1, 2, 6, 5, 4, 8, 2, 3, 15, 16, 14, 15, 19, 18, 12};
        int numeroX = 7;
        int suma2 = Ejercicio3(vectorDeNumeros, numeroX);
        System.out.println("El arreglo de enteros es: " + Arrays.toString(vectorDeNumeros));
        System.out.println("La suma de los números mayores que "+ numeroX + " es: " + suma2);


        // Genere una clase que tenga los métodos para realizar la “codificación” y decodificación de un string, dado un número de desplazamiento.
        System.out.println("\nEjercico 2");
        String textoAEncriptar = "Hole que";
        int desplazamiento = 30;
        String encriptado = Ejercicio4(textoAEncriptar, desplazamiento);
        String desencriptado = Ejercicio4(encriptado, desplazamiento * -1);
        System.out.println("El texto base es: \"" + textoAEncriptar + "\"");
        System.out.println("El texto encriptado es: \"" + encriptado + "\"");
        System.out.println("El texto desencriptado es: \"" + desencriptado + "\"");


        // 3a. Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String
        System.out.println("\nEjercico 3a");

        textoDelEjercicio = args[0];
        letraABuscar = args[1].charAt(0);
        suma = Ejercicio1(textoDelEjercicio, letraABuscar);
        System.out.println("Texto: \"" + textoDelEjercicio + "\"");
        System.out.println("La letra \"" + letraABuscar + "\" se encuentra " + suma + " veces en el texto.");
    }

    private static int Ejercicio1(String textoDelEjercicio, char letraABuscar) {
        int suma = 0;
        for (int i = 0; i < textoDelEjercicio.length(); i++) {
            char caracterActual = textoDelEjercicio.toLowerCase().charAt(i);
            if (caracterActual == letraABuscar) {
                suma++;
            }
        }
        return suma;
    }

    private static int[] Ejercicio2(int numero1, int numero2, int numero3, boolean ascentende) {

        int[] resultado;

        if (EstaOrdenado(numero1, numero2, ascentende) && EstaOrdenado(numero1, numero3, ascentende)) {
            if (EstaOrdenado(numero2, numero3, ascentende)) {
                resultado = new int[]{numero1, numero2, numero3};
            } else {
                resultado = new int[]{numero1, numero3, numero2};
            }
        } else if (EstaOrdenado(numero2, numero1, ascentende) && EstaOrdenado(numero2, numero3, ascentende)) {
            if (EstaOrdenado(numero1, numero3, ascentende)) {
                resultado = new int[]{numero2, numero1, numero3};
            } else {
                resultado = new int[]{numero2, numero3, numero1};
            }
        } else {
            if (EstaOrdenado(numero1, numero2, ascentende)) {
                resultado = new int[]{numero3, numero1, numero2};
            } else {
                resultado = new int[]{numero3, numero2, numero1};
            }
        }
        return resultado;
    }

    private static int Ejercicio3(int[] vectorDeNumeros, int numeroX){
        int suma = 0;
        for (int i = 0; i < vectorDeNumeros.length; i++) {
            if(vectorDeNumeros[i] > numeroX) {
                suma += vectorDeNumeros[i];
            }
        }
        return suma;
    }

    private static boolean EstaOrdenado(int primerNumero, int segundoNumero, boolean ascentende) {
        if (ascentende) {
            return primerNumero <= segundoNumero;
        } else {
            return segundoNumero <= primerNumero;
        }
    }

    private static String Ejercicio4(String texto, int desplazamiento) {
        String ret = "";
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        abecedario += abecedario.toUpperCase() + " "; // abcdefghijklmnñopqrstuvwxyzABCDEFGKIJ...
        desplazamiento %= abecedario.length();
        for (int i = 0; i < texto.length(); i++) {
            char letraEncriptada = texto.charAt(i);

            int posicionEnAbecedario = abecedario.indexOf(letraEncriptada);
            posicionEnAbecedario += desplazamiento;

            posicionEnAbecedario = (posicionEnAbecedario + abecedario.length()) % abecedario.length();

            ret += abecedario.charAt(posicionEnAbecedario);
        }
        return ret; // va a devolver nuestro texto encriptado
    }
}
