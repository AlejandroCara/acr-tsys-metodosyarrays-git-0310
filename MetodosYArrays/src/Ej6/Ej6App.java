package Ej6;

import java.util.Scanner;

public class Ej6App {

	public static void main(String[] args) {
		
		//Declaración de variables
		int inNumero = pedirParametro("Introduce un numero entero positivo: ");
		
		System.out.println("El numero " + inNumero +" tiene " + numDigitos(inNumero));
	}
	
	public static int numDigitos(int numero) {
		
		//Declaración de variables locales del metodo
		int numDigitos = 0;
		
		//Calcular cuatos digitos tiene calculando cuantas veces puede dividirse entre 10
		while(numero > 0) {
			numDigitos++;
			numero = Math.floorDiv(numero, 10);
		}
		
		return numDigitos;
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
				
				if(param > 0){
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
