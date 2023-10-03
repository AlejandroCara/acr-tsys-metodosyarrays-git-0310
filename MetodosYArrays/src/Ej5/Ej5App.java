package Ej5;

import java.util.Scanner;

public class Ej5App {

	public static void main(String[] args) {

		// Decalaración de variables
		int numeroDecimal = pedirParametro("Introduce un numero entero: ");
		
		System.out.println("El numero " + numeroDecimal + " en binario es " + decimalToBinary(numeroDecimal));
	}
	
	public static String decimalToBinary(int numeroDecimal) {
		
		String numBinario = "";
		
		while(numeroDecimal >= 1) {
			numBinario = String.valueOf(numeroDecimal % 2) + numBinario;
			numeroDecimal = Math.floorDiv(numeroDecimal, 2);
		}
		
		return numBinario;
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
