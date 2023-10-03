package Ej7;

import java.util.Scanner;

public class Ej7App {

	public static void main(String[] args) {

		// Declaración de variables
		Scanner teclado = new Scanner(System.in);
		String valorIntroducido = "";
		boolean valorValido = false;
		double eur = 0;

		//Controlar que se introduce algún valor y que este sea válido
		do {
			System.out.print("Introduce la cantidad de euros a convertir: ");
			valorIntroducido = teclado.nextLine();

			try {
				eur = Double.parseDouble(valorIntroducido);
				
				if(eur > 0) {
					valorValido = true;
				} else {
					System.out.println("Valor no válido, tiene que ser positivo\n\n");
				}
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}

		} while (!valorValido);

		
		//Controlar que se introduce algún valor y que este sea válido
		do {
			System.out.println("lib: libras");
			System.out.println("dol: dolares");
			System.out.println("yen: yenes");
			System.out.print("Introduce a que moneda lo quieres pasar: ");
			valorIntroducido = teclado.nextLine();

			switch (valorIntroducido.toLowerCase()) {
			case "lib":
				eurToLib(eur);
				break;
			case "dol":
				eurToDol(eur);
				break;
			case "yen":
				eurToYen(eur);
				break;

			default:
				System.out.println("Valor no válido \n\n");
				break;
			}

		} while (!valorValido);

		teclado.close();

	}
	
	public static void eurToYen(double eur) {
		System.out.println(eur + "€ son " + (eur * 155.97) + "¥");
	}
	
	public static void eurToLib(double eur) {
		System.out.println(eur + "€ son " + (eur * 0.87) + "£");
	}
	
	public static void eurToDol(double eur) {
		System.out.println(eur + "€ son " + (eur * 1.05) + "$");
	}
}
