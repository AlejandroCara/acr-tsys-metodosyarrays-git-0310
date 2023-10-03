package Ej1;

import java.util.Scanner;

public class Ej1App {

	public static void main(String[] args) {

		// Declaración de variables
		Scanner teclado = new Scanner(System.in);
		String valorIntroducido = "";
		boolean valorValido = false;
		double area = 0;
		double param1 = 0;
		double param2 = 0;

		// Bloque iterativo para asegurar que se introduce algún valor y que este sea válido
		do {
			System.out.println("C: Circulo");
			System.out.println("T: Triangulo");
			System.out.println("Q: Cuadrado");
			System.out.print("De que quieres calcular el area: ");
			valorIntroducido = teclado.nextLine();

			// Bloque de control para comprobar que valor ha introducido y si no es válido mostrar un error
			switch (valorIntroducido.toLowerCase()) {
			case "c":
				param1 = pedirParametro(teclado, "Introduce el radio del cicrulo: ");
				area = areaCirculo(param1);
				System.out.println("El area del circulo es " + area);
				valorValido = true;
				break;
			case "t":
				param1 = pedirParametro(teclado, "Introduce la base del triangulo: ");
				param2 = pedirParametro(teclado, "Introduce la altura del triangulo: ");
				area = areaTriangulo(param1, param2);
				System.out.println("El area del triangulo es " + area);
				valorValido = true;
				break;
			case "q":
				param1 = pedirParametro(teclado, "Introduce la base del cuadrado: ");
				param2 = pedirParametro(teclado, "Introduce la altura del cuadrado: ");
				area = areaCuadrado(param1, param2);
				System.out.println("El area del cuadrado es " + area);
				valorValido = true;
				break;
			default:
				System.out.println("Valor no válido\n\n");
				break;
			}

		} while (!valorValido);

		
		teclado.close();
	}

	public static double areaCirculo(double radio) {
		return Math.pow(radio, 2) * Math.PI;
	}

	public static double areaCuadrado(double base, double altura) {
		return base * altura;
	}

	public static double areaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}
	
	//Metodo para pedir un valor válido parta los parametros 
	public static double pedirParametro(Scanner teclado, String mensaje) {
		
		//Declaracíon de variables locales del metodo
		String valorIntroducido = "";
		boolean valorValido = false;
		double param = 0;
		
		do {
			System.out.print(mensaje);
			valorIntroducido = teclado.nextLine();
			
			try {
				param = Double.parseDouble(valorIntroducido);
				valorValido = true;
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}
		} while(!valorValido);
		
		return param;
	}
}
