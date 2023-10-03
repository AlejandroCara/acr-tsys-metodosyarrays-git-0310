package Ej2;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {

		//Declaración de variables
		Scanner teclado = new Scanner(System.in);
		int cantidadNumeros = 0;
		int min = 0;
		int max = 0;
		int[] numerosAleatorios;
		
		//Pedir la cantidad de numeros aleatorios a generar y instanciar un array con las posiciones introducidas
		cantidadNumeros = pedirParametro(teclado, "Cuantos numeros aleatorios quieres generar: ");
		numerosAleatorios = new int[cantidadNumeros];
		
		min = pedirParametro(teclado, "Introduce el valor minimo: ");
		
		//Controlar que el valor maximo del rango sea mayor que el minimo
		do {
			max = pedirParametro(teclado, "Introduce el valor máximo: ");
			
			if(max <= min) {
				System.out.println("El maximo debe ser superior al minimo. \n\n\n");
			}
		} while(max <= min);
		
		for(int i = 0; i < cantidadNumeros; i++) {
			//Generar el numero aleatorio masandole los valores al metodo y acumulandolo en su posicion del array
			numerosAleatorios[i] = randomNumber(min, max);
		}
		
		teclado.close();
		
		//Mostrar los valores acumulados en el array con el bucle
		System.out.println("Estos son los numeros aleatorios: ");
		for(int i = 0; i < cantidadNumeros; i++) {
			System.out.print(numerosAleatorios[i] + " ");
		}
	}

	public static int randomNumber(int min, int max) {
		return (int) Math.round(Math.random() * (max-min) + min);
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
