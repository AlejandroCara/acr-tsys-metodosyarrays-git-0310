package Ej9;

import java.util.Scanner;

public class Ej9App {

	public static void main(String[] args) {

		// Declaración de variables
		int[] numerosRandom;
		int cantidadNum = 0;

		// Pedir la cantidad de numeros aleatorios a generar y instanciar un array con las posiciones introducidas
		cantidadNum = pedirParametro("Cuantos numeros aleatorios quieres generar: ");
		numerosRandom = new int[cantidadNum];
		
		rellenarConRandoms(numerosRandom, 0, 9);
		mostrarNumeros(numerosRandom);
	}

	public static void rellenarConRandoms(int[] numeros, int min, int max) {
		for(int i = 0; i < numeros.length; i++) {
			//Generar el numero aleatorio masandole los valores al metodo y acumulandolo en su posicion del array
			numeros[i] = (int) Math.round(Math.random() * (max-min) + min);
		}
	}
	
	public static void mostrarNumeros(int[] numeros) {
		
		//Declaración de variables locales del metodo
		int total = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
			total+=numeros[i];
		}
		
		System.out.println("\nLa suma total es: " + total);
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
