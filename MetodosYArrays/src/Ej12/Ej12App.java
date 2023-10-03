package Ej12;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej12App {

	public static void main(String[] args) {

		// Declaración de variables
		Scanner teclado = new Scanner(System.in);
		int[] numerosAleatorios;
		int cantidadNum = 0;
		int terminadoEn = 0;
		ArrayList<Integer> numerosTerminadosEn = new ArrayList<Integer>();
		boolean valorValido = false;

		// Pedir la cantidad de numeros aleatorios a generar y instanciar un array con
		// las posiciones introducidas
		cantidadNum = pedirParametro(teclado, "Cuantos numeros aleatorios quieres generar: ");
		numerosAleatorios = new int[cantidadNum];
		
		//Controlar que se introduzca un numero entre 0 y 9
		do {
			terminadoEn = pedirParametro(teclado, "Introduce un numero entre 0 y 9: ");

			if(terminadoEn >= 0 && terminadoEn <= 9) {
				valorValido = true;
			} else {
				System.out.println("Valor no válido\n\n");
			}
			
		} while(!valorValido);
		
		teclado.close();
		
		// Llenar el primer array con numeros aleatorios entre 1 y 300
		rellenarConRandoms(numerosAleatorios, 1, 300, terminadoEn, numerosTerminadosEn);
		
		//Mostrar los numeros aleatorios generados y cuales cumplen la condición
		System.out.println("Lo numeros aleatorios");
		mostrarArray(numerosAleatorios);
		
		System.out.println("Los numeros terminados en " + terminadoEn + ": ");
		mostrarArrayList(numerosTerminadosEn);
	}

	/*Metodo para rellenar un array con numeros aleatorios con rango, ademas de pasar el condicionante
	 *para comprobar si los numeros generados terminan enn el pasado por parametro y el arraylist donde
	 *se acumularan los que cumplan la condición*/
	public static void rellenarConRandoms(int[] numeros, int min, int max, int terminadoEn, ArrayList<Integer> numerosTerminadosEn) {
		for (int i = 0; i < numeros.length; i++) {
			// Generar el numero aleatorio masandole los valores al metodo y acumulandolo en su posicion del array
			numeros[i] = (int) Math.round(Math.random() * (max - min) + min);
			
			//Comprobar si el numero termina en el numero especifico y si es así añadirlo al arraylist
			if(isEndedWith(numeros[i], terminadoEn)) {
				numerosTerminadosEn.add(numeros[i]);
			}
		}
	}
	
	//Metodo para comprobar si un numero termina con X numero
	public static boolean isEndedWith(int numero, int terminadoEn) {
		//Pasar los dos numeros a string para comprobar sus ultimos chars si coinciden
		String stringNum = String.valueOf(numero);
		String stringTerminado = String.valueOf(terminadoEn);
		
		return stringNum.charAt(stringNum.length()-1) == stringTerminado.charAt(0);
	}
	
	public static void mostrarArray(int[] numeros) {
		for(int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
	}
	
	//Para recorrer arraylists se hace uso del buble foreach
	public static void mostrarArrayList(ArrayList<Integer> numeros) {
		for (Integer num : numeros) {
			System.out.print(num + " ");
		}
		System.out.println();
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

				if (param > 0) {
					valorValido = true;
				} else {
					System.out.println("Valor no válido, tiene que ser positivo (mayor que 0) \n\n");
				}
			} catch (Exception e) {
				System.out.println("Valor no válido \n\n");
			}

		} while (!valorValido);

		

		return param;
	}

}
