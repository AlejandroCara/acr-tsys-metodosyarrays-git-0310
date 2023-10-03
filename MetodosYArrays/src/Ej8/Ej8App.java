package Ej8;

import java.util.Scanner;

public class Ej8App {

	public static void main(String[] args) {

		// Declaración de variables
		Scanner teclado = new Scanner(System.in);
		int[] numeros = new int[10];
		
		pedirNumeros(teclado, numeros);
		mostrarNumeros(numeros);
		
		teclado.close();
	}
	
	//Metodo para pedir y rellenar el array de numeros introducidos por terminal
	public static void pedirNumeros(Scanner teclado, int[] numeros) {
		/* Bucle para pedir tantos numeros como longitud tenga el array pasado por parametro,
		   al ser un array este se pasa por referencia y puede ser modificado desde dentro del
		   metodo.
		*/
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = pedirParametro(teclado, "Introduce el " + (i + 1) + " numero: ");
		}
	}
	
	//Metodo para mostrar los valores introducidos al array
	public static void mostrarNumeros(int[] numeros) {
		System.out.println("\n\n\n");
		for(int i = 0; i < numeros.length; i++) {
			System.out.println("Indice " + i + ": " + numeros[i]);
		}
	}
	
	// Metodo para pedir un valor válido parta los parametros
	public static int pedirParametro(Scanner teclado, String mensaje) {

		// Declaracíon de variables locales del metodo
		String valorIntroducido = "";
		boolean valorValido = false;
		int param = 0;

		do {
			System.out.print(mensaje);
			valorIntroducido = teclado.nextLine();

			try {
				param = Integer.parseInt(valorIntroducido);
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}

		} while (!valorValido);


		return param;
	}
}
