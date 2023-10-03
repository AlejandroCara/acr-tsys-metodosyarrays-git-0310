package Ej10;

import java.util.Scanner;

public class Ej10App {

	public static void main(String[] args) {

		// Declaración de variables
		int[] numerosRandom;
		int cantidadNum = 0;

		// Pedir la cantidad de numeros aleatorios a generar y instanciar un array con
		// las posiciones introducidas
		cantidadNum = pedirParametro("Cuantos numeros aleatorios quieres generar: ");
		numerosRandom = new int[cantidadNum];

		rellenarConRandoms(numerosRandom, 0, 9);
		mostrarNumeros(numerosRandom);
	}

	public static void rellenarConRandoms(int[] numeros, int min, int max) {
		for (int i = 0; i < numeros.length; i++) {
			// Generar el numero aleatorio masandole los valores al metodo y acumulandolo en
			// su posicion del array
			do {
				numeros[i] = (int) Math.round(Math.random() * (max - min) + min);
			} while(!isPrimo(numeros[i]));
		}
	}

	public static void mostrarNumeros(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
	}

	public static boolean isPrimo(int numero) {

		// Declaración de variables locales del metodo
		int mitad = Math.floorDiv(numero, 2); // Calcular la mitad entera del numero introducido
		boolean primero = true;
		int numPrueba = 2;
		
		if(numero > 0) {
			// Comprobar si el numero es divisible por algún otro numero que 1 y el mismo
			// por debajo de su mitad
			while (primero && numPrueba <= mitad) {
				if (numero % numPrueba == 0) {
					primero = false;
				}
				numPrueba++;
			}
			
		} else {
			primero = false;
		}
		
		return primero;
	}

	// Metodo para pedir un valor válido parta los parametros
	public static int pedirParametro(String mensaje) {

		// Declaracíon de variables locales del metodo
		Scanner teclado = new Scanner(System.in);
		String valorIntroducido = "";
		boolean valorValido = false;
		int param = 0;

		do {
			System.out.print(mensaje);
			valorIntroducido = teclado.nextLine();

			try {
				param = Integer.parseInt(valorIntroducido);

				if (param > 0) {
					valorValido = true;
				} else {
					System.out.println("Valor no válido, tiene que ser positivo (mayor que 0) \n\n");
				}
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}

		} while (!valorValido);

		teclado.close();

		return param;
	}

}
