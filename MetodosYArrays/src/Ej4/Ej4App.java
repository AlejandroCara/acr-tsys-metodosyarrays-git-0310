package Ej4;

import java.util.Scanner;

public class Ej4App {

	public static void main(String[] args) {
		
		//Declaración de variables
		int inNumero = pedirParametro("Introduce un numero entero: ");
		
		//Mostrar el resultado del factorial
		System.out.println("El factorial de " + inNumero + " es " + factorial(inNumero));
		

	}
	
	//Metodo recursivo para calcular el factorial de un numero
	public static int factorial(int numero) {
		if(numero > 1) {
			return numero * factorial(numero - 1);
		} else {
			return 1;
		}
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
