package Ej3;

import java.util.Scanner;

public class Ej3App {

	public static void main(String[] args) {

		// Declaración de variable
		int inNumero = pedirParametro("Introduce un numero entero: ");

		// Mostrar un mensaje u otro según si el numero es primo o no
		if (isPrimo(inNumero)) {
			System.out.println("Es un numero primo");
		} else {
			System.out.println("No es un numero primo");
		}

	}

	public static boolean isPrimo(int numero) {

		// Declaración de variables locales del metodo
		int mitad = Math.floorDiv(numero, 2); // Calcular la mitad entera del numero introducido
		boolean primero = true;
		int numPrueba = 2;

		if (numero > 0) {
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
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}
		} while (!valorValido);

		teclado.close();

		return param;
	}
}
